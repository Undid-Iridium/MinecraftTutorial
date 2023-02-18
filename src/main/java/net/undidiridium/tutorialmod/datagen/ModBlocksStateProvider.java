package net.undidiridium.tutorialmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.EbonyRegistration;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.block.ModBlocks;
import net.undidiridium.tutorialmod.block.custom.CucumberPlantBlock;
import net.undidiridium.tutorialmod.item.ModItems;

import java.util.function.Function;

/**
 * Careful, there are 2 blockstateproviders, one is not designed for this.
 */
public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(final DataGenerator gen, final ExistingFileHelper exFileHelper) {
        super(gen, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(ModBlocks.CITRINE_BLOCK.get());
        this.simpleBlock(ModBlocks.RAW_CITRINE_BLOCK.get());
        this.simpleBlock(ModBlocks.CITRINE_ORE.get());
        this.simpleBlock(ModBlocks.DEEPSLATE_CITRINE_ORE.get());
        this.simpleBlock(ModBlocks.NETHERRACK_CITRINE_ORE.get());
        this.simpleBlock(ModBlocks.ENDSTONE_CITRINE_ORE.get());
        this.simpleBlock(ModBlocks.SPEEDY_BLOCK.get());

        this.buttonBlock((ButtonBlock) ModBlocks.CITRINE_BUTTON.get(),
                this.blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        this.pressurePlateBlock((PressurePlateBlock) ModBlocks.CITRINE_PRESSURE_PLATE.get(),
                this.blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        this.wallBlock((WallBlock) ModBlocks.CITRINE_WALL.get(), this.blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        this.fenceBlock((FenceBlock) ModBlocks.CITRINE_FENCE.get(), this.blockTexture(ModBlocks.CITRINE_BLOCK.get()));

        this.fenceGateBlock((FenceGateBlock) ModBlocks.CITRINE_FENCE_GATE.get(),
                this.blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        this.slabBlock((SlabBlock) ModBlocks.CITRINE_SLAB.get(), this.blockTexture(ModBlocks.CITRINE_BLOCK.get()),
                this.blockTexture(ModBlocks.CITRINE_BLOCK.get()));
        this.stairsBlock((StairBlock) ModBlocks.CITRINE_STAIRS.get(), this.blockTexture(ModBlocks.CITRINE_BLOCK.get()));

        this.doorBlock((DoorBlock) ModBlocks.EBONY_DOOR.get(), new ResourceLocation(TutorialMod.MOD_ID, "block" +
                        "/ebony_door_bottom"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/ebony_door_top"));
        this.trapdoorBlock((TrapDoorBlock) ModBlocks.EBONY_TRAP_DOOR.get(),
                this.blockTexture(ModBlocks.EBONY_TRAP_DOOR.get()),
                true);

        this.logBlock((RotatedPillarBlock) EbonyRegistration.EBONY_LOG.get());
        this.axisBlock((RotatedPillarBlock) EbonyRegistration.EBONY_WOOD.get(),
                this.blockTexture(EbonyRegistration.EBONY_LOG.get()),
                this.blockTexture(EbonyRegistration.EBONY_LOG.get()));
        this.axisBlock((RotatedPillarBlock) EbonyRegistration.STRIPPED_EBONY_LOG.get(),
                new ResourceLocation(TutorialMod.MOD_ID,
                        "block/stripped_ebony_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_top"));
        this.axisBlock((RotatedPillarBlock) EbonyRegistration.STRIPPED_EBONY_WOOD.get(),
                new ResourceLocation(TutorialMod.MOD_ID,
                        "block/stripped_ebony_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_top"));

        this.simpleBlock(EbonyRegistration.EBONY_PLANKS.get());
        this.simpleBlock(EbonyRegistration.EBONY_LEAVES.get());
        this.simpleBlock(ModBlocks.WINTER_WINDOW.get());

        this.signBlock((StandingSignBlock) EbonyRegistration.EBONY_SIGN.get(),
                (WallSignBlock) EbonyRegistration.EBONY_WALL_SIGN.get(),
                this.blockTexture(EbonyRegistration.EBONY_PLANKS.get()));

        this.simpleBlock(ModBlocks.PINK_ROSE.get(),
                this.models().cross(ModBlocks.PINK_ROSE.get().getRegistryName().getPath(),
                        this.blockTexture(ModBlocks.PINK_ROSE.get())));
        this.simpleBlock(EbonyRegistration.EBONY_SAPLING.get(),
                this.models().cross(EbonyRegistration.EBONY_SAPLING.get().getRegistryName().getPath(),
                        this.blockTexture(EbonyRegistration.EBONY_SAPLING.get())));

        this.simpleBlock(ModBlocks.POTTED_PINK_ROSE.get(),
                this.flowerPotCross(ModBlocks.POTTED_PINK_ROSE.get().getRegistryName().getPath()));

        this.makeCrop((CucumberPlantBlock) ModBlocks.CUCUMBER_PLANT.get(), "cucumber_stage", "cucumber_stage");
    }

    protected void registerModels() {

        for (final RegistryObject<Item> entry : ModItems.ITEMS.getEntries()) {

            if (entry.get() instanceof BlockItem blockItem) {

                this.block(blockItem);

            }

        }

    }


    /**
     * 1.19 solution to issue with getRegistryName going away
     *
     * @param block
     */
    private void simpleBlockWithItem(final Block block) {

        final String blockName = ForgeRegistries.BLOCKS.getKey(block).getPath();

        this.simpleBlock(block);

        this.itemModels().withExistingParent(blockName, new ResourceLocation(TutorialMod.MOD_ID, "block/" + blockName));

    }

    protected BlockModelBuilder block(final BlockItem blockItem) {

        return this.models().withExistingParent(blockItem.getRegistryName().getPath(),
                TutorialMod.MOD_ID + ":block/" + blockItem.getBlock().getRegistryName().getPath());

    }

    public ModelFile flowerPotCross(final String name) {
        return this.models().withExistingParent(name, "flower_pot_cross");
    }

    public void makeCrop(final CropBlock block, final String modelName, final String textureName) {
        final Function<BlockState, ConfiguredModel[]> function = state -> this.states(state, block, modelName,
                textureName);

        this.getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(final BlockState state, final CropBlock block, final String modelName,
                                     final String textureName) {
        final ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(this.models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(TutorialMod.MOD_ID,
                        "block/" + textureName + state.getValue(block.getAgeProperty()))));

        return models;
    }
}