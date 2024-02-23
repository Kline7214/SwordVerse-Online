package net.mcreator.swordverseonline.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.swordverseonline.network.SwordverseOnlineModVariables;

public class RenderMPProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + new java.text.DecimalFormat("##").format((entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).magicPower);
	}
}
