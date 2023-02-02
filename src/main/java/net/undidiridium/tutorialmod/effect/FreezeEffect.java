package net.undidiridium.tutorialmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FreezeEffect extends MobEffect {
    public FreezeEffect(final MobEffectCategory mobEffectCategory, final int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(final LivingEntity pLivingEntity, final int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            final Double x = pLivingEntity.getX();
            final Double y = pLivingEntity.getY();
            final Double z = pLivingEntity.getZ();

            pLivingEntity.teleportTo(x, y, z);
            pLivingEntity.setDeltaMovement(0, 0, 0);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(final int pDuration, final int pAmplifier) {
        return true;
    }
}