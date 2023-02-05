package net.undidiridium.tutorialmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.undidiridium.tutorialmod.TutorialMod;

public class GemCuttingStationScreen extends AbstractContainerScreen<GemCuttingStationMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(TutorialMod.MOD_ID, "textures/gui/gem_cutting_station_gui.png");

    public GemCuttingStationScreen(final GemCuttingStationMenu pMenu, final Inventory pPlayerInventory, final Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    /**
     * Boilerplate code to draw texture on screen.
     *
     * @param pPoseStack
     * @param pPartialTick
     * @param pMouseX
     * @param pMouseY
     */
    @Override
    protected void renderBg(final PoseStack pPoseStack, final float pPartialTick, final int pMouseX, final int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        final int x = (this.width - this.imageWidth) / 2;
        final int y = (this.height - this.imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, this.imageWidth, this.imageHeight);

        /**
         * Top left gui to where we draw 0,0 -> 102 + x then down y + 41
         * 176 pixels to the arrow we have, width is 8, and height is scaled progress (26-x).
         */
        if (this.menu.isCrafting()) {
            this.blit(pPoseStack, x + 102, y + 41, 176, 0, 8, this.menu.getScaledProgress());
        }
    }

    @Override
    public void render(final PoseStack pPoseStack, final int mouseX, final int mouseY, final float delta) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        this.renderTooltip(pPoseStack, mouseX, mouseY);
    }
}