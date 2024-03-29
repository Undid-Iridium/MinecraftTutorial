package net.undidiridium.tutorialmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class TutorialModCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> CITRINE_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> CITRINE_ORE_VEIN_SIZE;

    public static final ForgeConfigSpec.ConfigValue<Double> CITRINE_BLOCK_STRENGTH;

    static {
        BUILDER.push("Configs for Tutorial Mod");

        CITRINE_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Citrine Ore Veins spawn per chunk!")
                .define("Veins Per Chunk", 7);
        CITRINE_ORE_VEIN_SIZE = BUILDER.comment("How many Citrine Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 9, 4, 20);

        CITRINE_BLOCK_STRENGTH = BUILDER.comment("How tough a Citrine Block can be!")
                .defineInRange("Block Toughness", 9.0d, 4.0d, 20.0d);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}