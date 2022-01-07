package com.uraneptus.glowworms.common.blocks;

import com.uraneptus.glowworms.core.registry.BlockInit;
import com.uraneptus.glowworms.core.registry.ParticleTypeInit;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GlowwormsEndBlock extends GrowingPlantHeadBlock {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public GlowwormsEndBlock(BlockBehaviour.Properties properties) {
        super(properties.lightLevel((p_235455_0_) -> 8), Direction.DOWN, SHAPE, false, 0.8D);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        /*List blockTags = BlockInit.BlockTags.CAN_PLACE_GLOWWORM.getValues();
        System.out.println(blockTags);
        System.out.println("Called canSurvive method");*/
        return pLevel.getBlockState(pPos.above()).is(BlockInit.BlockTags.CAN_PLACE_GLOWWORM);
    }

    protected int getBlocksToGrowWhenBonemealed(Random random) {
        return NetherVines.getBlocksToGrowWhenBonemealed(random);
    }

    protected Block getBodyBlock() {
        return BlockInit.GLOWWORMS_HANGING.get();
    }

    protected boolean canGrowInto(BlockState state) {
        return NetherVines.isValidGrowthState(state);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = Direction.getRandom(random);
            if (direction != Direction.UP) {
                BlockPos blockpos = pos.relative(direction);
                BlockState blockstate = world.getBlockState(blockpos);
                if (!state.canOcclude() || !blockstate.isFaceSturdy(world, blockpos, direction.getOpposite())) {
                    double d0 = direction.getStepX() == 0 ? random.nextDouble() : 0.5D + (double)direction.getStepX() * 0.6D;
                    double d1 = direction.getStepY() == 0 ? random.nextDouble() : 0.5D + (double)direction.getStepY() * 0.6D;
                    double d2 = direction.getStepZ() == 0 ? random.nextDouble() : 0.5D + (double)direction.getStepZ() * 0.6D;
                    world.addParticle(ParticleTypeInit.DRIPPING_GLOW_GOO.get(), (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

}
