package net.undidiridium.tutorialmod.event.loot;

import com.google.gson.JsonObject;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class DowsingRodInIglooAdditionModifier extends LootModifier {
    private final Item addition;

    protected DowsingRodInIglooAdditionModifier(final LootItemCondition[] conditionsIn, final Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(final List<ItemStack> generatedLoot, final LootContext context) {
        if (context.hasParam(LootContextParams.BLOCK_ENTITY)) {
            final BlockPos chestPos = context.getParam(LootContextParams.BLOCK_ENTITY).getBlockPos();
            final Player player = context.getParam(LootContextParams.THIS_ENTITY).level.getNearestPlayer(context.getParam(LootContextParams.THIS_ENTITY), 10);
            player.sendMessage(new TextComponent("Found " + chestPos), player.getUUID());
        }
        final Player player = context.getParam(LootContextParams.THIS_ENTITY).level.getNearestPlayer(context.getParam(LootContextParams.THIS_ENTITY), 10);
        player.sendMessage(new TextComponent("Entity not found "), player.getUUID());
        generatedLoot.add(new ItemStack(this.addition, 1));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<DowsingRodInIglooAdditionModifier> {

        @Override
        public DowsingRodInIglooAdditionModifier read(final ResourceLocation name, final JsonObject object,
                                                      final LootItemCondition[] conditionsIn) {
            final Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition")));
            return new DowsingRodInIglooAdditionModifier(conditionsIn, addition);
        }

        @Override
        public JsonObject write(final DowsingRodInIglooAdditionModifier instance) {
            final JsonObject json = this.makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
