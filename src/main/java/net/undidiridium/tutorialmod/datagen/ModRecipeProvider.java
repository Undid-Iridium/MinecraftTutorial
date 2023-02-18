package net.undidiridium.tutorialmod.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.undidiridium.tutorialmod.EbonyRegistration;
import net.undidiridium.tutorialmod.block.ModBlocks;
import net.undidiridium.tutorialmod.datagen.custom.GemCuttingRecipeBuilder;
import net.undidiridium.tutorialmod.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(final DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(final Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ModBlocks.EBONY_DOOR.get()).define('E', EbonyRegistration.EBONY_PLANKS.get())
                .pattern("EE")
                .pattern("EE")
                .pattern("EE")
                .unlockedBy("has_ebony_planks",
                        RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(EbonyRegistration.EBONY_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        //9 to 1, maybe?
        ShapelessRecipeBuilder.shapeless(ModItems.CITRINE.get()).requires(ModBlocks.CITRINE_BLOCK.get()).unlockedBy(
                        "has_citrine_block",
                        RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.CITRINE_BLOCK.get()).build()))
                .save(pFinishedRecipeConsumer);

        // 9 to 1
        ShapedRecipeBuilder.shaped(ModBlocks.CITRINE_BLOCK.get()).define('C', ModItems.CITRINE.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .unlockedBy("has_citrine",
                        RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.CITRINE.get()).build()))
                .save(pFinishedRecipeConsumer);


        new GemCuttingRecipeBuilder(ModItems.RAW_CITRINE.get(), ModItems.CITRINE.get(), 1)
                .unlockedBy("has_raw_citrine", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_CITRINE.get()).build())).save(pFinishedRecipeConsumer);

        new GemCuttingRecipeBuilder(ModBlocks.CITRINE_ORE.get(), ModItems.RAW_CITRINE.get(), 1)
                .unlockedBy("has_citrine_ore", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CITRINE_ORE.get()).build())).save(pFinishedRecipeConsumer);

        new GemCuttingRecipeBuilder(ModBlocks.CITRINE_BLOCK.get(), ModItems.MAGIC_DUST.get(), 9)
                .unlockedBy("has_citrine_block", RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.CITRINE_BLOCK.get()).build())).save(pFinishedRecipeConsumer);

        //Should automatically use resources from generated main
    }
}
