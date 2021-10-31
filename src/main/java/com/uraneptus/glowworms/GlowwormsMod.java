package com.uraneptus.glowworms;

import com.uraneptus.glowworms.core.registry.BlockInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GlowwormsMod.MOD_ID)
@Mod.EventBusSubscriber(modid = GlowwormsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GlowwormsMod
{
    public static final String MOD_ID = "glowworms";

    public GlowwormsMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::clientSetup);

        BlockInit.BLOCKS.register(eventBus);
        BlockInit.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInit.GLOWWORMS.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(BlockInit.GLOWWORMS_TOP.get(), RenderType.translucent());
    }
}
