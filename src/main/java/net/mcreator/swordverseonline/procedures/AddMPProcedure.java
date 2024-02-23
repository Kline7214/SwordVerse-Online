package net.mcreator.swordverseonline.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.swordverseonline.network.SwordverseOnlineModVariables;

public class AddMPProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).points - 1;
			entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.points = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Speed + 1;
			entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Speed = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
