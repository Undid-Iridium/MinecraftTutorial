package net.undidiridium.tutorialmod.painting;

import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;

public class ModPaintings {

    public static final DeferredRegister<Motive> PAINTING_MOTIVES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, TutorialMod.MOD_ID);

    // 1 block is 16x16 pixels
    public static final RegistryObject<Motive> MARATHON = PAINTING_MOTIVES.register("marathon", () -> new Motive(16, 16));

    public static final RegistryObject<Motive> FAMILY = PAINTING_MOTIVES.register("family", () -> new Motive(16, 32));

    public static void register(final IEventBus eventBus) {
        PAINTING_MOTIVES.register(eventBus);
    }
}
