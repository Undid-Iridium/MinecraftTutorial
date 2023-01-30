package net.undidiridium.tutorialmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.undidiridium.tutorialmod.item.ModItems;
import net.undidiridium.tutorialmod.sound.ModSounds;
import net.undidiridium.tutorialmod.util.InventoryUtil;
import net.undidiridium.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DowsingRodItemAdvanced extends Item {
    public DowsingRodItemAdvanced(final Properties pProperties) {
        super(pProperties);
    }

    private static void outputValuableCoordinates(final BlockPos blockPos, final Player player, final Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

//    private static boolean isValuableBlock(final Block block) {
//        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get()).is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
//    }

    private static boolean isValuableBlock(final BlockState state) {
        return state.is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }

    private static void addNbtToDataTablet(final Player player, final BlockPos pos, final Block blockBelow) {
        final ItemStack dataTablet =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        final CompoundTag nbtData = new CompoundTag();
        nbtData.putString("tutorialmod.last_ore", "Found " + blockBelow.asItem().getRegistryName().toString() + " at (" +
                pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")");

        dataTablet.setTag(nbtData);
    }

    @Override
    public void appendHoverText(final ItemStack pStack, @Nullable final Level pLevel, final List<Component> pTooltipComponents, final TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.dowsing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.dowsing_rod.tooltip"));
        }
    }

    @Override
    public InteractionResult useOn(final UseOnContext pContext) {
        //Checking if we're on client
        if (pContext.getLevel().isClientSide()) {
            final BlockPos positionClicked = pContext.getClickedPos();
            final Player player = pContext.getPlayer();
            boolean foundBlock = false;
            for (int pos = 0; pos <= positionClicked.getY() + 64; pos++) {
                //Adding to below, which is asking, y-(value)
                final BlockState blockBelow = pContext.getLevel().getBlockState(positionClicked.below(pos));

                if (DowsingRodItemAdvanced.isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(pos), player, blockBelow.getBlock());
                    foundBlock = true;

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addNbtToDataTablet(player, positionClicked.below(pos), blockBelow.getBlock());
                    }

//                    blockBelow.getBlock().
                }
            }

            pContext.getLevel().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE.get(),
                    SoundSource.BLOCKS, 1f, 1f);

            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.tutorialmod.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }
}
