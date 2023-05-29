package net.undidiridium.tutorialmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.undidiridium.tutorialmod.TutorialMod;
import net.undidiridium.tutorialmod.entity.custom.RaccoonEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RaccoonRenderer extends GeoEntityRenderer<RaccoonEntity> {
    public RaccoonRenderer(final EntityRendererProvider.Context renderManager) {
        super(renderManager, new RaccoonModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(final RaccoonEntity instance) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/raccoon/raccoon.png");
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