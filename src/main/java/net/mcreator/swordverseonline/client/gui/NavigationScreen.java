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

import net.mcreator.swordverseonline.world.inventory.NavigationMenu;
import net.mcreator.swordverseonline.procedures.RenderSTGProcedure;
import net.mcreator.swordverseonline.procedures.RenderSPDProcedure;
import net.mcreator.swordverseonline.procedures.RenderPlayerNameProcedure;
import net.mcreator.swordverseonline.procedures.RenderPlayerInStatScreenProcedure;
import net.mcreator.swordverseonline.procedures.RenderMPProcedure;
import net.mcreator.swordverseonline.procedures.RenderLvProcedure;
import net.mcreator.swordverseonline.procedures.RenderHPProcedure;
import net.mcreator.swordverseonline.procedures.RenderEXPProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class NavigationScreen extends AbstractContainerScreen<NavigationMenu> {
	private final static HashMap<String, Object> guistate = NavigationMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_profile;
	ImageButton imagebutton_social;
	ImageButton imagebutton_message;
	ImageButton imagebutton_navigation;
	ImageButton imagebutton_settings;
	ImageButton imagebutton_dungeon_map_button;
	ImageButton imagebutton_map_button;
	ImageButton imagebutton_quest_button;

	public NavigationScreen(NavigationMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("swordverse_online:textures/screens/navigation.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		if (RenderPlayerInStatScreenProcedure.execute(world, x, y, z, entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(ms, this.leftPos + -102, this.topPos + -8, 40, 0f + (float) Math.atan((this.leftPos + -102 - mouseX) / 40.0), (float) Math.atan((this.topPos + -57 - mouseY) / 40.0), livingEntity);
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
		this.blit(ms, this.leftPos + -161, this.topPos + -108, 0, 0, 135, 200, 135, 200);

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
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_stg"), -159, 46, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_spd"), -159, 56, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_mp"), -159, 66, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_hp"), -159, 76, -12829636);
		this.font.draw(poseStack,

				RenderPlayerNameProcedure.execute(world, x, y, z, entity), -140, -103, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_lv"), -159, 27, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_exp"), -159, 36, -12829636);
		this.font.draw(poseStack,

				RenderHPProcedure.execute(entity), -71, 76, -12829636);
		this.font.draw(poseStack,

				RenderMPProcedure.execute(entity), -71, 66, -12829636);
		this.font.draw(poseStack,

				RenderSTGProcedure.execute(entity), -71, 46, -12829636);
		this.font.draw(poseStack,

				RenderSPDProcedure.execute(entity), -71, 56, -12829636);
		this.font.draw(poseStack,

				RenderEXPProcedure.execute(entity), -71, 36, -12829636);
		this.font.draw(poseStack,

				RenderLvProcedure.execute(entity), -71, 26, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_map"), 15, -6, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_dungeon_map"), 15, 12, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.navigation.label_quests"), 15, 30, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_profile = new ImageButton(this.leftPos + -26, this.topPos + -66, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_profile.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_profile", imagebutton_profile);
		this.addRenderableWidget(imagebutton_profile);
		imagebutton_social = new ImageButton(this.leftPos + -26, this.topPos + -42, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_social.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_social", imagebutton_social);
		this.addRenderableWidget(imagebutton_social);
		imagebutton_message = new ImageButton(this.leftPos + -26, this.topPos + -18, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_message.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_message", imagebutton_message);
		this.addRenderableWidget(imagebutton_message);
		imagebutton_navigation = new ImageButton(this.leftPos + -26, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_navigation.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_navigation", imagebutton_navigation);
		this.addRenderableWidget(imagebutton_navigation);
		imagebutton_settings = new ImageButton(this.leftPos + -26, this.topPos + 30, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_settings.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_settings", imagebutton_settings);
		this.addRenderableWidget(imagebutton_settings);
		imagebutton_dungeon_map_button = new ImageButton(this.leftPos + -2, this.topPos + 7, 82, 18, 0, 0, 18, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_dungeon_map_button.png"), 82, 36, e -> {
		});
		guistate.put("button:imagebutton_dungeon_map_button", imagebutton_dungeon_map_button);
		this.addRenderableWidget(imagebutton_dungeon_map_button);
		imagebutton_map_button = new ImageButton(this.leftPos + -2, this.topPos + -11, 82, 18, 0, 0, 18, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_map_button.png"), 82, 36, e -> {
		});
		guistate.put("button:imagebutton_map_button", imagebutton_map_button);
		this.addRenderableWidget(imagebutton_map_button);
		imagebutton_quest_button = new ImageButton(this.leftPos + -2, this.topPos + 25, 82, 18, 0, 0, 18, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_quest_button.png"), 82, 36, e -> {
		});
		guistate.put("button:imagebutton_quest_button", imagebutton_quest_button);
		this.addRenderableWidget(imagebutton_quest_button);
	}
}
