package net.undidiridium.tutorialmod.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InventoryUtil {
    public static boolean hasPlayerStackInInventory(final Player player, final Item item) {
        for (int pos = 0; pos < player.getInventory().getContainerSize(); pos++) {
            final ItemStack currentStack = player.getInventory().getItem(pos);
            if (!currentStack.isEmpty() && currentStack.sameItem(new ItemStack(item))) {
                return true;
            }
        }

        return false;
    }

    public static int getFirstInventoryIndex(final Player player, final Item item) {
        for (int pos = 0; pos < player.getInventory().getContainerSize(); pos++) {
            final ItemStack currentStack = player.getInventory().getItem(pos);
            if (!currentStack.isEmpty() && currentStack.sameItem(new ItemStack(item))) {
                return pos;
            }
        }

        return -1;
    }
}
