package wellick.redpower.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import wellick.redpower.Redpower;
import wellick.redpower.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup REDPOWER_INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Redpower.MOD_ID, "redpower_ingredients"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.COKE))
                    .displayName(Text.translatable("itemgroup.redpower.redpower_ingredients"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModItems.COKE);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.STEEL_DOOR);
                        entries.add(ModBlocks.STEEL_TRAPDOOR);
                        entries.add(ModBlocks.STEEL_FENCE);
                        entries.add(ModBlocks.STEEL_BUTTON);
                        entries.add(ModBlocks.STEEL_PRESSURE_PLATE);
                        entries.add(ModBlocks.STEEL_STAIRS);
                        entries.add(ModBlocks.STEEL_SLAB);
                        entries.add(ModBlocks.STEEL_FENCE_GATE);
                        entries.add(ModBlocks.STEEL_WALL);
                    })
                    .build());

    public static void registerItemGroups(){
        Redpower.LOGGER.info("Registering Item Groups for "+Redpower.MOD_ID);
    }
}
