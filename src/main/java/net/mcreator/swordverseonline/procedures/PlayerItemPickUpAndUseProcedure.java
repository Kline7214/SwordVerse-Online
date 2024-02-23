package net.mcreator.swordverseonline.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.swordverseonline.network.SwordverseOnlineModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerItemPickUpAndUseProcedure {
	@SubscribeEvent
	public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:wooden_tools")))) {
			if ((entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Strength < 1) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		} else if ((entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:stone_tools")))) {
			if ((entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Strength < 10) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		} else if ((entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:golden_tools")))) {
			if ((entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Strength < 20) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		} else if ((entity instanceof LivingEntity _entUseItem6 ? _entUseItem6.getUseItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:iron_tools")))) {
			if ((entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Strength < 30) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		} else if ((entity instanceof LivingEntity _entUseItem8 ? _entUseItem8.getUseItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:diamond_tools")))) {
			if ((entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Strength < 40) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		} else if ((entity instanceof LivingEntity _entUseItem10 ? _entUseItem10.getUseItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:netherite_tools")))) {
			if ((entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Strength < 50) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}
}
