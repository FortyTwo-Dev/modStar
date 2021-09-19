package fr.titi.infinity.data.recipe;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.init.ModBlocks;
import fr.titi.infinity.init.ModItems;
import fr.titi.infinity.init.ModTags;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.lang.reflect.InvocationHandler;
import java.util.function.Consumer;


public class RecipeGenerator extends RecipeProvider{

    public RecipeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        //STAR
        ShapelessRecipeBuilder.shapeless(ModItems.STAR.get(),9)
                .requires(ModBlocks.STAR_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get()))
                .save(consumer);
        //STAR_BLOCK
        ShapedRecipeBuilder.shaped(ModBlocks.STAR_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModTags.Items.STAR)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR.get()))
                .save(consumer);
        //STAR_APPLE
        ShapedRecipeBuilder.shaped(ModItems.STAR_APPLE.get())
                .pattern("BNB")
                .pattern("NGN")
                .pattern("BNB")
                .define('B', ModBlocks.STAR_BLOCK.get())
                .define('N', Items.NETHER_STAR)
                .define('G', Items.GOLDEN_APPLE)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get(),Items.NETHER_STAR,Items.GOLDEN_APPLE))
                .save(consumer);
        //STAR_SWORD
        ShapedRecipeBuilder.shaped(ModItems.STAR_SWORD.get())
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" H ")
                .define('B',ModItems.STAR_BLADE.get())
                .define('S',ModBlocks.STAR_BLOCK.get())
                .define('H',ModItems.STAR_HANDLE_SWORD.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR_BLADE.get(),ModBlocks.STAR_BLOCK.get(),ModItems.STAR_HANDLE_SWORD.get()))
                .save(consumer);
        //STAR_BLADE
        ShapedRecipeBuilder.shaped(ModItems.STAR_BLADE.get())
                .pattern(" S ")
                .pattern("SNS")
                .pattern("SBS")
                .define('S',ModTags.Items.STAR)
                .define('N',Blocks.NETHERITE_BLOCK)
                .define('B',ModBlocks.STAR_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR.get(),Blocks.NETHERITE_BLOCK,ModBlocks.STAR_BLOCK.get()))
                .save(consumer);
        //STAR_HANDLE_SWORD
        ShapedRecipeBuilder.shaped(ModItems.STAR_HANDLE_SWORD.get())
                .pattern("   ")
                .pattern("SBS")
                .pattern(" T ")
                .define('S',ModTags.Items.STAR)
                .define('B',ModBlocks.STAR_BLOCK.get())
                .define('T',ModItems.STAR_TOOLS_HANDLE.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR.get(),ModBlocks.STAR_BLOCK.get(),ModItems.STAR_TOOLS_HANDLE.get()))
                .save(consumer);
        //STAR_HEAD_PICKAXE
        ShapedRecipeBuilder.shaped(ModItems.STAR_HEAD_PICKAXE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern("BSB")
                .define('B',ModBlocks.STAR_BLOCK.get())
                .define('S',ModTags.Items.STAR)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get(),ModItems.STAR.get()))
                .save(consumer);
        //STAR_PICKAXE
        SmithingRecipeBuilder.smithing(Ingredient.of(ModItems.STAR_TOOLS_HANDLE.get()), Ingredient.of(ModItems.STAR_HEAD_PICKAXE.get()), ModItems.STAR_PICKAXE.get())
                .unlocks("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR_TOOLS_HANDLE.get()))
                .save(consumer, new ResourceLocation(INFINITY.MODID, "star_pickaxe"));
        //STAR_HEAD_AXE
        ShapedRecipeBuilder.shaped(ModItems.STAR_HEAD_AXE.get())
                .pattern("BS ")
                .pattern("S  ")
                .pattern("   ")
                .define('B',ModBlocks.STAR_BLOCK.get())
                .define('S',ModTags.Items.STAR)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get(),ModItems.STAR.get()))
                .save(consumer);
        //STAR_AXE
        SmithingRecipeBuilder.smithing(Ingredient.of(ModItems.STAR_TOOLS_HANDLE.get()), Ingredient.of(ModItems.STAR_HEAD_AXE.get()), ModItems.STAR_AXE.get())
                .unlocks("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR_TOOLS_HANDLE.get()))
                .save(consumer, new ResourceLocation(INFINITY.MODID, "star_axe"));
        //STAR_HEAD_SHOVEL
        ShapedRecipeBuilder.shaped(ModItems.STAR_HEAD_SHOVEL.get())
                .pattern("SBS")
                .pattern(" S ")
                .pattern("   ")
                .define('B',ModBlocks.STAR_BLOCK.get())
                .define('S',ModTags.Items.STAR)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get(),ModItems.STAR.get()))
                .save(consumer);
        //STAR_SHOVEL
        SmithingRecipeBuilder.smithing(Ingredient.of(ModItems.STAR_TOOLS_HANDLE.get()), Ingredient.of(ModItems.STAR_HEAD_SHOVEL.get()), ModItems.STAR_SHOVEL.get())
                .unlocks("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR_TOOLS_HANDLE.get()))
                .save(consumer, new ResourceLocation(INFINITY.MODID, "star_shovel"));
        //STAR_TOOLS_HANDLE
        ShapedRecipeBuilder.shaped(ModItems.STAR_TOOLS_HANDLE.get())
                .pattern("STS")
                .pattern("BTB")
                .pattern("STS")
                .define('B',ModBlocks.STAR_BLOCK.get())
                .define('S',ModTags.Items.STAR)
                .define('T',Items.STICK)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get(),ModItems.STAR.get(),Items.STICK))
                .save(consumer);
        //STAR_HELMET
        ShapedRecipeBuilder.shaped(ModItems.STAR_HELMET.get())
                .pattern(" T ")
                .pattern("BNB")
                .pattern("S S")
                .define('S',ModTags.Items.STAR)
                .define('T',Items.NETHER_STAR)
                .define('N',Blocks.NETHERITE_BLOCK)
                .define('B',ModBlocks.STAR_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModItems.STAR.get(),Items.NETHER_STAR,ModBlocks.STAR_BLOCK.get(),Blocks.NETHERITE_BLOCK))
                .save(consumer);
        //STAR_CHESTPLATE
        ShapedRecipeBuilder.shaped(ModItems.STAR_CHESTPLATE.get())
                .pattern("B B")
                .pattern("NSN")
                .pattern("BBB")
                .define('B',ModBlocks.STAR_BLOCK.get())
                .define('N',Blocks.NETHERITE_BLOCK)
                .define('S',Items.NETHER_STAR)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get(),Blocks.NETHERITE_BLOCK,Items.NETHER_STAR))
                .save(consumer);
        //STAR_LEGGINGS
        ShapedRecipeBuilder.shaped(ModItems.STAR_LEGGINGS.get())
                .pattern("BNB")
                .pattern("N N")
                .pattern("S S")
                .define('B',ModBlocks.STAR_BLOCK.get())
                .define('N',Blocks.NETHERITE_BLOCK)
                .define('S',Items.NETHER_STAR)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_BLOCK.get(),Blocks.NETHERITE_BLOCK,Items.NETHER_STAR))
                .save(consumer);
        //STAR_BOOTS
        ShapedRecipeBuilder.shaped(ModItems.STAR_BOOTS.get())
                .pattern("   ")
                .pattern("B B")
                .pattern("N N")
                .define('N',Blocks.NETHERITE_BLOCK)
                .define('B',ModBlocks.STAR_BLOCK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(Blocks.NETHERITE_BLOCK,ModBlocks.STAR_BLOCK.get()))
                .save(consumer);
        //STAR_ORE_FURNACE
        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.STAR_ORE.get()), ModItems.STAR.get(), 10.0F, 1500)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_ORE.get()))
                .save(consumer, new ResourceLocation(INFINITY.MODID, "star_ore_furnace"));
        //STAR_ORE_BLASTING
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.STAR_ORE.get()), ModItems.STAR.get(), 10.0F, 750)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ModBlocks.STAR_ORE.get()))
                .save(consumer, new ResourceLocation(INFINITY.MODID, "star_ore_blasting"));
    }
}
