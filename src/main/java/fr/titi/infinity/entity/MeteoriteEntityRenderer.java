package fr.titi.infinity.entity;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.entity.model.MeteoriteEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class MeteoriteEntityRenderer extends MobRenderer<MeteoriteEntity, MeteoriteEntityModel<MeteoriteEntity>> {

    public static final ResourceLocation METEORITE_TEXTURE = new ResourceLocation(INFINITY.MODID, "textures/entity/meteorite.png");

    public MeteoriteEntityRenderer(EntityRendererManager manager) {
        super(manager, new MeteoriteEntityModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(MeteoriteEntity p_110775_1_) {
        return METEORITE_TEXTURE;
    }
}
