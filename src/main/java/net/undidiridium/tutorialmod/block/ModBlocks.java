package net.undidiridium.tutorialmod.block;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.block.custom.SpeedyBlock;
import net.undidiridium.tutorialmod.item.ModCreativeModTab;
import net.undidiridium.tutorialmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()), ModCreativeModTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> CITRINE_STAIRS = registerBlock("citrine_stairs",
            () -> new StairBlock(() -> ModBlocks.CITRINE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(5f)
                            .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), ModCreativeModTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> RAW_CITRINE_BLOCK = registerBlock("raw_citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()), ModCreativeModTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> CITRINE_ORE = registerBlock("citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()), ModCreativeModTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> DEEPSLATE_CITRINE_ORE = registerBlock("deepslate_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(7f).requiresCorrectToolForDrops().destroyTime(5).color(MaterialColor.COLOR_BLUE)), ModCreativeModTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> ENDSTONE_CITRINE_ORE = registerBlock("endstone_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), ModCreativeModTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> NETHERRACK_CITRINE_ORE = registerBlock("netherrack_citrine_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().jumpFactor(5)), ModCreativeModTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().jumpFactor(4)), ModCreativeModTab.TUTORIAL_TAB, "tooltip.tutorialmod.block.speedy_block");
    public static final RegistryObject<Block> CITRINE_SLAB = registerBlock("citrine_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CITRINE_FENCE = registerBlock("citrine_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CITRINE_FENCE_GATE = registerBlock("citrine_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CITRINE_WALL = registerBlock("citrine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CITRINE_BUTTON = registerBlock("citrine_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().noCollission().sound(SoundType.WET_GRASS)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CITRINE_PRESSURE_PLATE = registerBlock("citrine_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops().sound(SoundType.BAMBOO)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> EBONY_DOOR = registerBlock("ebony_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(5f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.SNOW)), ModCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> EBONY_TRAP_DOOR = registerBlock("ebony_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(5f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.LARGE_AMETHYST_BUD)), ModCreativeModTab.TUTORIAL_TAB);


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
     * FYI Supplier is a delegate, you can save a function to it, and then do .get() to get the result. Registering the block itself with tooltip.
     *
     * @param name
     * @param block
     * @param tab
     * @param <T>
     * @return
     */
    public static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block, final CreativeModeTab tab, final String tooltipKey) {
        final RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    /**
     * Item associated with a block - Registers a block, with a new block item with tooltip
     *
     * @param name
     * @param block
     * @param tab
     * @param <T>
     * @return
     */
    public static <T extends Block> RegistryObject<Item> registerBlockItem(final String name, final RegistryObject<T> block, final CreativeModeTab tab,
                                                                           final String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).stacksTo(32)) {
            @Override
            public void appendHoverText(final ItemStack pStack, @Nullable final Level pLevel, final List<Component> pTooltip, final TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
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
        registerBlockItem(name, toReturn, tab, "This has no defined label!");
        return toReturn;
    }


    public static void register(final IEventBus event_bus) {
        BLOCKS.register(event_bus);
    }

}
