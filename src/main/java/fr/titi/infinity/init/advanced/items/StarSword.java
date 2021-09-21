package fr.titi.infinity.init.advanced.items;

import fr.titi.infinity.utils.CustomItemTiers;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class StarSword extends SwordItem {

    public StarSword(CustomItemTiers star, int i, float v, Properties properties) {
        super(CustomItemTiers.STAR, 999999980 , 1f, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity living, LivingEntity livingEntity) {
        livingEntity.addEffect(new EffectInstance(Effects.HEAL, 1*20, 2, false, false, false));
        return super.hurtEnemy(stack, living, livingEntity);

    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> textComponents, ITooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()) {
            textComponents.add(new TranslationTextComponent("tooltip.star_sword.description"));


        } else {
            textComponents.add(new TranslationTextComponent("tooltip.star_sword.hold_shift"));

        }

        super.appendHoverText(stack, world, textComponents, tooltipFlag);
    }

}
