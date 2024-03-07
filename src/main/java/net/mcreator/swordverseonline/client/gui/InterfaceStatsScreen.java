package net.mcreator.swordverseonline.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;

import net.mcreator.swordverseonline.world.inventory.InterfaceStatsMenu;
import net.mcreator.swordverseonline.procedures.RenderSTGProcedure;
import net.mcreator.swordverseonline.procedures.RenderSPDProcedure;
import net.mcreator.swordverseonline.procedures.RenderPlayerNameProcedure;
import net.mcreator.swordverseonline.procedures.RenderPlayerInStatScreenProcedure;
import net.mcreator.swordverseonline.procedures.RenderMPProcedure;
import net.mcreator.swordverseonline.procedures.RenderLvProcedure;
import net.mcreator.swordverseonline.procedures.RenderHPProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class InterfaceStatsScreen extends AbstractContainerScreen<InterfaceStatsMenu> {
	private final static HashMap<String, Object> guistate = InterfaceStatsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_profile;
	ImageButton imagebutton_social;
	ImageButton imagebutton_message;
	ImageButton imagebutton_navigation;
	ImageButton imagebutton_settings;
	ImageButton imagebutton_skills_button;
	ImageButton imagebutton_stats_button;
	ImageButton imagebutton_add_stat_button;
	ImageButton imagebutton_add_stat_button1;
	ImageButton imagebutton_add_stat_button2;
	ImageButton imagebutton_add_stat_button3;
	ImageButton imagebutton_add_stat_button4;

	public InterfaceStatsScreen(InterfaceStatsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("swordverse_online:textures/screens/interface_stats.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		if (RenderPlayerInStatScreenProcedure.execute(world, x, y, z, entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(ms, this.leftPos + -88, this.topPos + -10, 45, 0f + (float) Math.atan((this.leftPos + -88 - mouseX) / 40.0), (float) Math.atan((this.topPos + -59 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("swordverse_online:textures/screens/profilebg.png"));
		this.blit(ms, this.leftPos + -150, this.topPos + -123, 0, 0, 135, 200, 135, 200);

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
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.interface_stats.label_lv"), -148, 14, -12829636);
		this.font.draw(poseStack,

				RenderLvProcedure.execute(entity), -126, 14, -12829636);
		this.font.draw(poseStack,

				RenderHPProcedure.execute(entity), -126, 24, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.interface_stats.label_hp"), -148, 24, -12829636);
		this.font.draw(poseStack,

				RenderSTGProcedure.execute(entity), -126, 34, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.interface_stats.label_str"), -148, 34, -12829636);
		this.font.draw(poseStack,

				RenderSPDProcedure.execute(entity), -126, 44, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.interface_stats.label_spd"), -148, 44, -12829636);
		this.font.draw(poseStack,

				RenderMPProcedure.execute(entity), -126, 54, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.interface_stats.label_mp"), -148, 54, -12829636);
		this.font.draw(poseStack,

				RenderPlayerNameProcedure.execute(world, x, y, z, entity), -129, -117, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.interface_stats.label_skills"), 34, -47, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.interface_stats.label_stats"), 121, -47, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_profile = new ImageButton(this.leftPos + -10, this.topPos + -53, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_profile.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_profile", imagebutton_profile);
		this.addRenderableWidget(imagebutton_profile);
		imagebutton_social = new ImageButton(this.leftPos + -10, this.topPos + -29, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_social.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_social", imagebutton_social);
		this.addRenderableWidget(imagebutton_social);
		imagebutton_message = new ImageButton(this.leftPos + -10, this.topPos + -5, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_message.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_message", imagebutton_message);
		this.addRenderableWidget(imagebutton_message);
		imagebutton_navigation = new ImageButton(this.leftPos + -10, this.topPos + 19, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_navigation.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_navigation", imagebutton_navigation);
		this.addRenderableWidget(imagebutton_navigation);
		imagebutton_settings = new ImageButton(this.leftPos + -10, this.topPos + 43, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_settings.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_settings", imagebutton_settings);
		this.addRenderableWidget(imagebutton_settings);
		imagebutton_skills_button = new ImageButton(this.leftPos + 16, this.topPos + -52, 82, 18, 0, 0, 18, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_skills_button.png"), 82, 36, e -> {
		});
		guistate.put("button:imagebutton_skills_button", imagebutton_skills_button);
		this.addRenderableWidget(imagebutton_skills_button);
		imagebutton_stats_button = new ImageButton(this.leftPos + 103, this.topPos + -52, 82, 18, 0, 0, 18, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_stats_button.png"), 82, 36, e -> {
		});
		guistate.put("button:imagebutton_stats_button", imagebutton_stats_button);
		this.addRenderableWidget(imagebutton_stats_button);
		imagebutton_add_stat_button = new ImageButton(this.leftPos + -48, this.topPos + 13, 11, 11, 0, 0, 11, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_add_stat_button.png"), 11, 22, e -> {
		});
		guistate.put("button:imagebutton_add_stat_button", imagebutton_add_stat_button);
		this.addRenderableWidget(imagebutton_add_stat_button);
		imagebutton_add_stat_button1 = new ImageButton(this.leftPos + -48, this.topPos + 23, 11, 11, 0, 0, 11, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_add_stat_button1.png"), 11, 22, e -> {
		});
		guistate.put("button:imagebutton_add_stat_button1", imagebutton_add_stat_button1);
		this.addRenderableWidget(imagebutton_add_stat_button1);
		imagebutton_add_stat_button2 = new ImageButton(this.leftPos + -48, this.topPos + 33, 11, 11, 0, 0, 11, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_add_stat_button2.png"), 11, 22, e -> {
		});
		guistate.put("button:imagebutton_add_stat_button2", imagebutton_add_stat_button2);
		this.addRenderableWidget(imagebutton_add_stat_button2);
		imagebutton_add_stat_button3 = new ImageButton(this.leftPos + -48, this.topPos + 43, 11, 11, 0, 0, 11, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_add_stat_button3.png"), 11, 22, e -> {
		});
		guistate.put("button:imagebutton_add_stat_button3", imagebutton_add_stat_button3);
		this.addRenderableWidget(imagebutton_add_stat_button3);
		imagebutton_add_stat_button4 = new ImageButton(this.leftPos + -48, this.topPos + 53, 11, 11, 0, 0, 11, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_add_stat_button4.png"), 11, 22, e -> {
		});
		guistate.put("button:imagebutton_add_stat_button4", imagebutton_add_stat_button4);
		this.addRenderableWidget(imagebutton_add_stat_button4);
	}
}
