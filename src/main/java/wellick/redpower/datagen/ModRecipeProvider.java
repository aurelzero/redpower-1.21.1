package wellick.redpower.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import wellick.redpower.Redpower;
import wellick.redpower.block.ModBlocks;
import wellick.redpower.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> COKE_SMELTABLES = List.of(Items.COAL, Items.CHARCOAL);
        offerBlasting(exporter, COKE_SMELTABLES, RecipeCategory.MISC, ModItems.COKE, 0.5f, 2000, "coke");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern(" I ")
                .pattern(" # ")
                .input('#', ModBlocks.STEEL_BLOCK)
                .input('I', Items.END_ROD)
                .criterion(hasItem(ModBlocks.STEEL_BLOCK), conditionsFromItem(ModBlocks.STEEL_BLOCK))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 9)
                .input(Blocks.OAK_DOOR)
                .criterion(hasItem(Items.OAK_DOOR), conditionsFromItem(Items.OAK_DOOR))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STICK, 32)
                .input(Blocks.SPRUCE_DOOR)
                .criterion(hasItem(Items.SPRUCE_DOOR), conditionsFromItem(Items.SPRUCE_DOOR))
                .offerTo(exporter, Identifier.of(Redpower.MOD_ID, "stick_from_spruce_door")); //because recipes are named after the result

    }
}
