package net.undidiridium.tutorialmod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;

public class ModSounds {
    /**
     * Registers sound events, aka, when forge is looking for definitions to assign to the base game sounds
     * it will refer to this due to us in our tutorial mod class registering register, and then by also already
     * assigning each of our own new sounds to this DeferredRegister. In other words
     * Each time we register something, which is basically a callback/lambda, we save it inside SOUND_EVENTS, which
     * will then be looped through and used to allocate each assigned callback
     */
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TutorialMod.MOD_ID);

    public static final RegistryObject<SoundEvent> DOWSING_ROD_FOUND_ORE = registerSoundEvent("dowsing_rod_found_ore");


    public static RegistryObject<SoundEvent> CITRINE_LAMP_BREAK = registerSoundEvent("citrine_lamp_break");
    public static RegistryObject<SoundEvent> CITRINE_LAMP_STEP = registerSoundEvent("citrine_lamp_step");
    public static RegistryObject<SoundEvent> CITRINE_LAMP_PLACE = registerSoundEvent("citrine_lamp_place");
    public static RegistryObject<SoundEvent> CITRINE_LAMP_HIT = registerSoundEvent("citrine_lamp_hit");
    public static RegistryObject<SoundEvent> CITRINE_LAMP_FALL = registerSoundEvent("citrine_lamp_fall");
    public static final ForgeSoundType CITRINE_LAMP_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.CITRINE_LAMP_BREAK, ModSounds.CITRINE_LAMP_STEP, ModSounds.CITRINE_LAMP_PLACE,
            ModSounds.CITRINE_LAMP_HIT, ModSounds.CITRINE_LAMP_FALL);
    public static RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvent("bar_brawl");

    private static RegistryObject<SoundEvent> registerSoundEvent(final String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(TutorialMod.MOD_ID, name)));
    }

    public static void register(final IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
