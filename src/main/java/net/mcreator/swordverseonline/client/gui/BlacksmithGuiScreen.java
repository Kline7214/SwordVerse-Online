package net.mcreator.swordverseonline.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;

import net.mcreator.swordverseonline.world.inventory.BlacksmithGuiMenu;
import net.mcreator.swordverseonline.network.BlacksmithGuiButtonMessage;
import net.mcreator.swordverseonline.SwordverseOnlineMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BlacksmithGuiScreen extends AbstractContainerScreen<BlacksmithGuiMenu> {
	private final static HashMap<String, Object> guistate = BlacksmithGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_gui_button;
	ImageButton imagebutton_gui_button1;
	ImageButton imagebutton_gui_button2;

	public BlacksmithGuiScreen(BlacksmithGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	private static final ResourceLocation texture = new ResourceLocation("swordverse_online:textures/screens/blacksmith_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("swordverse_online:textures/screens/gui_blank.png"));
		this.blit(ms, this.leftPos + -128, this.topPos + -71, 0, 0, 264, 150, 264, 150);

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
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.blacksmith_gui.label_weapon_crafting"), -23, -29, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.blacksmith_gui.label_blacksmith"), -26, -64, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.blacksmith_gui.label_appraisal"), -24, -3, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.swordverse_online.blacksmith_gui.label_upgrade"), -19, 24, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_gui_button = new ImageButton(this.leftPos + -42, this.topPos + -32, 82, 16, 0, 0, 16, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_gui_button.png"), 82, 32, e -> {
			if (true) {
				SwordverseOnlineMod.PACKET_HANDLER.sendToServer(new BlacksmithGuiButtonMessage(0, x, y, z));
				BlacksmithGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_gui_button", imagebutton_gui_button);
		this.addRenderableWidget(imagebutton_gui_button);
		imagebutton_gui_button1 = new ImageButton(this.leftPos + -42, this.topPos + -6, 82, 16, 0, 0, 16, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_gui_button1.png"), 82, 32, e -> {
			if (true) {
				SwordverseOnlineMod.PACKET_HANDLER.sendToServer(new BlacksmithGuiButtonMessage(1, x, y, z));
				BlacksmithGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_gui_button1", imagebutton_gui_button1);
		this.addRenderableWidget(imagebutton_gui_button1);
		imagebutton_gui_button2 = new ImageButton(this.leftPos + -42, this.topPos + 21, 82, 16, 0, 0, 16, new ResourceLocation("swordverse_online:textures/screens/atlas/imagebutton_gui_button2.png"), 82, 32, e -> {
			if (true) {
				SwordverseOnlineMod.PACKET_HANDLER.sendToServer(new BlacksmithGuiButtonMessage(2, x, y, z));
				BlacksmithGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_gui_button2", imagebutton_gui_button2);
		this.addRenderableWidget(imagebutton_gui_button2);
	}
}
