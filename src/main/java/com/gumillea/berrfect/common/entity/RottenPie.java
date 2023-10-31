package com.gumillea.berrfect.common.entity;

import com.gumillea.berrfect.core.reg.BerrfectEntityTypes;
import com.gumillea.berrfect.core.reg.BerrfectItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

public class RottenPie extends ThrowableItemProjectile {
    public RottenPie(EntityType<? extends RottenPie> entity, Level world) {
        super(entity, world);
    }

    public RottenPie(Level worldIn, LivingEntity throwerIn) {
        super(BerrfectEntityTypes.ROTTEN_PIE.get(), throwerIn, worldIn);
    }

    public RottenPie(Level worldIn, double x, double y, double z) {
        super(BerrfectEntityTypes.ROTTEN_PIE.get(), x, y, z, worldIn);
    }

    public RottenPie(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(BerrfectEntityTypes.ROTTEN_PIE.get(), world);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        this.level.explode(entity, entity.getX(), entity.getY(), entity.getZ(), 2, Explosion.BlockInteraction.NONE);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        Entity entity = this;
        this.level.explode(entity, entity.getX(), entity.getY(), entity.getZ(), 1.5F, Explosion.BlockInteraction.NONE);

        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return BerrfectItems.ROTTEN_BLISTERBERRY_PIE.get();
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(BerrfectItems.ROTTEN_BLISTERBERRY_PIE.get());
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}