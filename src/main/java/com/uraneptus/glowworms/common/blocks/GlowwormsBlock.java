package com.uraneptus.glowworms.common.blocks;

import com.uraneptus.glowworms.core.registry.BlockInit;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlowwormsBlock extends GrowingPlantBodyBlock {
    public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public GlowwormsBlock(Properties properties) {
        super(properties.lightLevel((p_235464_0_) -> 8), Direction.DOWN, SHAPE, false);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) BlockInit.GLOWWORMS_TOP.get();
    }
}
