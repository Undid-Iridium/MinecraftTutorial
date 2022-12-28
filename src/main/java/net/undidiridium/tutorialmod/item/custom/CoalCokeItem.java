package net.undidiridium.tutorialmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class CoalCokeItem extends Item {
    public CoalCokeItem(final Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getBurnTime(final ItemStack itemStack, @Nullable final RecipeType<?> recipeType) {
        return 3200; //Double normal coke, /20 for seconds as 20 seconds per tick
    }
}
