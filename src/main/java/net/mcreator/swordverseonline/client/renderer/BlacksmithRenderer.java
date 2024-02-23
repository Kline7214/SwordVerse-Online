
package net.mcreator.swordverseonline.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.swordverseonline.entity.BlacksmithEntity;
import net.mcreator.swordverseonline.client.model.ModelBlacksmith;

public class BlacksmithRenderer extends MobRenderer<BlacksmithEntity, ModelBlacksmith<BlacksmithEntity>> {
	public BlacksmithRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBlacksmith(context.bakeLayer(ModelBlacksmith.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlacksmithEntity entity) {
		return new ResourceLocation("swordverse_online:textures/entities/blacksmith_texture.png");
	}
}
