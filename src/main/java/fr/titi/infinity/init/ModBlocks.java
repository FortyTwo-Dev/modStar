package fr.titi.infinity.init;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.utils.InfinityTab;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, INFINITY.MODID);

    public static final RegistryObject<Block> STAR_BLOCK = createBlock("star_block", () ->
            new Block(AbstractBlock.Properties.of(Material.METAL).strength( 6f, 30f).harvestTool(ToolType.PICKAXE).harvestLevel(10)));

    public static final RegistryObject<Block> STAR_ORE = createBlock( "star_ore", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE).strength( 6f, 20f).harvestTool(ToolType.PICKAXE).harvestLevel(10)));

    public static final RegistryObject<Block> STAR_POWDER_BLOCK = createBlock("star_powder_block", () ->
            new Block(AbstractBlock.Properties.of(Material.METAL).noCollission().air().instabreak()));

    public static final RegistryObject<Block> UNBREAKING_STAR = createBlock("unbreaking_star", () ->
            new Block(AbstractBlock.Properties.of(Material.METAL).strength(-1f,-1f)));

    public static final RegistryObject<Block> METEORITE_STONE = createBlock("meteorite_stone", ()->
            new Block(AbstractBlock.Properties.of(Material.METAL).strength(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(8)));

    public static final RegistryObject<Block> METEORITE_HARDENED_STONE = createBlock("meteorite_hardened_stone", ()->
            new Block(AbstractBlock.Properties.of(Material.METAL).strength(10f, 25f).harvestTool(ToolType.PICKAXE).harvestLevel(10)));




    public static RegistryObject<Block> createBlock(String name, Supplier <? extends Block> supplier)
    {
        RegistryObject<Block> Block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(Block.get(), new Item.Properties().tab(InfinityTab.TAB).fireResistant()));
        return Block;
    }


}
