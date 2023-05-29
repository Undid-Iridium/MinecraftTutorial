package net.undidiridium.tutorialmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.entity.custom.RaccoonEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class RaccoonModel extends AnimatedGeoModel<RaccoonEntity> {
    @Override
    public ResourceLocation getModelLocation(final RaccoonEntity object) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/raccoon.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(RaccoonEntity object) {
        return RaccoonRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

//    @SuppressWarnings({"unchecked", "rawtypes"})
//    @Override
//    public void setLivingAnimations(RaccoonEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
//        super.setLivingAnimations(entity, uniqueID, customPredicate);
//        IBone head = this.getAnimationProcessor().getBone("head");
//
//        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get
//        (0);
//        if (head != null) {
//            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
//            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
//        }
//    }

    @Override
    public void setCustomAnimations(RaccoonEntity animatable, int uniqueID, AnimationEvent customPredicate) {
        super.setCustomAnimations(animatable, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }


    @Override
    public ResourceLocation getAnimationFileLocation(final RaccoonEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/raccoon.animation.json");
    }


}