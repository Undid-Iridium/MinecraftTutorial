package net.undidiridium.tutorialmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(final DataGenerator generator, final ExistingFileHelper existingFileHelper) {
        super(generator, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.simpleItem(ModItems.CITRINE.get());

        this.handheldItem(ModItems.CITRINE_AXE.get());
        this.handheldItem(ModItems.CITRINE_SHOVEL.get());
        this.handheldItem(ModItems.CITRINE_PICKAXE.get());
        this.handheldItem(ModItems.CITRINE_SWORD.get());
        this.handheldItem(ModItems.CITRINE_HOE.get());
        this.handheldItem(ModItems.CITRINE_STAFF.get());


        this.simpleItem(ModItems.COAL_COKE.get());
        this.simpleItem(ModItems.CUCUMBER.get());
        this.simpleItem(ModItems.CUCUMBER_SEEDS.get());
        this.simpleItem(ModItems.HONEY_BUCKET.get());
        this.simpleItem(ModItems.MAGIC_DUST.get());
        this.simpleItem(ModItems.BAR_BRAWL_MUSIC_DISK.get());
        this.simpleItem(ModItems.AFTER_DARK_MUSIC_DISK.get());

        this.simpleItem(ModItems.CITRINE_HELMET.get());
        this.simpleItem(ModItems.CITRINE_CHESTPLATE.get());
        this.simpleItem(ModItems.CITRINE_LEGGING.get());
        this.simpleItem(ModItems.CITRINE_BOOTS.get());

        this.simpleItem(ModItems.DATA_TABLET.get());
        this.simpleItem(ModItems.DOWSING_ROD.get());
        this.simpleItem(ModItems.DOWSING_ROD_ADV.get());
        this.simpleItem(ModItems.EBONY_SIGN.get());
        this.simpleItem(ModItems.GEM_CUTTER_TOOL.get());
        this.simpleItem(ModItems.RAW_CITRINE.get());
    }

    private ItemModelBuilder simpleItem(final Item item) {
        return this.withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getRegistryName().getPath()));
    }

    private ItemModelBuilder handheldItem(final Item item) {
        return this.withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getRegistryName().getPath()));
    }
}