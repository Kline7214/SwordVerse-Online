package net.mcreator.swordverseonline.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.swordverseonline.network.SwordverseOnlineModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerSPDProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SwordverseOnlineModVariables.PlayerVariables())).Speed;
			entity.getCapability(SwordverseOnlineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Speed = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
