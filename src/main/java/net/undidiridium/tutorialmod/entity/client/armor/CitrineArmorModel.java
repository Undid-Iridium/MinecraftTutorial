package net.undidiridium.tutorialmod.entity.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.item.custom.CitrineArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CitrineArmorModel extends AnimatedGeoModel<CitrineArmorItem> {
    /**
     * @param object
     * @return
     */
    @Override
    public ResourceLocation getModelLocation(CitrineArmorItem object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/mythril_armor.geo.json");
    }

    /**
     * @param object
     * @return
     */
    @Override
    public ResourceLocation getTextureLocation(CitrineArmorItem object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/models/armor/mythril_armor_texture.png");

    }

    /**
     * This resource location needs to point to a json file of your animation file,
     * i.e. "geckolib:animations/frog_animation.json"
     *
     * @param animatable
     * @return the animation file location
     */
    @Override
    public ResourceLocation getAnimationFileLocation(CitrineArmorItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/armor_animation.json");
    }
}
