package net.undidiridium.tutorialmod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.EbonyRegistration;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.block.ModBlocks;
import net.undidiridium.tutorialmod.block.entity.custom.GemCuttingStationBlockEntity;
import net.undidiridium.tutorialmod.block.entity.custom.ModSignBlockEntity;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TutorialMod.MOD_ID);
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(
                                    ModSignBlockEntity::new,
                                    EbonyRegistration.EBONY_WALL_SIGN.get(),
                                    EbonyRegistration.EBONY_SIGN.get())
                            .build(null));

    public static void register(final IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }

    public static final RegistryObject<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("gem_cutting_station_block_entity", () ->
                    BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new,
                            ModBlocks.GEM_CUTTING_STATION.get()).build(null));


}
