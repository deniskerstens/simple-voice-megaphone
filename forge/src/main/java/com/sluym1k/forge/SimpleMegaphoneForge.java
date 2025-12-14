package com.sluym1k.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.sluym1k.SimpleMegaphone;

@Mod(SimpleMegaphone.MOD_ID)
public final class SimpleMegaphoneForge {
    public SimpleMegaphoneForge() {
        EventBuses.registerModEventBus(SimpleMegaphone.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        SimpleMegaphone.init();
    }
}
