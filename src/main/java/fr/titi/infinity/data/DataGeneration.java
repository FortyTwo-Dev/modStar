package fr.titi.infinity.data;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.data.Lang.LangGenerator;
import fr.titi.infinity.data.recipe.RecipeGenerator;
import fr.titi.infinity.init.ModBlocks;
import fr.titi.infinity.init.ModItems;
import fr.titi.infinity.init.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = INFINITY.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent e) {

        DataGenerator generator = e.getGenerator();

        if (e.includeServer()) {
            generator.addProvider(new RecipeGenerator(generator));
            BlockTagGenerator blockTagGenerator = new BlockTagGenerator(generator, INFINITY.MODID, e.getExistingFileHelper());
            generator.addProvider(blockTagGenerator);
            generator.addProvider(new ItemTagGenerator(generator, blockTagGenerator, INFINITY.MODID, e.getExistingFileHelper()));
        }
        if (e.includeClient()) {
            generator.addProvider(new LangGenerator(generator));
        }
    }

    private static class ItemTagGenerator extends ItemTagsProvider {

        public ItemTagGenerator(DataGenerator generator, BlockTagsProvider blockTagsProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
            super(generator, blockTagsProvider, modId, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(ModTags.Items.STAR).add(ModItems.STAR.get());
            tag(ModTags.Items.STAR_EQUIPMENT).add(ModItems.STAR_AXE.get(), ModItems.STAR_PICKAXE.get(), ModItems.STAR_SWORD.get(), ModItems.STAR_SHOVEL.get());
            tag(ModTags.Items.STAR_ARMOR).add(ModItems.STAR_HELMET.get(), ModItems.STAR_CHESTPLATE.get(), ModItems.STAR_LEGGINGS.get(), ModItems.STAR_BOOTS.get());
            super.addTags();
        }
    }

    private static class BlockTagGenerator extends BlockTagsProvider {

        public BlockTagGenerator(DataGenerator generator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
            super(generator, modId, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(ModTags.Blocks.STAR_BLOCK).add(ModBlocks.UNBREAKING_STAR.get(), ModBlocks.STAR_BLOCK.get(), ModBlocks.STAR_POWDER_BLOCK.get());
            tag(ModTags.Blocks.STAR_ORE).add(ModBlocks.STAR_ORE.get());
            super.addTags();
        }
    }

}
