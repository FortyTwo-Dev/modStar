package fr.titi.infinity.data.Lang;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.init.ModBlocks;
import fr.titi.infinity.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(DataGenerator generator, String modid, String locale) {
        super(generator, modid, locale);
    }

    public LangGenerator(DataGenerator generator) {
        super(generator, INFINITY.MODID, "en_us");
    }


    private void block(PrefixHelper helper) {

        helper.add(ModBlocks.STAR_BLOCK.get(), "Star Block");
        helper.add(ModBlocks.STAR_ORE.get(), "Star Ore");
        helper.add(ModBlocks.STAR_POWDER_BLOCK.get(), "Star Powder Block");
        helper.add(ModBlocks.UNBREAKING_STAR.get(), "Unbreaking Star");

    }

    private void Item(PrefixHelper helper) {

        helper.add(ModItems.STAR.get(), "Star");
        helper.add(ModItems.STAR_HELMET.get(), "Star Helmet");
        helper.add(ModItems.STAR_CHESTPLATE.get(), "Star Chestplate");
        helper.add(ModItems.STAR_LEGGINGS.get(), "Star Leggings");
        helper.add(ModItems.STAR_BOOTS.get(), "Star Boots");
        helper.add(ModItems.STAR_SWORD.get(), "Star Sword");
        helper.add(ModItems.STAR_BLADE.get(), "Star Blade");
        helper.add(ModItems.STAR_HANDLE_SWORD.get(), "Star Handle Sword");
        helper.add(ModItems.STAR_AXE.get(), "Star Axe");
        helper.add(ModItems.STAR_HEAD_AXE.get(), "Star Head Axe");
        helper.add(ModItems.STAR_PICKAXE.get(), "Star Pickaxe");
        helper.add(ModItems.STAR_HEAD_PICKAXE.get(), "Star Head Pickaxe");
        helper.add(ModItems.STAR_SHOVEL.get(), "Star Shovel");
        helper.add(ModItems.STAR_HEAD_SHOVEL.get(), "Star Head Shovel");
        helper.add(ModItems.STAR_TOOLS_HANDLE.get(), "Star Tools Handle");
        helper.add(ModItems.STAR_OF_PUISSANCE.get(), "Flying Star");
        helper.add(ModItems.STAR_APPLE.get(), "Star Apple");

    }
    private void Categories(PrefixHelper helper) {
        //categories key
        add("key.categories.infinity", "Infinity Categories");

        //tab(ItemGroup)
        add("itemGroup.infinitytab", "InfinityTab");
    }

    private void toolTips(PrefixHelper helper) {
        helper.setPrefix("tooltip");

        helper.add("star_of_puissance.description", "Right Click To Fly");
        helper.add("star_of_puissance.hold_shift","Hold \u00A7eShift \u00A77for More Information");
    }

    private void Key(PrefixHelper helper) {
        helper.setPrefix("key.infinity");

        helper.add("fly_key", "Fly Key Test");
    }

    private void Entities(PrefixHelper helper) {
        helper.setPrefix("entity.infinity");

        helper.add("meteorite_entity","Meteorite");
    }


    @Override
    public void addBlock(Supplier<? extends Block> key, String name) {
        super.addBlock(key, name);
    }

    @Override
    protected void addTranslations() {
        PrefixHelper helper = new PrefixHelper(this);

        block(helper);
        Item(helper);
        Categories(helper);
        toolTips(helper);
        Key(helper);
        Entities(helper);

    }


    @Override
    public void add(Block key, String name) {
        if (key != null) super.add(key, name);
    }
    
    @Override
    public void add(Item key, String name) {
        if (key != null) super.add(key, name);
    }

    public static class PrefixHelper {
        private LangGenerator generator;
        private String prefix;

        public PrefixHelper(LangGenerator generator){
            this.generator = generator;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix + ".";
        }

        public void add(String translationKey, String translation) {
            generator.add(prefix + translationKey, translation);
        }

        public void add(Block key, String name) {
            if (key != null) generator.add(key, name);
        }

        public void add(Item key, String name) {
            if (key != null) generator.add(key, name);
        }

    }

}
