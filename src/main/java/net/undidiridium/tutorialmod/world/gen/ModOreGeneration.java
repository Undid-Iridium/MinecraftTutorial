package net.undidiridium.tutorialmod.world.gen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.undidiridium.tutorialmod.world.feature.ModPlacedFeatures;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        final List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(ModPlacedFeatures.CITRINE_ORE_PLACED);

        if (event.getCategory() == Biome.BiomeCategory.THEEND) {
            base.add(ModPlacedFeatures.END_CITRINE_ORE_PLACED);
        }
        else if (event.getCategory() == Biome.BiomeCategory.NETHER) {
            base.add(ModPlacedFeatures.NETHER_CITRINE_ORE_PLACED);
        }
    }
}
