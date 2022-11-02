package net.undidiridium.tutorialmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;

public class ModItems {
    /**
     * List of items we're creating, with our mod ID, based on the ForgeRegister for items
     * This helps forge keep track of items to know when to add/remove
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> CITRINE =
            ITEMS.register("citrine", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> RAW_CITRINE =
            ITEMS.register("raw_citrine", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    /**
     * Called in tutorial mod to register
     *
     * @param event_bus
     */
    public static void register(final IEventBus event_bus) {
        ITEMS.register(event_bus);
    }
}
