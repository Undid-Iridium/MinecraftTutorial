package net.undidiridium.tutorialmod.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.undidiridium.tutorialmod.config.TutorialModCommonConfigs;

public class ModPlacedFeatures {

    /**
     * CF -> PF
     */
    public static final Holder<PlacedFeature> EBONY_PLACED = PlacementUtils.register("ebony_placed",
            ModConfiguredFeatures.EBONY_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2)));
    // 3 -> base number of tree per chunk, 0.1f -> Extra tree chance extra, 2 how many extra.

    //Every 16 chunks, 1/16, in a square, up to a certain height,
    public static final Holder<PlacedFeature> PINK_ROSE_PLACED = PlacementUtils.register("pink_rose_placed",
            ModConfiguredFeatures.PINK_ROSE, RarityFilter.onAverageOnceEvery(16),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> CITRINE_ORE_PLACED = PlacementUtils.register("citrine_ore_placed",
            ModConfiguredFeatures.CITRINE_ORE,
            ModOrePlacement.commonOrePlacement(TutorialModCommonConfigs.CITRINE_ORE_VEINS_PER_CHUNK.get(), //
                    // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> NETHER_CITRINE_ORE_PLACED = PlacementUtils.register(
            "nether_citrine_ore_placed",
            ModConfiguredFeatures.NETHER_CITRINE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> END_CITRINE_ORE_PLACED = PlacementUtils.register("end_citrine_ore_placed",
            ModConfiguredFeatures.END_CITRINE_ORE, ModOrePlacement.commonOrePlacement(7, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
}
