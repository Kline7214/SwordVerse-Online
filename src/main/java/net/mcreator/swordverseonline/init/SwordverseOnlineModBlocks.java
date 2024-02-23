
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.swordverseonline.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.swordverseonline.block.BronzeBlockBlock;
import net.mcreator.swordverseonline.SwordverseOnlineMod;

public class SwordverseOnlineModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SwordverseOnlineMod.MODID);
	public static final RegistryObject<Block> BRONZE_BLOCK = REGISTRY.register("bronze_block", () -> new BronzeBlockBlock());
}
