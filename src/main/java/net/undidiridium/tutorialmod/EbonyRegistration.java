package net.undidiridium.tutorialmod;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.block.ModBlocks;
import net.undidiridium.tutorialmod.block.custom.ModFlammableRotatedPillarBlock;
import net.undidiridium.tutorialmod.block.custom.ModSaplingBlock;
import net.undidiridium.tutorialmod.block.custom.ModStandingSignBlock;
import net.undidiridium.tutorialmod.block.custom.ModWallSignBlock;
import net.undidiridium.tutorialmod.block.entity.ModWoodTypes;
import net.undidiridium.tutorialmod.item.ModCreativeModeTab;
import net.undidiridium.tutorialmod.world.feature.tree.EbonyTreeGrower;

import java.util.Set;

public class EbonyRegistration {

    public static final RegistryObject<Block> EBONY_LOG = ModBlocks.registerBlock("ebony_log",
            () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> EBONY_WOOD = ModBlocks.registerBlock("ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> STRIPPED_EBONY_LOG = ModBlocks.registerBlock("stripped_ebony_log",
            () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = ModBlocks.registerBlock("stripped_ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.TUTORIAL_TAB);
    public static final RegistryObject<Block> EBONY_PLANKS = ModBlocks.registerBlock("ebony_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos,
                                           final Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos,
                                           final Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos,
                                              final Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> EBONY_LEAVES = ModBlocks.registerBlock("ebony_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos,
                                           final Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(final BlockState state, final BlockGetter world, final BlockPos pos,
                                           final Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(final BlockState state, final BlockGetter world, final BlockPos pos,
                                              final Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> EBONY_SAPLING = ModBlocks.registerBlock("ebony_sapling",
            () -> new ModSaplingBlock(new EbonyTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING), () -> Set.of(Blocks.END_STONE,
                    Blocks.CYAN_CONCRETE)),
            ModCreativeModeTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> EBONY_WALL_SIGN = ModBlocks.registerBlockWithoutBlockItem(
            "ebony_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.EBONY));

    public static final RegistryObject<Block> EBONY_SIGN = ModBlocks.registerBlockWithoutBlockItem(
            "ebony_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.EBONY));

    public static void Enable() {

    }
}
