package net.undidiridium.tutorialmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;

public class ModEffects {

    /**
     * FYI ALL FORGE REGISTRIES AFFECT NAME OF DIRECTION FOR ASSETS YOU NEED TO PUT INTO, SUCH AS
     * MOB_EFFECT whose real name is MobEffect before modification by Forge/Mojang.
     */
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TutorialMod.MOD_ID);

    public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register("freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL, 3124687));

    public static void register(final IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
