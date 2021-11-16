package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.world.gen.GlowwormFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, GlowwormsMod.MOD_ID);

    public static final RegistryObject<Feature<NoFeatureConfig>> GLOWWORM_FEATURE = FEATURES.register("glowworm_feature",
            () -> new GlowwormFeature(NoFeatureConfig.CODEC));


    public static final class Configs {
        public static final ConfiguredFeature<?, ?> GLOWWORM_FEATURE_CONFIG = FeatureInit.GLOWWORM_FEATURE.get()
                .configured(IFeatureConfig.NONE).range(128).squared().count(10);

        //Generation Order
        public static void onBiomeLoad(BiomeLoadingEvent event) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, GLOWWORM_FEATURE_CONFIG);
        }

        public static void registerFeatures() {
            register("glowworm_feature", GLOWWORM_FEATURE_CONFIG);
        }

    }

    private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(GlowwormsMod.MOD_ID, name), configuredFeature);
    }


}
