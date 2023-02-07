package net.undidiridium.tutorialmod.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.undidiridium.tutorialmod.block.entity.ModBlockEntities;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(final BlockPos pPos, final BlockState pBlockState) {
        super(pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.SIGN_BLOCK_ENTITIES.get();
    }
}
