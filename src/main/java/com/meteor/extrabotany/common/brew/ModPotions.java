package com.meteor.extrabotany.common.brew;

import com.meteor.extrabotany.common.brew.potion.PotionBlackSabbath;
import com.meteor.extrabotany.common.brew.potion.PotionConstantPain;
import com.meteor.extrabotany.common.brew.potion.PotionDivineJustice;
import com.meteor.extrabotany.common.brew.potion.PotionEternity;
import com.meteor.extrabotany.common.brew.potion.PotionMindCrack;
import com.meteor.extrabotany.common.brew.potion.PotionReflect;
import com.meteor.extrabotany.common.lib.LibMisc;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public class ModPotions {
	
	public static final Potion mindcrack = new PotionMindCrack();
	public static final Potion eternity = new PotionEternity();
	public static final Potion reflect = new PotionReflect();
	public static final Potion constantpain = new PotionConstantPain();
	public static final Potion divinejustice = new PotionDivineJustice();
	public static final Potion blacksabbath = new PotionBlackSabbath();
	
	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> evt){
		evt.getRegistry().register(mindcrack);
		evt.getRegistry().register(eternity);
		evt.getRegistry().register(reflect);
		evt.getRegistry().register(constantpain);
		evt.getRegistry().register(divinejustice);
		evt.getRegistry().register(blacksabbath);
	}

}
