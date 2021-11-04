package com.uraneptus.glowworms.common.blocks;

import com.uraneptus.glowworms.core.registry.BlockInit;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IWorldReader;

public class GlowwormsBlock extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public GlowwormsBlock(Properties properties) {
        super(properties.lightLevel((p_235464_0_) -> 7), Direction.DOWN, SHAPE, false);
    }

    @Override
    protected AbstractTopPlantBlock getHeadBlock() {
        return (AbstractTopPlantBlock) BlockInit.GLOWWORMS_TOP.get();
    }
}
