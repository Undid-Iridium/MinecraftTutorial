package net.undidiridium.tutorialmod.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> CITRINE_PARTICLES = PARTICLE_TYPES.register(
            "citrine_particles", () -> new SimpleParticleType(true));

    public static void register(final IEventBus bus) {
        PARTICLE_TYPES.register(bus);
    }
}
