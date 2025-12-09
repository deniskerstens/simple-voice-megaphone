package com.sluym1k.simplemegaphone;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = SimpleMegaphone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.DoubleValue DISTANCE_MULTIPLIER = BUILDER.comment("Distance multiplier when using megaphone item").defineInRange("Megaphone distance multiplier", 2.0, Double.MIN_VALUE, Double.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static float distanceMultiplier;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        distanceMultiplier = DISTANCE_MULTIPLIER.get().floatValue();
    }
}
