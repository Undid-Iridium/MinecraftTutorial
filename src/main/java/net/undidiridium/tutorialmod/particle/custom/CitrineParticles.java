package net.undidiridium.tutorialmod.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CitrineParticles extends TextureSheetParticle {

    protected CitrineParticles(final ClientLevel level, final double xCoord, final double yCoord, final double zCoord,
                               final SpriteSet spriteSet, final double xd, final double yd, final double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.friction = 0.8F;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 0.85F;
        this.lifetime = 20;
        this.setSpriteFromAge(spriteSet);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        this.fadeOut();
    }

    private void fadeOut() {
        this.alpha = (-(1 / (float) this.lifetime) * this.age + 1);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(final SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        @Override
        public Particle createParticle(final SimpleParticleType particleType, final ClientLevel level,
                                       final double x, final double y, final double z,
                                       final double dx, final double dy, final double dz) {
            return new CitrineParticles(level, x, y, z, this.sprites, dx, dy, dz);
        }
    }
}
