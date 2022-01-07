package com.uraneptus.glowworms;

import com.uraneptus.glowworms.core.registry.BlockInit;
import com.uraneptus.glowworms.core.registry.FeatureInit;
import com.uraneptus.glowworms.core.registry.ParticleTypeInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GlowwormsMod.MOD_ID)
@Mod.EventBusSubscriber(modid = GlowwormsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlowwormsMod
{
    public static final String MOD_ID = "glowworms";

    public GlowwormsMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        //FeatureInit.FEATURES.register(eventBus);
        BlockInit.BLOCKS.register(eventBus);
        BlockInit.ITEMS.register(eventBus);
        ParticleTypeInit.PARTICLES.register(eventBus);

        //MinecraftForge.EVENT_BUS.addListener(FeatureInit.Configs::onBiomeLoad);
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        //FeatureInit.Configs.registerFeatures();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.GLOWWORMS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.GLOWWORMS_TOP.get(), RenderType.translucent());

    }
}
