
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.swordverseonline.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.swordverseonline.SwordverseOnlineMod;

public class SwordverseOnlineModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SwordverseOnlineMod.MODID);
	public static final RegistryObject<SoundEvent> DEATH_PARTICALE = REGISTRY.register("death_particale", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("swordverse_online", "death_particale")));
	public static final RegistryObject<SoundEvent> CONFIRM = REGISTRY.register("confirm", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("swordverse_online", "confirm")));
	public static final RegistryObject<SoundEvent> DIALOG_CLOSE = REGISTRY.register("dialog_close", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("swordverse_online", "dialog_close")));
	public static final RegistryObject<SoundEvent> MENU = REGISTRY.register("menu", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("swordverse_online", "menu")));
	public static final RegistryObject<SoundEvent> MESSAGE = REGISTRY.register("message", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("swordverse_online", "message")));
	public static final RegistryObject<SoundEvent> INTERFACE_DROPDOWN = REGISTRY.register("interface_dropdown", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("swordverse_online", "interface_dropdown")));
}
