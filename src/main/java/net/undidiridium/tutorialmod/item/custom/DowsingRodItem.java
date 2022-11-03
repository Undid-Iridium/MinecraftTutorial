package net.undidiridium.tutorialmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DowsingRodItem extends Item {
    public DowsingRodItem(final Properties pProperties) {
        super(pProperties);
    }

    private static void outputValuableCoordinates(final BlockPos blockPos, final Player player, final Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

    private static boolean isValuableBlock(final Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE
                || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
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
                final Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(pos)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(pos), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }

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
