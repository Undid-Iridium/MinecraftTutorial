package net.undidiridium.tutorialmod.world.feature;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;


public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(final PlacementModifier p_195347_, final PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(final int p_195344_, final PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(final int p_195350_, final PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
