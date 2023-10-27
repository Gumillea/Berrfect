package com.gumillea.berrfect.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BerrfectPipsItem extends Item {

    private final Block bush;

    public BerrfectPipsItem(Block block, Properties properties) {
        super(properties);
        this.bush = block;
    }

    @NotNull
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().above(1);
        BlockPos pos2 = context.getClickedPos();
        BlockState block = bush.defaultBlockState();
        BlockState state = level.getBlockState(context.getClickedPos());
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (block.canSurvive(level, pos) && level.isEmptyBlock(pos)) {
            level.playSound(context.getPlayer(), pos, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
            level.setBlock(pos, block, 3);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, pos, context.getItemInHand());
            }
            if (player == null || !player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        } else if (block.canSurvive(level, pos2) && state.is(BlockTags.REPLACEABLE_PLANTS)) {
            level.playSound(context.getPlayer(), pos2, SoundEvents.SWEET_BERRY_BUSH_PLACE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.8F);
            level.setBlock(pos2, block, 3);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, pos, context.getItemInHand());
            }
            if (player == null || !player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        } else {
            return InteractionResult.FAIL;
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
