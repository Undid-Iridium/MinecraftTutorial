package net.undidiridium.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpeedyBlock extends Block {
    public SpeedyBlock(final Properties pProperties) {
        super(pProperties);
    }

    @Override
    /**
     * Called everytime an entity steps on block
     */
    public void stepOn(final Level pLevel, final BlockPos pPos, final BlockState pState, final Entity pEntity) {

        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                final LivingEntity livingEntity = ((LivingEntity) pEntity);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
