package net.mcreator.swordverseonline.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.swordverseonline.network.SwordverseOnlineModVariables;

public class RenderSPDProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + (entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Speed;
	}
}
