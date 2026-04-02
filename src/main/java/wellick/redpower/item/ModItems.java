package wellick.redpower.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import wellick.redpower.Redpower;
import wellick.redpower.item.custom.ChiselItem;

public class ModItems {

    //Iron -> Steel: brightness -70

    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));
    public static final Item COKE = registerItem("coke", new Item(new Item.Settings()));

    public static final Item DIHH = registerItem("dihh", new Item(new Item.Settings().food(ModFoodComponents.DIHH)));


    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Redpower.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Redpower.LOGGER.info("Registering Mod Items for " + Redpower.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(STEEL_INGOT);
            entries.add(COKE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(DIHH);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CHISEL);
        });
    }
}
