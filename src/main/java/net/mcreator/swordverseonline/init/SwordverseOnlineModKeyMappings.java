
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.swordverseonline.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.swordverseonline.network.StatScreenKeybindMessage;
import net.mcreator.swordverseonline.SwordverseOnlineMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SwordverseOnlineModKeyMappings {
	public static final KeyMapping STAT_SCREEN_KEYBIND = new KeyMapping("key.swordverse_online.stat_screen_keybind", GLFW.GLFW_KEY_P, "key.categories.swordverse_online") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SwordverseOnlineMod.PACKET_HANDLER.sendToServer(new StatScreenKeybindMessage(0, 0));
				StatScreenKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(STAT_SCREEN_KEYBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				STAT_SCREEN_KEYBIND.consumeClick();
			}
		}
	}
}
