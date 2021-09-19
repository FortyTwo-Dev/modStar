package fr.titi.infinity.event;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = INFINITY.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StarArmorEvent {

    @SubscribeEvent
    public void onPlayerArmorEquip(LivingEquipmentChangeEvent event) {
         if (event.getEntityLiving() instanceof PlayerEntity) {
             PlayerEntity player = (PlayerEntity) event.getEntityLiving();
             //star_helmet
             if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.STAR_HELMET.get())) {
                 player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 20*99999999, 0));
                 System.out.println("effecte helmet");
             } else if (event.getFrom().getItem() == ModItems.STAR_HELMET.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).isEmpty()) {
                 player.removeEffect(Effects.NIGHT_VISION);
                 System.out.println("no effecte helmet");
             }
             //star_leggings
             if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.STAR_LEGGINGS.get())) {
                 player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 20*99999999, 0));
                 System.out.println("effecte leggings");
             } else if (event.getFrom().getItem() == ModItems.STAR_LEGGINGS.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).isEmpty()) {
                 player.removeEffect(Effects.FIRE_RESISTANCE);
                 System.out.println("no effecte leggings");
             }
             //star_boots
             if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.STAR_BOOTS.get())) {
                 player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20*99999999, 4));
                 player.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 20*99999999, 4));
                 System.out.println("effecte boots");
             } else if (event.getFrom().getItem() == ModItems.STAR_BOOTS.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).isEmpty()) {
                 player.removeEffect(Effects.MOVEMENT_SPEED);
                 player.removeEffect(Effects.DOLPHINS_GRACE);
                 System.out.println("no effecte boots");
             }
             if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.STAR_HELMET.get())
                     && (event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.STAR_CHESTPLATE.get()
                     && (event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.STAR_LEGGINGS.get()
                     && (event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.STAR_BOOTS.get())))) {
                 player.abilities.invulnerable = true;
                 System.out.println("invulnerable");
             } else if (event.getFrom().getItem() == ModItems.STAR_HELMET.get()
                     && event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).isEmpty()
                     || event.getFrom().getItem() == ModItems.STAR_CHESTPLATE.get()
                     && event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).isEmpty()
                     || event.getFrom().getItem() == ModItems.STAR_LEGGINGS.get()
                     && event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).isEmpty()
                     || event.getFrom().getItem() == ModItems.STAR_BOOTS.get()
                     && event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).isEmpty()) {
                 player.abilities.invulnerable = false;
                 System.out.println("vulnerable");
             }
         }
     }
}
