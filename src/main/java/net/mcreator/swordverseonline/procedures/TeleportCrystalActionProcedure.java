package net.mcreator.swordverseonline.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.swordverseonline.init.SwordverseOnlineModItems;

public class TeleportCrystalActionProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SwordverseOnlineModItems.TELEPORT_CRYSTAL.get()) {
			itemstack.getOrCreateTag().putDouble("blockX", (entity.getX()));
			itemstack.getOrCreateTag().putDouble("blockY", (entity.getY()));
			itemstack.getOrCreateTag().putDouble("blockZ", (entity.getZ()));
			itemstack.getOrCreateTag().putBoolean("canTeleport", true);
		}
	}
}
