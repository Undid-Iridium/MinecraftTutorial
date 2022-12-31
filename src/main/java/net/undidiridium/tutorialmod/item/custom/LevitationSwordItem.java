package net.undidiridium.tutorialmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LevitationSwordItem extends SwordItem {
    public LevitationSwordItem(final Tier pTier, final int pAttackDamageModifier, final float pAttackSpeedModifier, final Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(final ItemStack pStack, final LivingEntity pTarget, final LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200), pAttacker);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public void appendHoverText(final ItemStack pStack, @Nullable final Level pLevel, final List<Component> pTooltipComponents, final TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.levitating_sword.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.generic_message.tooltip"));
        }
    }

}
