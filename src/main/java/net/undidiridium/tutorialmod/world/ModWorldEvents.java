package net.undidiridium.tutorialmod.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.world.gen.ModEntityGeneration;
import net.undidiridium.tutorialmod.world.gen.ModFlowerGeneration;
import net.undidiridium.tutorialmod.world.gen.ModOreGeneration;
import net.undidiridium.tutorialmod.world.gen.ModTreeGeneration;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        //Decoration steps should be the maintained order, meaning, UNDERGROUND_ORES comes before VEGETAL (flowers)
        ModOreGeneration.generateOres(event);
        ModTreeGeneration.generateTrees(event);
        ModFlowerGeneration.generateFlowers(event);
        ModEntityGeneration.onEntitySpawn(event);
    }
}
