package net.mcreator.swordverseonline.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Entity;

import net.mcreator.swordverseonline.network.SwordverseOnlineModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerEXPProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Monster && sourceentity instanceof Player) {
			{
				double _setval = (sourceentity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).experience + 1;
				sourceentity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.experience = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
	}
}
