package net.undidiridium.tutorialmod.block.custom;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.undidiridium.tutorialmod.item.ModItems;

public class CucumberPlantBlock extends CropBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public CucumberPlantBlock(final Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.CUCUMBER_SEEDS.get();
    }
}
