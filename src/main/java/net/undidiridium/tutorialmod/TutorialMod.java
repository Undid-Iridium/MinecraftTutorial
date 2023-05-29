package net.undidiridium.tutorialmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.undidiridium.tutorialmod.block.ModBlocks;
import net.undidiridium.tutorialmod.block.entity.ModBlockEntities;
import net.undidiridium.tutorialmod.block.entity.ModWoodTypes;
import net.undidiridium.tutorialmod.effect.ModEffects;
import net.undidiridium.tutorialmod.enchantment.ModEnchantments;
import net.undidiridium.tutorialmod.entity.ModEntityTypes;
import net.undidiridium.tutorialmod.fluid.ModFluids;
import net.undidiridium.tutorialmod.item.ModItems;
import net.undidiridium.tutorialmod.painting.ModPaintings;
import net.undidiridium.tutorialmod.particle.ModParticles;
import net.undidiridium.tutorialmod.potion.ModPotions;
import net.undidiridium.tutorialmod.recipe.ModRecipes;
import net.undidiridium.tutorialmod.screen.ModMenuTypes;
import net.undidiridium.tutorialmod.sound.ModSounds;
import net.undidiridium.tutorialmod.util.BetterBrewingRecipe;
import net.undidiridium.tutorialmod.villager.ModVillagers;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod() {
        // Register the setup method for modloading
        final IEventBus event_bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the enqueueIMC method for modloading
//        event_bus.addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        event_bus.addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in

        /*
        the textures have to be PNG files and usually should be divisible by 16:
            So: 16x16, 32x32, 48x48, etc
         */

        ModItems.register(event_bus);
        ModBlocks.register(event_bus);
        ModBlockEntities.register(event_bus);
        ModMenuTypes.register(event_bus);
        ModPaintings.register(event_bus);
        ModSounds.register(event_bus);
        ModPotions.register(event_bus);
        ModEffects.register(event_bus);
        ModRecipes.register(event_bus);
        ModParticles.register(event_bus);
        ModFluids.register(event_bus);
        ModEnchantments.register(event_bus);
        ModEntityTypes.register(event_bus);
        ModVillagers.register(event_bus);
        // Add in setup method

        event_bus.addListener(TutorialMod::setup);

        //event_bus.addListener(this::clientSetup); Incorrect, do not do this due to this class being called for
        // server/client

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private static void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, ModItems.CITRINE.get(),
                    ModPotions.FREEZE_POTION.get()));

            Sheets.addWoodType(ModWoodTypes.EBONY);

            SpawnPlacements.register(ModEntityTypes.RACCOON.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);

            ModVillagers.registerPOIs();
        });
    }


//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        // Some example code to dispatch IMC to another mod
//        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return
//        "Hello world";});
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//        // Some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.messageSupplier().get()).
//                collect(Collectors.toList()));
//    }
//
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event)
//    {
//        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }
//
//    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing
//    to the MOD
//    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents
//    {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
//        {
//            // Register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }
}
