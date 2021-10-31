package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.common.blocks.GlowwormsBlock;
import com.uraneptus.glowworms.common.blocks.GlowwormsTopBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit { //TODO Gloworms should only be placed on gloworm infected stone
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GlowwormsMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GlowwormsMod.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> GLOWWORMS_TOP = BLOCKS.register("glowworms_top",
            () -> new GlowwormsTopBlock(AbstractBlock.Properties.of(Material.PLANT).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).emissiveRendering(BlockInit::always)));

    public static final RegistryObject<Block> GLOWWORMS = BLOCKS.register("glowworms",
            () -> new GlowwormsBlock(AbstractBlock.Properties.of(Material.PLANT).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).emissiveRendering(BlockInit::always)));

    public static final RegistryObject<Block> GLOWWORM_INFESTED_STONE = BLOCKS.register("glowworm_infested_stone",
            () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE).lightLevel((p_235455_0_) -> 10)));


    //Items
    public static final RegistryObject<BlockItem> GLOWWORMS_TOP_ITEM = ITEMS.register("glowworms_top",
            () -> new BlockItem(GLOWWORMS_TOP.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));

    public static final RegistryObject<BlockItem> GLOWWORMS_ITEM = ITEMS.register("glowworms",
            () -> new BlockItem(GLOWWORMS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GLOWWORM_INFESTED_STONE_ITEM = ITEMS.register("glowworm_infested_stone",
            () -> new BlockItem(GLOWWORM_INFESTED_STONE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));


    private static boolean always(BlockState state, IBlockReader blockReader, BlockPos pos) {
        return true;
    }
}
