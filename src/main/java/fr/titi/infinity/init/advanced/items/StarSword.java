package fr.titi.infinity.init.advanced.items;

import fr.titi.infinity.utils.CustomItemTiers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class StarSword extends SwordItem {

    public StarSword(CustomItemTiers star, int i, float v, Properties properties) {
        super(CustomItemTiers.STAR, 999999980 , 1f, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity living, LivingEntity livingEntity) {
        livingEntity.addEffect(new EffectInstance(Effects.HEAL, 1*20, 2, false, false, false));
        return super.hurtEnemy(stack, living, livingEntity);

    }



}
