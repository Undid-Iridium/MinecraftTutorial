package net.undidiridium.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.entity.custom.RaccoonEntity;
import net.undidiridium.tutorialmod.entity.variant.RaccoonVariant;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public static final Map<RaccoonVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RaccoonVariant.class), (resourceLocation) -> {
                resourceLocation.put(RaccoonVariant.DEFAULT,
                        new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/raccoon.png"));
                resourceLocation.put(RaccoonVariant.DARK,
                        new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/raccoondark.png"));
                resourceLocation.put(RaccoonVariant.RED,
                        new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/redraccoon.png"));
                resourceLocation.put(RaccoonVariant.BLUE,
                        new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/blueraccoon.png"));
            });

    public RaccoonRenderer(final EntityRendererProvider.Context renderManager) {
        super(renderManager, new RaccoonModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(RaccoonEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(final RaccoonEntity animatable, final float partialTicks, final PoseStack stack,
                                    final MultiBufferSource renderTypeBuffer, final VertexConsumer vertexBuilder,
                                    final int packedLightIn,
                                    final ResourceLocation textureLocation) {

        if (animatable.isBaby()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        }
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn,
                textureLocation);
    }
}