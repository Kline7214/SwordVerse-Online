package net.mcreator.swordverseonline.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;

public class RemoveVanWeaponRecipesProcProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.server.getRecipeManager().byKey(new ResourceLocation("minecraft:wooden_sword")).ifPresent(_rec -> _serverPlayer.resetRecipes(Collections.singleton(_rec)));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.server.getRecipeManager().byKey(new ResourceLocation("minecraft:stone_sword")).ifPresent(_rec -> _serverPlayer.resetRecipes(Collections.singleton(_rec)));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.server.getRecipeManager().byKey(new ResourceLocation("minecraft:iron_sword")).ifPresent(_rec -> _serverPlayer.resetRecipes(Collections.singleton(_rec)));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.server.getRecipeManager().byKey(new ResourceLocation("minecraft:gold_sword")).ifPresent(_rec -> _serverPlayer.resetRecipes(Collections.singleton(_rec)));
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.server.getRecipeManager().byKey(new ResourceLocation("minecraft:diamond_sword")).ifPresent(_rec -> _serverPlayer.resetRecipes(Collections.singleton(_rec)));
	}
}
