package com.meteor.extrabotany.common.item;

import com.meteor.extrabotany.common.core.config.ConfigHandler;
import com.meteor.extrabotany.common.item.bonus.ItemCandyBag;
import com.meteor.extrabotany.common.item.bonus.ItemRewardBag;
import com.meteor.extrabotany.common.item.brew.ItemBrewCocktail;
import com.meteor.extrabotany.common.item.brew.ItemBrewInfiniteWine;
import com.meteor.extrabotany.common.item.brew.ItemBrewSplashGrenade;
import com.meteor.extrabotany.common.item.equipment.armor.combatmaid.ItemCombatMaidBoots;
import com.meteor.extrabotany.common.item.equipment.armor.combatmaid.ItemCombatMaidChest;
import com.meteor.extrabotany.common.item.equipment.armor.combatmaid.ItemCombatMaidChestDarkened;
import com.meteor.extrabotany.common.item.equipment.armor.combatmaid.ItemCombatMaidHelm;
import com.meteor.extrabotany.common.item.equipment.armor.combatmaid.ItemCombatMaidHelmRevealing;
import com.meteor.extrabotany.common.item.equipment.armor.combatmaid.ItemCombatMaidLegs;
import com.meteor.extrabotany.common.item.equipment.armor.cosmeticmaid.ItemCosmeticMaidBoots;
import com.meteor.extrabotany.common.item.equipment.armor.cosmeticmaid.ItemCosmeticMaidChest;
import com.meteor.extrabotany.common.item.equipment.armor.cosmeticmaid.ItemCosmeticMaidHelm;
import com.meteor.extrabotany.common.item.equipment.armor.cosmeticmaid.ItemCosmeticMaidHelmRevealing;
import com.meteor.extrabotany.common.item.equipment.armor.cosmeticmaid.ItemCosmeticMaidLegs;
import com.meteor.extrabotany.common.item.equipment.armor.shadowwarrior.ItemShadowWarriorBoots;
import com.meteor.extrabotany.common.item.equipment.armor.shadowwarrior.ItemShadowWarriorChest;
import com.meteor.extrabotany.common.item.equipment.armor.shadowwarrior.ItemShadowWarriorHelm;
import com.meteor.extrabotany.common.item.equipment.armor.shadowwarrior.ItemShadowWarriorLegs;
import com.meteor.extrabotany.common.item.equipment.bauble.ItemCoreGod;
import com.meteor.extrabotany.common.item.equipment.bauble.ItemDeathRing;
import com.meteor.extrabotany.common.item.equipment.bauble.ItemFrostStar;
import com.meteor.extrabotany.common.item.equipment.bauble.ItemPureDaisyPendant;
import com.meteor.extrabotany.common.item.equipment.bauble.ItemRedScarf;
import com.meteor.extrabotany.common.item.equipment.bauble.ItemSuperCrown;
import com.meteor.extrabotany.common.item.equipment.shield.ItemElementiumShield;
import com.meteor.extrabotany.common.item.equipment.shield.ItemManasteelShield;
import com.meteor.extrabotany.common.item.equipment.shield.ItemTerrasteelShield;
import com.meteor.extrabotany.common.item.equipment.tool.ItemBinder;
import com.meteor.extrabotany.common.item.equipment.tool.ItemHammer;
import com.meteor.extrabotany.common.item.equipment.tool.ItemHammerUltimate;
import com.meteor.extrabotany.common.item.equipment.tool.ItemKingGarden;
import com.meteor.extrabotany.common.item.equipment.tool.ItemManaReader;
import com.meteor.extrabotany.common.item.equipment.tool.ItemMasterHandbag;
import com.meteor.extrabotany.common.item.equipment.tool.ItemNatureOrb;
import com.meteor.extrabotany.common.item.equipment.tool.ItemShadowKatana;
import com.meteor.extrabotany.common.item.record.ItemRecordA;
import com.meteor.extrabotany.common.item.relic.ItemAchilleshield;
import com.meteor.extrabotany.common.item.relic.ItemBuddhistRelics;
import com.meteor.extrabotany.common.item.relic.ItemCamera;
import com.meteor.extrabotany.common.item.relic.ItemExcaliber;
import com.meteor.extrabotany.common.item.relic.ItemFailnaught;
import com.meteor.extrabotany.common.item.relic.ItemMasterManaRing;
import com.meteor.extrabotany.common.item.relic.ItemPocketWatchMoon;
import com.meteor.extrabotany.common.item.relic.ItemSpearSubspace;
import com.meteor.extrabotany.common.item.relic.ItemTreasure;
import com.meteor.extrabotany.common.lib.LibItemsName;
import com.meteor.extrabotany.common.lib.LibMisc;
import com.meteor.extrabotany.common.lib.LibOreDicts;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import vazkii.botania.api.BotaniaAPI;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public class ModItems {
	
	public static final Item manaReader = new ItemManaReader();
	public static final Item spiritFuel = new ItemSpiritFuel();
	public static final Item nightmareFuel = new ItemNightmareFuel();
	public static final Item material = new ItemMaterial();
	public static final Item friedchicken = new ItemFriedChicken();
	public static final Item gildedmashedpotato = new ItemGildedMashedPotato();
	public static final Item manadrink = new ItemManaDrink();
	
	public static final Item binder = new ItemBinder();
	
	public static final Item froststar = new ItemFrostStar();
	public static final Item deathring = new ItemDeathRing();
	public static final Item mastermanaring = new ItemMasterManaRing();
	public static final Item puredaisypendant = new ItemPureDaisyPendant();
	public static final Item supercrown = new ItemSuperCrown();
	public static final Item redscarf = new ItemRedScarf();
	public static final Item godcore = new ItemCoreGod();
	
	public static final Item hammermanasteel = new ItemHammer(LibItemsName.HAMMER_MANASTEEL, BotaniaAPI.manasteelToolMaterial);
	public static final Item hammerelementium = new ItemHammer(LibItemsName.HAMMER_ELEMENTIUM, BotaniaAPI.elementiumToolMaterial);
	public static final Item hammerterrasteel = new ItemHammer(LibItemsName.HAMMER_TERRASTEEL, BotaniaAPI.terrasteelToolMaterial);
	public static final Item hammerultimate = new ItemHammerUltimate();
	
	public static final Item kinggarden = new ItemKingGarden();
	public static final Item camera = new ItemCamera();
	public static final Item orb = new ItemNatureOrb();
	public static final Item failnaught = new ItemFailnaught();
	public static final Item pocketwatch = new ItemPocketWatchMoon();
	public static final Item excaliber = new ItemExcaliber();
	
	public static final Item splashgrenade = new ItemBrewSplashGrenade();
	public static final Item cocktail = new ItemBrewCocktail();
	public static final Item infinitewine = new ItemBrewInfiniteWine();
	
	public static final Item treasure = new ItemTreasure();
	public static final Item gaiarecord = new ItemRecordA();
	
	public static final Item manasteelshield = new ItemManasteelShield();
	public static final Item terrasteelshield = new ItemTerrasteelShield();
	public static final Item elementiumshield = new ItemElementiumShield();
	public static final Item relicshield = new ItemAchilleshield();
	public static final Item relics = new ItemBuddhistRelics();
	
	public static final Item cmhelm = new ItemCombatMaidHelm();
	public static final Item cmchest = new ItemCombatMaidChest();
	public static final Item cmleg = new ItemCombatMaidLegs();
	public static final Item cmboot = new ItemCombatMaidBoots();
	public static final Item cmhelmrevealing = new ItemCombatMaidHelmRevealing();
	public static final Item cmchestdarkened = new ItemCombatMaidChestDarkened();
	
	public static final Item cosmhelm = new ItemCosmeticMaidHelm();
	public static final Item cosmchest = new ItemCosmeticMaidChest();
	public static final Item cosmleg = new ItemCosmeticMaidLegs();
	public static final Item cosmboot = new ItemCosmeticMaidBoots();
	public static final Item coshelmrevealing = new ItemCosmeticMaidHelmRevealing();
	
	public static final Item swhelm = new ItemShadowWarriorHelm();
	public static final Item swchest = new ItemShadowWarriorChest();
	public static final Item swleg = new ItemShadowWarriorLegs();
	public static final Item swboot = new ItemShadowWarriorBoots();
	public static final Item shadowkatana = new ItemShadowKatana();
	
	public static final Item flyingboat = new ItemFlyingBoat();
	public static final Item masterhandbag = new ItemMasterHandbag();
	public static final Item spearsubspace = new ItemSpearSubspace();
	
	public static final Item candy = new ItemHalloweenCandy();

	public static final Item rewardbag = new ItemRewardBag();
	public static final Item candybag = new ItemCandyBag();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> evt) {
		IForgeRegistry<Item> r = evt.getRegistry();
		r.register(manaReader);
		r.register(spiritFuel);
		r.register(nightmareFuel);
		r.register(material);
		r.register(friedchicken);
		r.register(froststar);
		r.register(deathring);
		r.register(hammermanasteel);
		r.register(hammerelementium);
		r.register(hammerterrasteel);
		r.register(gildedmashedpotato);
		r.register(hammerultimate);
		r.register(binder);
		r.register(kinggarden);
		r.register(camera);
		r.register(orb);
		r.register(failnaught);
		r.register(relics);
		r.register(treasure);
		r.register(gaiarecord);
		if(ConfigHandler.ENABLE_SHIELD){
			r.register(manasteelshield);
			r.register(terrasteelshield);
			r.register(elementiumshield);
		}
		r.register(relicshield);
		r.register(mastermanaring);
		r.register(cmboot);
		r.register(cmchest);
		r.register(cmhelm);
		r.register(cmleg);
		r.register(cosmhelm);
		r.register(cosmchest);
		r.register(cosmleg);
		r.register(cosmboot);
		r.register(manadrink);
		r.register(splashgrenade);
		r.register(cocktail);
		r.register(infinitewine);
		r.register(flyingboat);
		r.register(coshelmrevealing);
		r.register(cmhelmrevealing);
		r.register(swboot);
		r.register(swchest);
		r.register(swhelm);
		r.register(swleg);
		r.register(cmchestdarkened);
		r.register(shadowkatana);
		r.register(excaliber);
		r.register(puredaisypendant);
		r.register(supercrown);
		r.register(redscarf);
		r.register(masterhandbag);
		r.register(spearsubspace);
		r.register(godcore);
		r.register(candy);
		
		r.register(rewardbag);
		r.register(candybag);
		registerOreDictionary();
	}
	
	private static void registerOreDictionary() {
		OreDictionary.registerOre(LibOreDicts.SHADOWIUM, new ItemStack(material, 1, 5));
		OreDictionary.registerOre(LibOreDicts.ORICHALCOS, new ItemStack(material, 1, 1));
		for(int i = 0; i < 2; i++)
			OreDictionary.registerOre(LibOreDicts.COREGOD, new ItemStack(godcore, 1, i));
	}
}
