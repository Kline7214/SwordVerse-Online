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
public class RarityProcProcedure {
	@SubscribeEvent
	public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
		execute(event, event.getCrafting());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:rarity_f")))) {
			itemstack.getOrCreateTag().putString("rarity", "F");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:rarity_e")))) {
			itemstack.getOrCreateTag().putString("rarity", "E");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:rarity_d")))) {
			itemstack.getOrCreateTag().putString("rarity", "D");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:rarity_c")))) {
			itemstack.getOrCreateTag().putString("rarity", "C");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:rarity_b")))) {
			itemstack.getOrCreateTag().putString("rarity", "B");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:rarity_a")))) {
			itemstack.getOrCreateTag().putString("rarity", "A");
		} else if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:rarity_s")))) {
			itemstack.getOrCreateTag().putString("rarity", "S");
		}
	}
}
