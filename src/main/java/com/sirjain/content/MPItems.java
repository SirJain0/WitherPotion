package com.sirjain.content;

import com.sirjain.MPMain;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MPItems {
        public static Item WITHERED_ASHES;

        // Registers mod items
        public static void registerItems() {
                WITHERED_ASHES = Registry.register(
                        Registries.ITEM,
                        Identifier.of(MPMain.MOD_ID, "withered_ashes"),
                        new Item(new Item.Settings())
                );

                ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((entries -> entries.add(WITHERED_ASHES)));
        }
}