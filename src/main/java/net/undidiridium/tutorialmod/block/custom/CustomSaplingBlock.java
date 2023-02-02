package net.undidiridium.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class CustomSaplingBlock extends SaplingBlock {

    public CustomSaplingBlock(final AbstractTreeGrower pTreeGrower, final Properties pProperties) {
        super(pTreeGrower, pProperties);
    }

    @Override
    protected boolean mayPlaceOn(final BlockState pState, final BlockGetter pLevel, final BlockPos pPos) {
        return super.mayPlaceOn(pState, pLevel, pPos) || pState.is(BlockTags.BIRCH_LOGS);
    }
}
