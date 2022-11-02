package net.undidiridium.tutorialmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.item.ModCreativeModTab;
import net.undidiridium.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> RAW_CITRINE_BLOCK = registerBlock("raw_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CITRINE_ORE = registerBlock("citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).strength(8f).requiresCorrectToolForDrops().destroyTime(5).color(MaterialColor.COLOR_BLUE)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> ENDSTONE_CITRINE_ORE = registerBlock("endstone_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(8f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> NETHERRACK_CITRINE_ORE = registerBlock("netherrack_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.SNOW).strength(2f).requiresCorrectToolForDrops().jumpFactor(5)), ModCreativeModTab.TUTORIAL_TAB);


    /**
     * Item associated with a block - Registers a block, with a new block item
     *
     * @param name
     * @param block
     * @param tab
     * @param <T>
     * @return
     */
    public static <T extends Block> RegistryObject<Item> registerBlockItem(final String name, final RegistryObject<T> block, final CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).stacksTo(32)));
    }

    /**
     * FYI Supplier is a delegate, you can save a function to it, and then do .get() to get the result. Registering the block itself.
     *
     * @param name
     * @param block
     * @param tab
     * @param <T>
     * @return
     */
    public static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block, final CreativeModeTab tab) {
        final RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }


    public static void register(final IEventBus event_bus) {
        BLOCKS.register(event_bus);
    }

}
