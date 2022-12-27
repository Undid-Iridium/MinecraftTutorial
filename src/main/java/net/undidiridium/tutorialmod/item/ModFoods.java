package net.undidiridium.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import java.util.function.Supplier;

public class ModFoods {
    public static final FoodProperties CUCUMBER = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2F)
            .effect(new Supplier<MobEffectInstance>() {
                @Override
                public MobEffectInstance get() {
                    return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 5);
                }
            }, 1f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1f)
            .fast()
            .build();
}
