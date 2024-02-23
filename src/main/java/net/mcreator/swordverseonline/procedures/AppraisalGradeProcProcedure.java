package net.mcreator.swordverseonline.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.swordverseonline.world.inventory.AppraisalMenu;

import java.util.function.Supplier;
import java.util.Map;

public class AppraisalGradeProcProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof AppraisalMenu) {
			return (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("wGrade");
		}
		return "";
	}
}
