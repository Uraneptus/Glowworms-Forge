package com.uraneptus.glowworms.common.blocks;

import com.uraneptus.glowworms.core.registry.BlockInit;
import net.minecraft.block.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class GlowwormsTopBlock extends AbstractTopPlantBlock {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public GlowwormsTopBlock(AbstractBlock.Properties properties) {
        super(properties.lightLevel((p_235455_0_) -> 5), Direction.DOWN, SHAPE, false, 0.1D);
    }

    protected int getBlocksToGrowWhenBonemealed(Random random) {
        return PlantBlockHelper.getBlocksToGrowWhenBonemealed(random);
    }

    protected Block getBodyBlock() {
        return BlockInit.GLOWWORMS.get();
    }

    protected boolean canGrowInto(BlockState state) {
        return PlantBlockHelper.isValidGrowthState(state);
    }

    /*@OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
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
    }*/

}
