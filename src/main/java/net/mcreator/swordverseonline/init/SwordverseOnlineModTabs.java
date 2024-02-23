
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.swordverseonline.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.CreativeModeTabs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SwordverseOnlineModTabs {
	@SubscribeEvent
	public static void buildTabContentsVanilla(CreativeModeTabEvent.BuildContents tabData) {

		if (tabData.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(SwordverseOnlineModBlocks.BRONZE_BLOCK.get().asItem());
		}

		if (tabData.getTab() == CreativeModeTabs.COMBAT) {
			tabData.accept(SwordverseOnlineModItems.HEALING_CRYSTAL.get());
			tabData.accept(SwordverseOnlineModItems.CURING_CRYSTAL.get());
			tabData.accept(SwordverseOnlineModItems.TELEPORT_CRYSTAL.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_SWORD.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_CHESTPLATE.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_LEGGINGS.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_BOOTS.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_RAPIER.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_DAGGER.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_LANCE.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_BATTLE_AXE.get());
			tabData.accept(SwordverseOnlineModItems.IRON_BATTLE_AXE.get());
			tabData.accept(SwordverseOnlineModItems.IRON_SPEAR.get());
			tabData.accept(SwordverseOnlineModItems.IRON_RAPIER.get());
			tabData.accept(SwordverseOnlineModItems.IRON_DAGGER.get());
			tabData.accept(SwordverseOnlineModItems.NETHERITE_BATTLE_AXE.get());
			tabData.accept(SwordverseOnlineModItems.NETHERITE_DAGGER.get());
			tabData.accept(SwordverseOnlineModItems.NETHERITE_RAPIER.get());
			tabData.accept(SwordverseOnlineModItems.NETHERITE_SPEAR.get());
			tabData.accept(SwordverseOnlineModItems.GOLDEN_BATTLE_AXE.get());
			tabData.accept(SwordverseOnlineModItems.STONE_BATTLE_AXE.get());
			tabData.accept(SwordverseOnlineModItems.WOODEN_BATTLE_AXE.get());
			tabData.accept(SwordverseOnlineModItems.GOLDEN_SPEAR.get());
			tabData.accept(SwordverseOnlineModItems.DIAMOND_SPEAR.get());
			tabData.accept(SwordverseOnlineModItems.STONE_SPEAR.get());
			tabData.accept(SwordverseOnlineModItems.WOODEN_SPEAR.get());
			tabData.accept(SwordverseOnlineModItems.GOLDEN_DAGGER.get());
			tabData.accept(SwordverseOnlineModItems.DIAMOND_DAGGER.get());
			tabData.accept(SwordverseOnlineModItems.STONE_DAGGER.get());
			tabData.accept(SwordverseOnlineModItems.WOODEN_DAGGER.get());
			tabData.accept(SwordverseOnlineModItems.DIAMOND_RAPIER.get());
			tabData.accept(SwordverseOnlineModItems.GOLDEN_RAPIER.get());
			tabData.accept(SwordverseOnlineModItems.DIAMOND_BATTLE_AXE.get());
			tabData.accept(SwordverseOnlineModItems.STONE_RAPIER.get());
			tabData.accept(SwordverseOnlineModItems.WOODEN_RAPIER.get());
			tabData.accept(SwordverseOnlineModItems.DIAMOND_MACE.get());
			tabData.accept(SwordverseOnlineModItems.GOLDEN_MACE.get());
			tabData.accept(SwordverseOnlineModItems.IRON_MACE.get());
			tabData.accept(SwordverseOnlineModItems.STONE_MACE.get());
			tabData.accept(SwordverseOnlineModItems.WOODEN_MACE.get());
			tabData.accept(SwordverseOnlineModItems.NETHERITE_MACE.get());
			tabData.accept(SwordverseOnlineModItems.BRONZE_MACE.get());
		}

		if (tabData.getTab() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(SwordverseOnlineModItems.BLACKSMITH_SPAWN_EGG.get());
		}

		if (tabData.getTab() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(SwordverseOnlineModItems.BRONZE_INGOT.get());
			tabData.accept(SwordverseOnlineModItems.DIAMOND_SHARD.get());
			tabData.accept(SwordverseOnlineModItems.UPGRADE_MOD_B.get());
			tabData.accept(SwordverseOnlineModItems.UPGRADE_MOD_A.get());
			tabData.accept(SwordverseOnlineModItems.UPGRADE_MOD_S.get());
			tabData.accept(SwordverseOnlineModItems.UPGRADE_MOD_SS.get());
			tabData.accept(SwordverseOnlineModItems.UPGRADE_MOD_SSS.get());
			tabData.accept(SwordverseOnlineModItems.UPGRADE_MOD_SSS_PLUS.get());
			tabData.accept(SwordverseOnlineModItems.WOLF_CLAW.get());
			tabData.accept(SwordverseOnlineModItems.BOAR_HIDE.get());
			tabData.accept(SwordverseOnlineModItems.POINTED_STINGER.get());
			tabData.accept(SwordverseOnlineModItems.UPGRADE_MOD_C.get());
		}

		if (tabData.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(SwordverseOnlineModItems.WOODEN_HAMMER.get());
			tabData.accept(SwordverseOnlineModItems.STONE_HAMMER.get());
			tabData.accept(SwordverseOnlineModItems.IRON_HAMMER.get());
			tabData.accept(SwordverseOnlineModItems.GOLDEN_HAMMER.get());
			tabData.accept(SwordverseOnlineModItems.DIAMOND_HAMMER.get());
			tabData.accept(SwordverseOnlineModItems.NETHERITE_HAMMER.get());
		}
	}
}
