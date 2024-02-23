package net.mcreator.swordverseonline.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

import net.mcreator.swordverseonline.world.inventory.AppraisalMenu;
import net.mcreator.swordverseonline.procedures.AppraisalTypeProcProcedure;
import net.mcreator.swordverseonline.procedures.AppraisalRarityProcProcedure;
import net.mcreator.swordverseonline.procedures.AppraisalGradeProcProcedure;
import net.mcreator.swordverseonline.procedures.AppraisalElementProcProcedure;
import net.mcreator.swordverseonline.procedures.AppraisalAttackProcProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AppraisalScreen extends AbstractContainerScreen<AppraisalMenu> {
	private final static HashMap<String, Object> guistate = AppraisalMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public AppraisalScreen(AppraisalMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 2;
		this.imageHeight = 2;
	}

	private static final ResourceLocation texture = new ResourceLocation("swordverse_online:textures/screens/appraisal.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("swordverse_online:textures/screens/gui_appraisal.png"));
		this.blit(ms, this.leftPos + -128, this.topPos + -78, 0, 0, 264, 170, 264, 170);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.appraisal.label_type"), 39, -26, -3355444);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.appraisal.label_rarity"), 39, -14, -3355444);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.appraisal.label_damage"), 39, -2, -3355444);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.appraisal.label_weight"), 39, 10, -3355444);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.appraisal.label_durability"), 39, 22, -3355444);
		this.font.draw(poseStack,

				AppraisalTypeProcProcedure.execute(entity), 97, -25, -3355444);
		this.font.draw(poseStack,

				AppraisalRarityProcProcedure.execute(entity), 97, -14, -3355444);
		this.font.draw(poseStack,

				AppraisalElementProcProcedure.execute(entity), 97, 23, -3355444);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.appraisal.label_grade"), 39, 33, -3355444);
		this.font.draw(poseStack,

				AppraisalAttackProcProcedure.execute(entity), 97, -1, -3355444);
		this.font.draw(poseStack,

				AppraisalGradeProcProcedure.execute(entity), 97, 34, -3355444);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.appraisal.label_appraisal"), -25, -70, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
