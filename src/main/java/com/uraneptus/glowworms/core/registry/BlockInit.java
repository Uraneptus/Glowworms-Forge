package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.common.blocks.GlowwormsBlock;
import com.uraneptus.glowworms.common.blocks.GlowwormsTopBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.tags.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GlowwormsMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GlowwormsMod.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> GLOWWORMS_TOP = BLOCKS.register("glowworms_top",
            () -> new GlowwormsTopBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noOcclusion().noCollission().instabreak().sound(SoundType.WEEPING_VINES).emissiveRendering(BlockInit::always)));

    public static final RegistryObject<Block> GLOWWORMS = BLOCKS.register("glowworms",
            () -> new GlowwormsBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noOcclusion().noCollission().instabreak().sound(SoundType.WEEPING_VINES).emissiveRendering(BlockInit::always)));

    public static final RegistryObject<Block> GLOWWORM_INFESTED_STONE = BLOCKS.register("glowworm_infested_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).lightLevel((p_235455_0_) -> 6)));


    //Items
    public static final RegistryObject<BlockItem> GLOWWORMS_TOP_ITEM = ITEMS.register("glowworms_top",
            () -> new BlockItem(GLOWWORMS_TOP.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<BlockItem> GLOWWORMS_ITEM = ITEMS.register("glowworms",
            () -> new BlockItem(GLOWWORMS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GLOWWORM_INFESTED_STONE_ITEM = ITEMS.register("glowworm_infested_stone",
            () -> new BlockItem(GLOWWORM_INFESTED_STONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));


    //CUSTOM TAGS
    public static class BlockTags {
        public static final Tag.Named<Block> CAN_PLACE_GLOWWORM = net.minecraft.tags.BlockTags.createOptional(new ResourceLocation(GlowwormsMod.MOD_ID, "can_place_glowworm"));
    }


    private static boolean always(BlockState state, BlockGetter blockReader, BlockPos pos) {
        return true;
    }

}
