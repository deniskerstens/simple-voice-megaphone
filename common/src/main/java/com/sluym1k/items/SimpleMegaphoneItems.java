package com.sluym1k.items;

import com.sluym1k.SimpleMegaphone;
import com.sluym1k.items.custom.Megaphone;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class SimpleMegaphoneItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SimpleMegaphone.MOD_ID, Registries.ITEM);
    public static final RegistrySupplier<Item> MEGAPHONE = ITEMS.register("megaphone", () -> new Megaphone(new Item.Properties().stacksTo(1).arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES)));;

    public static void init() {
        ITEMS.register();
    }
}
