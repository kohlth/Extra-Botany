package com.meteor.extrabotany.common.item.relic;

import java.util.Random;

import javax.annotation.Nonnull;

import com.meteor.extrabotany.common.brew.ModPotions;
import com.meteor.extrabotany.common.core.handler.ModSounds;
import com.meteor.extrabotany.common.entity.EntitySubspace;
import com.meteor.extrabotany.common.lib.LibItemsName;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.core.helper.Vector3;

public class ItemSpearSubspace extends ItemModRelic implements IManaUsingItem{

	public ItemSpearSubspace() {
		super(LibItemsName.SPEARSUBSPACE);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if(!world.isRemote && entity instanceof EntityPlayer){
			updateRelic(stack, (EntityPlayer) entity);
			if(((EntityPlayer)entity).swingProgressInt == 1){
				EntityPlayer player = (EntityPlayer) entity;
				if (!player.getHeldItemMainhand().isEmpty()
						&& player.getHeldItemMainhand().getItem() == this) {
					EntitySubspace sub = new EntitySubspace(world, (EntityPlayer) player);
					 sub.setLiveTicks(27);
					 sub.setDelay(10);
					 sub.posX = entity.posX;
					 sub.posY = entity.posY + 2.5F + world.rand.nextFloat() * 0.2F;
					 sub.posZ = entity.posZ;
					 sub.rotationYaw = player.rotationYaw;
					 sub.setRotation(MathHelper.wrapDegrees(-player.rotationYaw + 180));
					 sub.setType(1);
					 sub.setSize(0.40F + world.rand.nextFloat() * 0.15F);
					 if(!world.isRemote)
						 world.spawnEntity(sub);
				}
			}
		}
	}
	
	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, EntityPlayer player, @Nonnull EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		player.setActiveHand(hand);
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}
	
	 @Override
	  public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase player, int timeLeft) {
		 player.setSprinting(true);
		 player.setJumping(true);
		 player.motionY +=2.5F;
		 
		 if(!world.isRemote){
			 if(ManaItemHandler.requestManaExactForTool(stack, (EntityPlayer) player, 4000, true))
				 ((EntityPlayer)player).getCooldownTracker().setCooldown(this, 400);
			 else
				 ((EntityPlayer)player).getCooldownTracker().setCooldown(this, 800);
			 for(int i = 0; i < 24; i++){
				 
					Vector3 look = new Vector3(player.getLookVec()).multiply(1, 0, 1);
					
					double playerRot = Math.toRadians(player.rotationYaw + 90);
					if(look.x == 0 && look.z == 0)
						look = new Vector3(Math.cos(playerRot), 0, Math.sin(playerRot));
						
					look = look.normalize().multiply(-2);

					int div = i / 8;
					int mod = i % 8;

					Vector3 pl = look.add(Vector3.fromEntityCenter(player)).add(0, 1.6, div * 0.1);

					Random rand = player.world.rand;
					Vector3 axis = look.normalize().crossProduct(new Vector3(-1, 0, -1)).normalize();

					double rot = mod * Math.PI / 7 - Math.PI / 2;

					Vector3 axis1 = axis.multiply(div * 3.5 + 5).rotate(rot, look);
					if(axis1.y < 0)
						axis1 = axis1.multiply(1, -1, 1);

					Vector3 end = pl.add(axis1);
					
				 EntitySubspace sub = new EntitySubspace(world, (EntityPlayer) player);
				 sub.setLiveTicks(120);
				 sub.setDelay(15 + world.rand.nextInt(12));
				 sub.posX = end.x;
				 sub.posY = end.y - 0.5F + world.rand.nextFloat();
				 sub.posZ = end.z;
				 sub.rotationYaw = player.rotationYaw;
				 sub.setRotation(MathHelper.wrapDegrees(-player.rotationYaw + 180));
				 sub.setInterval(10 + world.rand.nextInt(10));
				 sub.setSize(1.0F + world.rand.nextFloat());
				 sub.setType(0);
				 if(!world.isRemote)
					 world.spawnEntity(sub);
				 if(i==1)
					 sub.playSound(ModSounds.spearsubspace, 1F, 1F);
				 
			 }
			 player.addPotionEffect(new PotionEffect(ModPotions.eternity, 120, 0));
		 }
		 
		 super.onPlayerStoppedUsing(stack, world, player, timeLeft);
	  }
	 
	  @Nonnull
	  @Override
	  public EnumAction getItemUseAction(ItemStack stack) {
	    return EnumAction.NONE;
	  }

	  @Override
	  public int getMaxItemUseDuration(ItemStack stack) {
	    return 200;
	  }

	@Override
	public boolean usesMana(ItemStack arg0) {
		return true;
	}

}
