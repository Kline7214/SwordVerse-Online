package net.mcreator.swordverseonline.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class RenderHPProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (new java.text.DecimalFormat("##").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + "/" + (new java.text.DecimalFormat("##").format(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
	}
}
