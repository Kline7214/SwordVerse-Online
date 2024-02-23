package net.mcreator.swordverseonline.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WTypeProcProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getCrafting());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:swords")))) {
			itemstack.getOrCreateTag().putString("wType", "Sword");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:pickaxes")))) {
			itemstack.getOrCreateTag().putString("wType", "Pickaxe");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:axes")))) {
			itemstack.getOrCreateTag().putString("wType", "Axe");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:bows")))) {
			itemstack.getOrCreateTag().putString("wType", "Bow");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:shovels")))) {
			itemstack.getOrCreateTag().putString("wType", "Shovel");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:shields")))) {
			itemstack.getOrCreateTag().putString("wType", "Shield");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:spears")))) {
			itemstack.getOrCreateTag().putString("wType", "Spear");
		}
	}
}
