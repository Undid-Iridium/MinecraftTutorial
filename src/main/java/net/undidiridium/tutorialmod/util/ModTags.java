package net.undidiridium.tutorialmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.undidiridium.tutorialmod.TutorialMod;

public class ModTags {
    public static class Blocks {
        /**
         * Grabs and assigns this tag by the data, minecraft, tutorialmod, tags folder.
         */
        public static final TagKey<Block> DOWSING_ROD_VALUABLES = tag("dowsing_rod_valuables");

        private static TagKey<Block> tag(final String name) {
            return BlockTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(final String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> CITRINE_GEMS = forgeTag("gems/citrine");

        private static TagKey<Item> tag(final String name) {
            return ItemTags.create(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(final String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
