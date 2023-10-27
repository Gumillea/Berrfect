package com.gumillea.berrfect.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class BlueberryJamBlock extends Block {
    public BlueberryJamBlock(Properties properties) {
        super(properties);
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity living) {
            living.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
            if (!level.isClientSide) {
                living.removeEffect(MobEffects.BLINDNESS);
                living.removeEffect(MobEffects.DARKNESS);
            }
        }
    }

}
