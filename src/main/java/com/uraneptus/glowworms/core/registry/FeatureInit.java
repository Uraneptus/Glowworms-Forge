package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.core.world.gen.GlowwormFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FeatureInit {
    /*public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, GlowwormsMod.MOD_ID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> GLOWWORM_FEATURE = FEATURES.register("glowworm_feature",
            () -> new GlowwormFeature(NoneFeatureConfiguration.CODEC));


    public static final class Configs {
        public static final ConfiguredFeature<?, ?> GLOWWORM_FEATURE_CONFIG = FeatureInit.GLOWWORM_FEATURE.get()
                .configured(FeatureConfiguration.NONE).range(128).squared().count(10);

        //Generation Order
        public static void onBiomeLoad(BiomeLoadingEvent event) {
            BiomeGenerationSettingsBuilder generation = event.getGeneration();
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, GLOWWORM_FEATURE_CONFIG);
        }

        public static void registerFeatures() {
            register("glowworm_feature", GLOWWORM_FEATURE_CONFIG);
        }

    }

    private static <FC extends FeatureConfiguration> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(GlowwormsMod.MOD_ID, name), configuredFeature);
    }*/


}
