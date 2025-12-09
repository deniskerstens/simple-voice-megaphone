package com.sluym1k.simplemegaphone.item;

import com.sluym1k.simplemegaphone.SimpleMegaphone;
import com.sluym1k.simplemegaphone.item.custom.Megaphone;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SimpleMegaphone.MODID);

    public static RegistryObject<Item> MEGAPHONE = ITEMS.register("megaphone",
            () -> new Megaphone(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
