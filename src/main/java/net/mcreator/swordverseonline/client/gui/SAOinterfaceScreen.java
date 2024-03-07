package net.mcreator.swordverseonline.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;

import net.mcreator.swordverseonline.world.inventory.SAOinterfaceMenu;
import net.mcreator.swordverseonline.network.SAOinterfaceButtonMessage;
import net.mcreator.swordverseonline.SwordverseOnlineMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class SAOinterfaceScreen extends AbstractContainerScreen<SAOinterfaceMenu> {
	private final static HashMap<String, Object> guistate = SAOinterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_profile;
	ImageButton imagebutton_social;
	ImageButton imagebutton_message;
	ImageButton imagebutton_navigation;
	ImageButton imagebutton_settings;

	public SAOinterfaceScreen(SAOinterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("swordverse_online:textures/screens/sa_ointerface.png");

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
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_profile = new ImageButton(this.leftPos + -10, this.topPos + -53, 20, 20, 0, 0, 20, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_profile.png"), 20, 40, e -> {
			if (true) {
				SwordverseOnlineMod.PACKET_HANDLER.sendToServer(new SAOinterfaceButtonMessage(0, x, y, z));
				SAOinterfaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
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
	}
}
