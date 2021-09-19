package fr.titi.infinity.entity.model;
// Made with Blockbench 3.9.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.titi.infinity.entity.MeteoriteEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MeteoriteEntityModel<T extends MeteoriteEntity> extends EntityModel<T> {
    private final ModelRenderer bb_main;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;

    public MeteoriteEntityModel() {
        texWidth = 16;
        texHeight = 16;

        bb_main = new ModelRenderer(this);
        bb_main.setPos(0.0F, 24.0F, 0.0F);
        bb_main.texOffs(0, 0).addBox(-7.0F, -1.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
        bb_main.texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
        bb_main.texOffs(0, 0).addBox(-7.0F, -20.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
        bb_main.texOffs(0, 0).addBox(-8.0F, -19.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, -10.0F, 9.0F);
        bb_main.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 1.5708F, 1.5708F);
        cube_r1.texOffs(0, 0).addBox(2.0F, 9.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
        cube_r1.texOffs(0, 0).addBox(1.0F, 8.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
        cube_r1.texOffs(0, 0).addBox(2.0F, -10.0F, -7.0F, 14.0F, 1.0F, 14.0F, 0.0F, false);
        cube_r1.texOffs(0, 0).addBox(1.0F, -9.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(0.0F, -0.5F, 0.0F);
        bb_main.addChild(cube_r2);
        setRotationAngle(cube_r2, -1.5708F, 0.0F, 0.0F);
        cube_r2.texOffs(0, 0).addBox(-7.0F, -10.0F, -16.5F, 14.0F, 1.0F, 14.0F, 0.0F, false);
        cube_r2.texOffs(0, 0).addBox(-7.0F, 9.0F, -16.5F, 14.0F, 1.0F, 14.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(cube_r3);
        setRotationAngle(cube_r3, -1.5708F, 0.0F, 0.0F);
        cube_r3.texOffs(0, 0).addBox(-8.0F, -9.0F, -18.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
        cube_r3.texOffs(0, 0).addBox(-8.0F, 8.0F, -18.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(MeteoriteEntity p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}