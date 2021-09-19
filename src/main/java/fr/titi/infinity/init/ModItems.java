package fr.titi.infinity.init;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.init.advanced.armor.FlyArmor;
import fr.titi.infinity.init.advanced.items.SpecialItem;
import fr.titi.infinity.init.advanced.items.StarSword;
import fr.titi.infinity.utils.CustomItemTiers;
import fr.titi.infinity.utils.InfinityTab;
import fr.titi.infinity.utils.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, INFINITY.MODID);

    public static final RegistryObject<SpecialItem> STAR_OF_PUISSANCE = ITEMS.register("star_of_puissance", () ->
            new SpecialItem(new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).rarity(Rarity.create("star_of_puissance", TextFormatting.GOLD))));



    public static final RegistryObject<Item> STAR = ITEMS.register("star", () ->
            new Item(new Item.Properties().stacksTo(16).tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star", TextFormatting.LIGHT_PURPLE))));

    public static final RegistryObject<Item> STAR_SWORD = ITEMS.register("star_sword", () ->
            new StarSword(CustomItemTiers.STAR, 982, 1f,
                    new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant().rarity(Rarity.EPIC).rarity(Rarity.create("star_sword", TextFormatting.GOLD ))));

    public static final RegistryObject<Item> STAR_PICKAXE = ITEMS.register("star_pickaxe", () ->
            new PickaxeItem(CustomItemTiers.STAR, 0, 1f,
                    new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star_pickaxe", TextFormatting.GOLD))));

    public static final RegistryObject<Item> STAR_AXE = ITEMS.register( "star_axe", () ->
            new AxeItem(CustomItemTiers.STAR, 5,0.5f,
                    new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star_axe", TextFormatting.GOLD))));

    public static final RegistryObject<Item> STAR_SHOVEL = ITEMS.register( "star_shovel", () ->
            new ShovelItem(CustomItemTiers.STAR, 0, 1f,
                    new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star_shovel", TextFormatting.GOLD))));


    //manche/handler de l'épée
    public static final RegistryObject<Item> STAR_HANDLE_SWORD = ITEMS.register( "star_handle_sword", () ->
            new Item(new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant()));

    //lame blade de l'épée
    public static final RegistryObject<Item> STAR_BLADE = ITEMS.register( "star_blade", () ->
            new Item(new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant()));

    //hantler tools tout les outils
    public static final RegistryObject<Item> STAR_TOOLS_HANDLE = ITEMS.register( "star_tools_handle", () ->
            new Item(new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant()));

    //head pickaxe
    public static final RegistryObject<Item> STAR_HEAD_PICKAXE = ITEMS.register( "star_head_pickaxe", () ->
            new Item(new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant()));

    //head axe
    public static final RegistryObject<Item> STAR_HEAD_AXE = ITEMS.register( "star_head_axe", () ->
            new Item(new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant()));

    //head shovel
    public static final RegistryObject<Item> STAR_HEAD_SHOVEL = ITEMS.register( "star_head_shovel", () ->
            new Item(new Item.Properties().stacksTo(1).tab(InfinityTab.TAB).fireResistant()));

    public static final RegistryObject<ArmorItem> STAR_HELMET = ITEMS.register( "star_helmet", () ->
            new ArmorItem(ModArmorMaterial.STAR, EquipmentSlotType.HEAD, new Item.Properties().tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star_helmet", TextFormatting.GOLD ))));

    public static final RegistryObject<ArmorItem> STAR_CHESTPLATE = ITEMS.register( "star_chestplate", () ->
            new FlyArmor(ModArmorMaterial.STAR, EquipmentSlotType.CHEST, new Item.Properties().tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star_chestplate", TextFormatting.GOLD ))));

    public static final RegistryObject<ArmorItem> STAR_LEGGINGS = ITEMS.register( "star_leggings", () ->
            new ArmorItem(ModArmorMaterial.STAR, EquipmentSlotType.LEGS, new Item.Properties().tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star_leggings", TextFormatting.GOLD ))));

    public static final RegistryObject<ArmorItem> STAR_BOOTS = ITEMS.register( "star_boots", () ->
            new ArmorItem(ModArmorMaterial.STAR, EquipmentSlotType.FEET, new Item.Properties().tab(InfinityTab.TAB).fireResistant().rarity(Rarity.create("star_boots", TextFormatting.GOLD ))));

    public static final RegistryObject<Item> STAR_APPLE = ITEMS.register( "star_apple", () ->
            new Item(new Item.Properties().tab(InfinityTab.TAB).rarity(Rarity.UNCOMMON)
                    .food(new Food.Builder().nutrition(15).saturationMod(20F).alwaysEat()
                            .effect(()-> new EffectInstance(Effects.DAMAGE_RESISTANCE, 20*300, 11), 1.0f)
                            .effect(()-> new EffectInstance(Effects.ABSORPTION, 20*420, 14), 1.0f)
                            .effect(()-> new EffectInstance(Effects.MOVEMENT_SPEED, 20*400, 9), 1.0f)
                            .effect(()-> new EffectInstance(Effects.DIG_SPEED, 20*540, 20), 1.0f)
                            .effect(()-> new EffectInstance(Effects.HEAL, 20*2, 100), 1.0f)
                            .effect(()-> new EffectInstance(Effects.NIGHT_VISION, 20*680, 1), 1.0f)
                            .effect(()-> new EffectInstance(Effects.HEALTH_BOOST, 20*420, 20), 1.0f)
                            .effect(()-> new EffectInstance(Effects.DAMAGE_BOOST, 20*420, 14), 1.0f)
                            .effect(()-> new EffectInstance(Effects.LUCK, 20*420, 14), 0.01f)
                            .effect(()-> new EffectInstance(Effects.GLOWING, 20*1520, 100), 1.0f)
                            .fast()
                            .build())));



}
