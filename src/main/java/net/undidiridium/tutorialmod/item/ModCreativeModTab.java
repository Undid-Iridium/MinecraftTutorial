package net.undidiridium.tutorialmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab("tutorialtab") {
        @Override
        /**
         * Assigns the icon for the creative tab
         */
        public ItemStack makeIcon() {
            return new ItemStack((ModItems.CITRINE.get()));
        }
    };
}
