package net.mcreator.swordverseonline.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.swordverseonline.init.SwordverseOnlineModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TeleportCrystalUseProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer(), event.getRawText());
	}

	public static void execute(LevelAccessor world, Entity entity, String text) {
		execute(null, world, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		if (text.contains("Teleport Quick") && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SwordverseOnlineModItems.TELEPORT_CRYSTAL.get()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("blockX")),
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("blockY") + 1),
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("blockZ")));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("blockX")),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("blockY") + 1),
							((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("blockZ")), _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SwordverseOnlineModItems.TELEPORT_CRYSTAL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (text.contains("Teleport World Spawn") && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SwordverseOnlineModItems.TELEPORT_CRYSTAL.get()) {
			{
				Entity _ent = entity;
				_ent.teleportTo((world.getLevelData().getXSpawn()), (world.getLevelData().getYSpawn() + 1), (world.getLevelData().getZSpawn()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((world.getLevelData().getXSpawn()), (world.getLevelData().getYSpawn() + 1), (world.getLevelData().getZSpawn()), _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SwordverseOnlineModItems.TELEPORT_CRYSTAL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (text.contains("Teleport Bed") && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SwordverseOnlineModItems.TELEPORT_CRYSTAL.get()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(
						((entity instanceof ServerPlayer _player && !_player.level.isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level.getLevelData().getXSpawn())
								: 0),
						(((entity instanceof ServerPlayer _player && !_player.level.isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level.getLevelData().getYSpawn())
								: 0) + 1),
						((entity instanceof ServerPlayer _player && !_player.level.isClientSide())
								? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level.getLevelData().getZSpawn())
								: 0));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(
							((entity instanceof ServerPlayer _player && !_player.level.isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getX() : _player.level.getLevelData().getXSpawn())
									: 0),
							(((entity instanceof ServerPlayer _player && !_player.level.isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getY() : _player.level.getLevelData().getYSpawn())
									: 0) + 1),
							((entity instanceof ServerPlayer _player && !_player.level.isClientSide())
									? ((_player.getRespawnDimension().equals(_player.level.dimension()) && _player.getRespawnPosition() != null) ? _player.getRespawnPosition().getZ() : _player.level.getLevelData().getZSpawn())
									: 0),
							_ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(SwordverseOnlineModItems.TELEPORT_CRYSTAL.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
