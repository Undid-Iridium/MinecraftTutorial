package net.undidiridium.tutorialmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    //0 wood, 1 stone, 2 iron.. etc
    public static final ForgeTier CITRINE = new ForgeTier(2, 1400, 2.5f,
            2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.CITRINE.get()));

    public static final ForgeTier CITRINE_SHOVEL = new ForgeTier(3, 2400, 4.5f,
            5f, 30, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.CITRINE.get()));
}
