package wellick.redpower.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import wellick.redpower.block.ModBlocks;
import wellick.redpower.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool steelPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        steelPool.stairs(ModBlocks.STEEL_STAIRS);
        steelPool.slab(ModBlocks.STEEL_SLAB);
        steelPool.button(ModBlocks.STEEL_BUTTON);
        steelPool.pressurePlate(ModBlocks.STEEL_PRESSURE_PLATE);
        steelPool.fence(ModBlocks.STEEL_FENCE);
        steelPool.fenceGate(ModBlocks.STEEL_FENCE_GATE);
        steelPool.wall(ModBlocks.STEEL_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.STEEL_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.STEEL_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
    }
}
