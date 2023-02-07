package net.undidiridium.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.undidiridium.tutorialmod.block.entity.custom.ModSignBlockEntity;

public class ModStandingSignBlock extends StandingSignBlock {
    public ModStandingSignBlock(final Properties pProperties, final WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(final BlockPos pPos, final BlockState pState) {
        return new ModSignBlockEntity(pPos, pState);
    }
}
