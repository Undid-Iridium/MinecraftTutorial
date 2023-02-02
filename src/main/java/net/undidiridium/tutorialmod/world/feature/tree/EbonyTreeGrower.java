package net.undidiridium.tutorialmod.world.feature.tree;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.undidiridium.tutorialmod.world.feature.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EbonyTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(final Random pRandom, final boolean pLargeHive) {
        return ModConfiguredFeatures.EBONY_TREE;
    }
}
