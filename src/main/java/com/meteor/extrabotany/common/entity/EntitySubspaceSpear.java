package com.meteor.extrabotany.common.entity;

import java.util.List;

import javax.annotation.Nonnull;

import com.meteor.extrabotany.api.ExtraBotanyAPI;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySubspaceSpear extends EntityThrowableCopy{
	
	private static final String TAG_LIVE_TICKS = "liveTicks";
	private static final String TAG_ROTATION = "rotation";
	private static final String TAG_DAMAGE = "damage";
	private static final String TAG_LIFE = "life";
	private static final String TAG_PITCH = "pitch";
	
	private static final DataParameter<Integer> LIVE_TICKS = EntityDataManager.createKey(EntitySubspaceSpear.class, DataSerializers.VARINT);
	private static final DataParameter<Float> ROTATION = EntityDataManager.createKey(EntitySubspaceSpear.class, DataSerializers.FLOAT);
	private static final DataParameter<Integer> DAMAGE = EntityDataManager.createKey(EntitySubspaceSpear.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> LIFE = EntityDataManager.createKey(EntitySubspaceSpear.class, DataSerializers.VARINT);
	private static final DataParameter<Float> PITCH = EntityDataManager.createKey(EntitySubspaceSpear.class, DataSerializers.FLOAT);
	
	public EntitySubspaceSpear(World worldIn) {
		super(worldIn);
	}
	
	public EntitySubspaceSpear(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		setSize(0F, 0F);
		dataManager.register(LIVE_TICKS, 0);
		dataManager.register(ROTATION, 0F);
		dataManager.register(DAMAGE, 0);
		dataManager.register(LIFE, 0);
		dataManager.register(PITCH, 0F);
	}
	
	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}
	
	@Override
	protected float getGravityVelocity(){
		return 0F;
	}
	
	@Override
	public void onUpdate() {
		
		EntityLivingBase thrower = getThrower();
		if(!world.isRemote && (thrower == null || !(thrower instanceof EntityPlayer) || thrower.isDead)) {
			setDead();
			return;
		}
		EntityPlayer player = (EntityPlayer) thrower;
		if(!world.isRemote) {
			AxisAlignedBB axis = new AxisAlignedBB(posX-1F, posY-0.45F, posZ-1F, lastTickPosX+1F, lastTickPosY+0.45F, lastTickPosZ+1F);
			List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, axis);
			for(EntityLivingBase living : entities) {
				if(living == thrower)
					continue;

				if(living.hurtTime == 0) {
					ExtraBotanyAPI.dealTrueDamage(living, getDamage());
					attackedFrom(living, player, getDamage());
				}
				
			}
		}
		super.onUpdate();
		
		if(ticksExisted > getLife())
			setDead();
	}
	
	public static void attackedFrom(EntityLivingBase target, EntityLivingBase player, int i){
		if(player != null && player instanceof EntityPlayer)
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) player), i);
		else 
			target.attackEntityFrom(DamageSource.GENERIC, i);	
	}

	@Override
	protected void onImpact(RayTraceResult pos) {
		EntityLivingBase thrower = getThrower();
		if(pos.entityHit == null || pos.entityHit != thrower) {
			
		}	
	}
	
	@Override
	public void writeEntityToNBT(@Nonnull NBTTagCompound cmp) {
		super.writeEntityToNBT(cmp);
		cmp.setInteger(TAG_LIVE_TICKS, getLiveTicks());
		cmp.setFloat(TAG_ROTATION, getRotation());
		cmp.setInteger(TAG_LIFE, getLife());
		cmp.setInteger(TAG_DAMAGE, getDamage());
		cmp.setFloat(TAG_PITCH, getPitch());
	}
	
	@Override
	public void readEntityFromNBT(@Nonnull NBTTagCompound cmp) {
		super.readEntityFromNBT(cmp);
		setLiveTicks(cmp.getInteger(TAG_LIVE_TICKS));
		setRotation(cmp.getFloat(TAG_ROTATION));
		setLife(cmp.getInteger(TAG_LIFE));
		setDamage(cmp.getInteger(TAG_DAMAGE));
		setPitch(cmp.getFloat(TAG_PITCH));
	}
	
	public int getLiveTicks() {
		return dataManager.get(LIVE_TICKS);
	}

	public void setLiveTicks(int ticks) {
		dataManager.set(LIVE_TICKS, ticks);
	}
	
	public float getRotation() {
		return dataManager.get(ROTATION);
	}

	public void setRotation(float rot) {
		dataManager.set(ROTATION, rot);
	}
	
	public float getPitch() {
		return dataManager.get(PITCH);
	}

	public void setPitch(float rot) {
		dataManager.set(PITCH, rot);
	}
	
	public int getLife() {
		return dataManager.get(LIFE);
	}

	public void setLife(int delay) {
		dataManager.set(LIFE, delay);
	}
	
	public int getDamage() {
		return dataManager.get(DAMAGE);
	}

	public void setDamage(int delay) {
		dataManager.set(DAMAGE, delay);
	}
}
