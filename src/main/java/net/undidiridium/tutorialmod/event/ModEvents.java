package net.undidiridium.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.item.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(final VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            final Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            final ItemStack stack = new ItemStack(ModItems.CUCUMBER.get(), 12);
            final int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F));
        }

        if (event.getType() == VillagerProfession.TOOLSMITH) {
            final Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            final ItemStack stack = new ItemStack(ModItems.CITRINE_PICKAXE.get(), 1);
            final int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    stack, 4, 12, 0.09F));
        }
    }
}
