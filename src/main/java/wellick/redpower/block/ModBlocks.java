package wellick.redpower.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import wellick.redpower.Redpower;
import wellick.redpower.block.custom.MagicBlock;

public class ModBlocks {

    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(AbstractBlock.Settings.create().strength(6f,1200f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));



    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Redpower.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Redpower.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static final Block STEEL_STAIRS = registerBlock("steel_stairs",
            new StairsBlock(ModBlocks.STEEL_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool()));

    public static final Block STEEL_SLAB = registerBlock("steel_slab",
                new SlabBlock(AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool()));

    public static final Block STEEL_BUTTON = registerBlock("steel_button",
            new ButtonBlock(BlockSetType.IRON, 200,
                    AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool().noCollision()));

    public static final Block STEEL_PRESSURE_PLATE = registerBlock("steel_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool().noCollision()));
    public static final Block STEEL_FENCE = registerBlock("steel_fence",
                new FenceBlock(AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool()));
    public static final Block STEEL_FENCE_GATE = registerBlock("steel_fence_gate",
                new FenceGateBlock(WoodType.ACACIA,
                        AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool()));
    public static final Block STEEL_WALL = registerBlock("steel_wall",
                new WallBlock(AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool()));

    public static final Block STEEL_DOOR = registerBlock("steel_door",
            new DoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool().nonOpaque()));
public static final Block STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(6f, 1200f).requiresTool().nonOpaque()));


    public static void registerModBlocks(){
        Redpower.LOGGER.info("Registering Mod Blocks for " + Redpower.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.STEEL_BLOCK);
            entries.add(ModBlocks.MAGIC_BLOCK);
        });
    }
}
