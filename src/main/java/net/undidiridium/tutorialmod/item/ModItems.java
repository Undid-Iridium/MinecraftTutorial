package net.undidiridium.tutorialmod.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.block.ModBlocks;
import net.undidiridium.tutorialmod.item.custom.*;
import net.undidiridium.tutorialmod.sound.ModSounds;

public class ModItems {
    /**
     * List of items we're creating, with our mod ID, based on the ForgeRegister for items
     * This helps forge keep track of items to know when to add/remove
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> CITRINE =
            ITEMS.register("citrine", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> RAW_CITRINE =
            ITEMS.register("raw_citrine", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> DOWSING_ROD =
            ITEMS.register("dowsing_rod", () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(16)));

    public static final RegistryObject<Item> DOWSING_ROD_ADV =
            ITEMS.register("dowsing_rod_adv", () -> new DowsingRodItemAdvanced(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(16)));

    public static final RegistryObject<Item> CUCUMBER =
            ITEMS.register("cucumber", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> COAL_COKE =
            ITEMS.register("coal_coke", () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_SWORD =
            ITEMS.register("citrine_sword", () -> new LevitationSwordItem(ModTiers.CITRINE, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_PICKAXE =
            ITEMS.register("citrine_pickaxe", () -> new PickaxeItem(ModTiers.CITRINE, 1, 1f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_SHOVEL =
            ITEMS.register("citrine_shovel", () -> new ShovelItem(ModTiers.CITRINE, 0, 1f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_AXE =
            ITEMS.register("citrine_axe", () -> new AxeItem(ModTiers.CITRINE, 4, 0f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_HOE =
            ITEMS.register("citrine_hoe", () -> new HoeItem(ModTiers.CITRINE, 0, 0f, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    //Apparently for armor effects you don't need to change all to ModArmorItem, only one, weird.
    public static final RegistryObject<Item> CITRINE_HELMET =
            ITEMS.register("citrine_helmet", () -> new ModArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_CHESTPLATE =
            ITEMS.register("citrine_chestplate", () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_LEGGING =
            ITEMS.register("citrine_leggings", () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));
    public static final RegistryObject<Item> CITRINE_BOOTS =
            ITEMS.register("citrine_boots", () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> MAGIC_DUST =
            ITEMS.register("magic_dust", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> DATA_TABLET =
            ITEMS.register("data_tablet", () -> new DataTabletItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> KAUPENBOW = ITEMS.register("kaupenbow",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1).durability(500)));

    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_PLANT.get(), new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISK = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(4, ModSounds.BAR_BRAWL, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> AFTER_DARK_MUSIC_DISK = ITEMS.register("after_dark_music_disc",
            () -> new RecordItem(4, ModSounds.AFTER_DARK, new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> CITRINE_STAFF = ITEMS.register("citrine_staff",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1).durability(500)));

    /**
     * Called in tutorial mod to register
     *
     * @param event_bus
     */
    public static void register(final IEventBus event_bus) {
        ITEMS.register(event_bus);
    }
}
