package net.undidiridium.tutorialmod.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.undidiridium.tutorialmod.TutorialMod;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, TutorialMod.MOD_ID);

    /**
     * T must extend AbstractContainerMenu
     *
     * @param factory
     * @param name
     * @param <T>
     * @return
     */
    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(final IContainerFactory<T> factory,
                                                                                                  final String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(final IEventBus eventBus) {
        MENUS.register(eventBus);
    }

    public static final RegistryObject<MenuType<GemCuttingStationMenu>> GEM_CUTTING_STATION_MENU =
            registerMenuType(GemCuttingStationMenu::new, "gem_cutting_station_menu");


}