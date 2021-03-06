package com.uraneptus.glowworms.client.particles;

import com.uraneptus.glowworms.core.registry.ParticleTypeInit;
import net.minecraft.client.particle.*;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.tags.FluidTags;
import net.minecraft.core.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlowGooParticle extends TextureSheetParticle {
    private final Fluid fluid;
    protected boolean isGlowing;
    float r = 0.20F;
    float g = 1.00F;
    float b = 0.87F;

    public GlowGooParticle(ClientLevel world, double x, double y, double z, Fluid fluid) {
        super(world, x, y, z);
        this.setSize(0.01F, 0.01F);
        this.gravity = 0.06F;
        this.fluid = fluid;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float lightcolor) {
        return this.isGlowing ? 240 : super.getLightColor(lightcolor);
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.preMoveUpdate();
        if (!this.removed) {
            this.yd -= (double)this.gravity;
            this.move(this.xd, this.yd, this.zd);
            this.postMoveUpdate();
            if (!this.removed) {
                this.xd *= (double)0.98F;
                this.yd *= (double)0.98F;
                this.zd *= (double)0.98F;
                BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
                if (this.level.getFluidState(new BlockPos(this.x, this.y + 0.2, this.z)).isEmpty()) {
                    if (this.level.getFluidState(new BlockPos(this.x, this.y - 0.1, this.z)).is(FluidTags.WATER)) {
                        this.onGround = true;
                        this.yd = 0;

                    }
                }

            }
        }

    }

    protected void preMoveUpdate() {
        if (this.lifetime-- <= 0) {
            this.remove();
        }

    }

    protected void postMoveUpdate() {
    }


    //Falling Nectar [necessary for Falling Particles]
    @OnlyIn(Dist.CLIENT)
    static class FallingNectarParticle extends GlowGooParticle {
        private FallingNectarParticle(ClientLevel world, double x, double y, double z, Fluid fluid) {
            super(world, x, y, z, fluid);
            this.lifetime = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
        }

        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
            }

        }
    }


    //DRIPPING
    @OnlyIn(Dist.CLIENT)
    static class Dripping extends GlowGooParticle {
        private final ParticleOptions fallingParticle;

        private Dripping(ClientLevel world, double x, double y, double z, Fluid fluid, ParticleOptions data) {
            super(world, x, y, z, fluid);
            this.fallingParticle = data;
            this.gravity *= 0.02F;
            this.lifetime = 40;
        }

        protected void preMoveUpdate() {
            if (this.lifetime-- <= 0) {
                this.remove();
                this.level.addParticle(this.fallingParticle, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }

        }

        protected void postMoveUpdate() {
            this.xd *= 0.02D;
            this.yd *= 0.02D;
            this.zd *= 0.02D;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class DrippingGlowGooFactory implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public DrippingGlowGooFactory(SpriteSet sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double x, double y, double z, double xV, double yV, double zV) {
            Dripping glowgooparticle$dripping = new Dripping(world, x, y, z, Fluids.EMPTY, ParticleTypeInit.FALLING_GLOW_GOO.get());
            glowgooparticle$dripping.isGlowing = true;
            glowgooparticle$dripping.gravity *= 0.01F;
            glowgooparticle$dripping.lifetime = 100;
            glowgooparticle$dripping.setColor(glowgooparticle$dripping.r, glowgooparticle$dripping.g, glowgooparticle$dripping.b);
            glowgooparticle$dripping.pickSprite(this.sprite);
            return glowgooparticle$dripping;
        }
    }


    //FALLING
    @OnlyIn(Dist.CLIENT)
    public static class FallingLiquidParticle extends FallingNectarParticle {
        protected final ParticleOptions landParticle;

        public FallingLiquidParticle(ClientLevel world, double x, double y, double z, Fluid fluid, ParticleOptions data) {
            super(world, x, y, z, fluid);
            this.landParticle = data;
        }

        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
                this.level.addParticle(this.landParticle, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
            }

        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class FallingGlowGooFactory implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public FallingGlowGooFactory(SpriteSet sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double x, double y, double z, double xV, double yV, double zV) {
            GlowGooParticle glowgooparticle = new FallingLiquidParticle(world, x, y, z, Fluids.EMPTY, ParticleTypeInit.LANDING_GLOW_GOO.get());
            glowgooparticle.isGlowing = true;
            glowgooparticle.gravity = 0.01F;
            glowgooparticle.setColor(glowgooparticle.r, glowgooparticle.g, glowgooparticle.b);
            glowgooparticle.pickSprite(this.sprite);
            return glowgooparticle;
        }
    }


    //LANDING PARTICLE
    @OnlyIn(Dist.CLIENT)
    static class Landing extends GlowGooParticle {
        private Landing(ClientLevel world, double x, double y, double z, Fluid fluid) {
            super(world, x, y, z, fluid);
            this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        }
    }
    @OnlyIn(Dist.CLIENT)
    public static class LandingGlowGooFactory implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprite;

        public LandingGlowGooFactory(SpriteSet sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel world, double x, double y, double z, double xV, double yV, double zV) {
            GlowGooParticle glowgooparticle = new Landing(world, x, y, z, Fluids.EMPTY);
            glowgooparticle.isGlowing = true;
            glowgooparticle.lifetime = (int)(28.0D / (Math.random() * 0.8D + 0.2D));
            glowgooparticle.setColor(glowgooparticle.r, glowgooparticle.g, glowgooparticle.b);
            glowgooparticle.pickSprite(this.sprite);
            return glowgooparticle;

        }
    }
}
