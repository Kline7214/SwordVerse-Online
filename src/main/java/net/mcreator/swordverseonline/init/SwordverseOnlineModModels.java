
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.swordverseonline.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.swordverseonline.client.model.Modelbronze_armor;
import net.mcreator.swordverseonline.client.model.ModelBlacksmith;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SwordverseOnlineModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelBlacksmith.LAYER_LOCATION, ModelBlacksmith::createBodyLayer);
		event.registerLayerDefinition(Modelbronze_armor.LAYER_LOCATION, Modelbronze_armor::createBodyLayer);
	}
}
