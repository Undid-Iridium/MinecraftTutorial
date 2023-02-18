package net.undidiridium.tutorialmod.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class FloatEnchantment extends Enchantment {
    public FloatEnchantment(final Rarity pRarity, final EnchantmentCategory pCategory,
                            final EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }


    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public void doPostAttack(final LivingEntity pAttacker, final Entity pTarget, final int pLevel) {
        if (!pAttacker.level.isClientSide()) {
            final ServerLevel world = ((ServerLevel) pAttacker.level);
            final BlockPos position = pTarget.blockPosition();

            if (pLevel == 1) {
                ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200), pAttacker);
            }

            if (pLevel == 2) {
                ((LivingEntity) pTarget).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 400), pAttacker);
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
