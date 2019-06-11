package com.meteor.extrabotany.common.item;

import javax.annotation.Nonnull;

import com.meteor.extrabotany.ExtraBotanyCreativeTab;
import com.meteor.extrabotany.client.ClientProxy;
import com.meteor.extrabotany.client.render.IModelReg;
import com.meteor.extrabotany.common.lib.LibMisc;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMod extends Item implements IModelReg {

	public ItemMod(String name) {
		setCreativeTab(ExtraBotanyCreativeTab.INSTANCE);
		setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
		setUnlocalizedName(name);
		addPropertyOverride(new ResourceLocation("extrabotany:chris"), (stack, worldIn, entityIn) -> {
			return ClientProxy.christmas ? 1.0F : 0.0F;
		});
	}

	@Nonnull
	@Override
	public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
		return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("item\\.", "item." + LibMisc.MOD_ID + ":");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
