package net.undidiridium.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;

import java.util.Set;
import java.util.function.Supplier;


public class ModSaplingBlock extends SaplingBlock {
    private final Supplier<Set<Block>> otherPlantableBlockTypes;

    public ModSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties, Supplier<Set<Block>> otherDirt) {
        super(pTreeGrower, pProperties);
        this.otherPlantableBlockTypes = otherDirt;
    }

    @Override
    public boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return otherPlantableBlockTypes.get().contains(pState.getBlock());
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.get("custom_mod_sapling_block");
    }
}

//    private final Supplier<Set<Block>> otherPlantableBlockTypes;
//
//    public ModSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties,
//                           Supplier<Set<Block>> otherPlantableBlockTypes) {
//        super(pTreeGrower, pProperties);
//        this.otherPlantableBlockTypes = otherPlantableBlockTypes;
//    }
//
//    public ModSaplingBlock(AbstractTreeGrower pTreeGrower, Properties pProperties,
//                           Block otherPlantableBlockTypes) {
//        this(pTreeGrower, pProperties, () -> Collections.singleton(otherPlantableBlockTypes));
//    }
//
//    @Override
//    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
//        otherPlantableBlockTypes.get()
//        return pState.is(Blocks.END_STONE);
//    }
//}
