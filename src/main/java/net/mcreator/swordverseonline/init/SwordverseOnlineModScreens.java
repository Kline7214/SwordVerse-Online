
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.swordverseonline.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.swordverseonline.client.gui.UpgradeScreen;
import net.mcreator.swordverseonline.client.gui.SocialScreen;
import net.mcreator.swordverseonline.client.gui.SettingsScreen;
import net.mcreator.swordverseonline.client.gui.SAOinterfaceScreen;
import net.mcreator.swordverseonline.client.gui.ProfileScreen;
import net.mcreator.swordverseonline.client.gui.NavigationScreen;
import net.mcreator.swordverseonline.client.gui.MessageScreen;
import net.mcreator.swordverseonline.client.gui.CraftingScreen;
import net.mcreator.swordverseonline.client.gui.BlacksmithGuiScreen;
import net.mcreator.swordverseonline.client.gui.AppraisalScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SwordverseOnlineModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SwordverseOnlineModMenus.BLACKSMITH_GUI.get(), BlacksmithGuiScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.APPRAISAL.get(), AppraisalScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.CRAFTING.get(), CraftingScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.UPGRADE.get(), UpgradeScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.SA_OINTERFACE.get(), SAOinterfaceScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.PROFILE.get(), ProfileScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.SOCIAL.get(), SocialScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.MESSAGE.get(), MessageScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.NAVIGATION.get(), NavigationScreen::new);
			MenuScreens.register(SwordverseOnlineModMenus.SETTINGS.get(), SettingsScreen::new);
		});
	}
}
