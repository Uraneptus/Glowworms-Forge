package com.uraneptus.glowworms.core.registry;

import com.uraneptus.glowworms.GlowwormsMod;
import com.uraneptus.glowworms.common.blocks.GlowwormsCeilingBlock;
import com.uraneptus.glowworms.common.blocks.GlowwormsHangingBlock;
import com.uraneptus.glowworms.common.blocks.GlowwormsEndBlock;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.tags.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GlowwormsMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GlowwormsMod.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> GLOWWORMS_END = BLOCKS.register("glowworms_end",
            () -> new GlowwormsEndBlock(Properties.GLOWWORMS_PLANT));

    public static final RegistryObject<Block> GLOWWORMS_HANGING = BLOCKS.register("gloworms_hanging",
            () -> new GlowwormsHangingBlock(Properties.GLOWWORMS_PLANT));

    public static final RegistryObject<Block> GLOWWORMS_CEILING = BLOCKS.register("glowworms_ceiling",
            () -> new Block(Properties.GLOWWORMS_PLANT));

    public static final RegistryObject<Block> GLOWWORM_INFESTED_STONE = BLOCKS.register("glowworm_infested_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).lightLevel((p_235455_0_) -> 6)));


    //Items
    public static final RegistryObject<BlockItem> GLOWWORMS_END_ITEM = ITEMS.register("glowworms_end",
            () -> new BlockItem(GLOWWORMS_END.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GLOWWORMS_HANGING_ITEM = ITEMS.register("gloworms_hanging",
            () -> new BlockItem(GLOWWORMS_HANGING.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> GLOWWORMS_CEILING_ITEM = ITEMS.register("glowworms_ceiling",
            () -> new BlockItem(GLOWWORMS_CEILING.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<BlockItem> GLOWWORM_INFESTED_STONE_ITEM = ITEMS.register("glowworm_infested_stone",
            () -> new BlockItem(GLOWWORM_INFESTED_STONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));


    //CUSTOM TAGS
    public static class BlockTags {
        public static final Tag.Named<Block> CAN_PLACE_GLOWWORM = net.minecraft.tags.BlockTags.createOptional(new ResourceLocation(GlowwormsMod.MOD_ID, "can_place_glowworm"));
    }

    public static class Properties {
        public static final BlockBehaviour.Properties GLOWWORMS_PLANT = BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noOcclusion().noCollission().instabreak().sound(SoundType.WEEPING_VINES).emissiveRendering(Blocks::always);


    }

}
