
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.swordverseonline.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.swordverseonline.world.inventory.UpgradeMenu;
import net.mcreator.swordverseonline.world.inventory.StatScreenMenu;
import net.mcreator.swordverseonline.world.inventory.CraftingMenu;
import net.mcreator.swordverseonline.world.inventory.BlacksmithGuiMenu;
import net.mcreator.swordverseonline.world.inventory.AppraisalMenu;
import net.mcreator.swordverseonline.SwordverseOnlineMod;

public class SwordverseOnlineModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SwordverseOnlineMod.MODID);
	public static final RegistryObject<MenuType<BlacksmithGuiMenu>> BLACKSMITH_GUI = REGISTRY.register("blacksmith_gui", () -> IForgeMenuType.create(BlacksmithGuiMenu::new));
	public static final RegistryObject<MenuType<AppraisalMenu>> APPRAISAL = REGISTRY.register("appraisal", () -> IForgeMenuType.create(AppraisalMenu::new));
	public static final RegistryObject<MenuType<CraftingMenu>> CRAFTING = REGISTRY.register("crafting", () -> IForgeMenuType.create(CraftingMenu::new));
	public static final RegistryObject<MenuType<UpgradeMenu>> UPGRADE = REGISTRY.register("upgrade", () -> IForgeMenuType.create(UpgradeMenu::new));
	public static final RegistryObject<MenuType<StatScreenMenu>> STAT_SCREEN = REGISTRY.register("stat_screen", () -> IForgeMenuType.create(StatScreenMenu::new));
}
