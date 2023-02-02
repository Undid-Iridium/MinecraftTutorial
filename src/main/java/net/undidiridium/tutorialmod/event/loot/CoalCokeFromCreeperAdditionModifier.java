package net.undidiridium.tutorialmod.event.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class CoalCokeFromCreeperAdditionModifier extends LootModifier {
    private final Item addition;

    protected CoalCokeFromCreeperAdditionModifier(final LootItemCondition[] conditionsIn, final Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(final List<ItemStack> generatedLoot, final LootContext context) {
        // generatedLoot is the loot that would be dropped, if we wouldn't add or replace
        // anything!
        generatedLoot.add(new ItemStack(this.addition, 1));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<CoalCokeFromCreeperAdditionModifier> {

        @Override
        public CoalCokeFromCreeperAdditionModifier read(final ResourceLocation name, final JsonObject object,
                                                        final LootItemCondition[] conditionsIn) {
            final Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new CoalCokeFromCreeperAdditionModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(final CoalCokeFromCreeperAdditionModifier instance) {
            final JsonObject json = this.makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
