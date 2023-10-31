package com.gumillea.berrfect.common.item;

import com.gumillea.berrfect.common.entity.RottenPie;
import com.gumillea.berrfect.core.reg.BerrfectItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class RottenPieItem extends Item {
    public RottenPieItem(Properties properties) {
        super(properties);
    }


    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (!player.isShiftKeyDown()) {
                RottenPie pie = new RottenPie(level, player);

                level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
                pie.setItem(new ItemStack(BerrfectItems.ROTTEN_BLISTERBERRY_PIE.get()));
                pie.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 0.8F, 0.5F);
                level.addFreshEntity(pie);

                player.getCooldowns().addCooldown(this, 40);
            } else {
                player.startUsingItem(hand);
                return InteractionResultHolder.consume(itemstack);
            }
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity living) {
        ItemStack itemstack = super.finishUsingItem(stack, level, living);
        living.level.explode(null, living.getX(), living.getY(), living.getZ(), 1.5F, Explosion.BlockInteraction.NONE);

        return itemstack;
    }
}
