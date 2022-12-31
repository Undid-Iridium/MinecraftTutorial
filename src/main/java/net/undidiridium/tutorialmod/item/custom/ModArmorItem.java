package net.undidiridium.tutorialmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.undidiridium.tutorialmod.item.ModArmorMaterials;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.CITRINE,
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 1)).build();

    public ModArmorItem(final ArmorMaterial material, final EquipmentSlot slot, final Properties settings) {
        super(material, slot, settings);
    }

    private static boolean hasFullSuitOfArmorOn(final Player player) {
        final ItemStack boots = player.getInventory().getArmor(0);
        final ItemStack leggings = player.getInventory().getArmor(1);
        final ItemStack breastplate = player.getInventory().getArmor(2);
        final ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private static boolean hasCorrectArmorOn(final ArmorMaterial material, final Player player) {
        for (final ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        final ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        final ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        final ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        final ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }

    private static void addStatusEffectForMaterial(final Player player, final ArmorMaterial mapArmorMaterial,
                                                   final MobEffectInstance mapStatusEffect) {
        final boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if (ModArmorItem.hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect.getEffect(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));

            //if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
            //    player.getInventory().hurtArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            //}
        }
    }

    private static void evaluateArmorEffects(final Player player) {
        for (final Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            final ArmorMaterial mapArmorMaterial = entry.getKey();
            final MobEffectInstance mapStatusEffect = entry.getValue();

            if (ModArmorItem.hasCorrectArmorOn(mapArmorMaterial, player)) {
                ModArmorItem.addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    @Override
    public void onArmorTick(final ItemStack stack, final Level world, final Player player) {
        if (!world.isClientSide()) {
            if (ModArmorItem.hasFullSuitOfArmorOn(player)) {
                ModArmorItem.evaluateArmorEffects(player);
            }
        }
    }
}
