package net.undidiridium.tutorialmod.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class LightningStrikerEnchantment extends Enchantment {
    public LightningStrikerEnchantment(final Rarity pRarity, final EnchantmentCategory pCategory,
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
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, position,
                        MobSpawnType.TRIGGERED, true, true);
            }

            if (pLevel == 2) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, position,
                        MobSpawnType.TRIGGERED, true, true);
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, position,
                        MobSpawnType.TRIGGERED, true, true);
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
