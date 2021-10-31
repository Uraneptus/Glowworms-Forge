package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.client.particles.GlowGooParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = GlowwormsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleTypeInit {

    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, GlowwormsMod.MOD_ID);

    public static final RegistryObject<BasicParticleType> DRIPPING_GLOW_GOO = PARTICLES.register("dripping_glow_goo", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> FALLING_GLOW_GOO = PARTICLES.register("falling_glow_goo", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> LANDING_GLOW_GOO = PARTICLES.register("landing_glow_goo", () -> new BasicParticleType(false));

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
        ParticleManager particleManager = Minecraft.getInstance().particleEngine;

        particleManager.register(ParticleTypeInit.DRIPPING_GLOW_GOO.get(), GlowGooParticle.DrippingGlowGooFactory::new);
        particleManager.register(ParticleTypeInit.FALLING_GLOW_GOO.get(), GlowGooParticle.FallingGlowGooFactory::new);
        particleManager.register(ParticleTypeInit.LANDING_GLOW_GOO.get(), GlowGooParticle.LandingGlowGooFactory::new);

    }
}