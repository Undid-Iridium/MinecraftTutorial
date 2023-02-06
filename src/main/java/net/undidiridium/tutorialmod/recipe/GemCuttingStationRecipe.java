package net.undidiridium.tutorialmod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.undidiridium.tutorialmod.TutorialMod;

import javax.annotation.Nullable;

public class GemCuttingStationRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public GemCuttingStationRecipe(final ResourceLocation id, final ItemStack output,
                                   final NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(final SimpleContainer pContainer, final Level pLevel) {
        return this.recipeItems.get(0).test(pContainer.getItem(1));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    @Override
    public ItemStack assemble(final SimpleContainer pContainer) {
        return this.output;
    }

    @Override
    public boolean canCraftInDimensions(final int pWidth, final int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<GemCuttingStationRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "gem_cutting";

        private Type() {
        }
    }

    public static class Serializer implements RecipeSerializer<GemCuttingStationRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(TutorialMod.MOD_ID, "gem_cutting");

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(final Class<?> cls) {
            return (Class<G>) cls;
        }

        @Override
        public void toNetwork(final FriendlyByteBuf buf, final GemCuttingStationRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (final Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }

        @Override
        public GemCuttingStationRecipe fromJson(final ResourceLocation id, final JsonObject json) {
            final ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            final JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            final NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new GemCuttingStationRecipe(id, output, inputs);
        }

        @Override
        public GemCuttingStationRecipe fromNetwork(final ResourceLocation id, final FriendlyByteBuf buf) {
            final NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            final ItemStack output = buf.readItem();
            return new GemCuttingStationRecipe(id, output, inputs);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(final ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }
    }
}
