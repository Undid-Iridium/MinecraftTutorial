package net.undidiridium.tutorialmod.screen.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModResultSlot extends SlotItemHandler {
    public ModResultSlot(final IItemHandler itemHandler, final int index, final int x, final int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(final ItemStack stack) {
        return false;
    }
}