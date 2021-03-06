package com.meteor.extrabotany.common.brew.potion;

import java.util.List;

import com.google.common.collect.Lists;
import com.meteor.extrabotany.common.lib.LibPotionsName;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;

public class PotionDivineJustice extends PotionMod{

	public PotionDivineJustice() {
		super(LibPotionsName.DIVINEJUSTICE, false, 0XFF7F50, 5);
		registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH, "FB353E1C-4180-4865-B01B-BCCE9785ACA3", -0.05F, 1);
	}
	
	@Override
	public List<ItemStack> getCurativeItems(){
		List<ItemStack> list = Lists.newArrayList();
		return list;
	}

}
