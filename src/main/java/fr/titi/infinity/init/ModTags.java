package fr.titi.infinity.init;

import fr.titi.infinity.INFINITY;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags {

    private static void init(){
        Items.init();
        Blocks.init();
    }

    public static class Blocks {
        private static void init(){}

        public static final Tags.IOptionalNamedTag<Block> STAR_BLOCK =
                createTag("star_block");

        public static final Tags.IOptionalNamedTag<Block> STAR_ORE =
                createForgeTag("ore/star_ore");

        private static Tags.IOptionalNamedTag<Block> createTag(String name) {
            return BlockTags.createOptional(new ResourceLocation(INFINITY.MODID, name));
        }

        private static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        private static void init(){}

        public static final Tags.IOptionalNamedTag<Item> STAR =
                createForgeTag("gem/star");
        public static final Tags.IOptionalNamedTag<Item> STAR_EQUIPMENT =
                createTag("star_tools");
        public static final Tags.IOptionalNamedTag<Item> STAR_ARMOR =
                createTag("star_armor");

        private static Tags.IOptionalNamedTag<Item> createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(INFINITY.MODID, name));
        }

        private static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }

}
