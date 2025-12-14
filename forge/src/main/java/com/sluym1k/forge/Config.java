package com.sluym1k.forge;

import com.sluym1k.SimpleMegaphone;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = "simplemegaphone", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.DoubleValue DISTANCE_MULTIPLIER = BUILDER.comment("Distance multiplier when using megaphone item").defineInRange("MegaphoneDistanceMultiplier", 2.0, 0.001, 10000);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
         SimpleMegaphone.distanceMultiplier = DISTANCE_MULTIPLIER.get().floatValue();
    }

    @SubscribeEvent
    static void onReload(final ModConfigEvent.Reloading event) {
        SimpleMegaphone.distanceMultiplier = DISTANCE_MULTIPLIER.get().floatValue();
    }
}
