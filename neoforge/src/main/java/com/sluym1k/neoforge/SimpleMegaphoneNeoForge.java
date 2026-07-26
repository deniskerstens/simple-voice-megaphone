package com.sluym1k.neoforge;

import com.sluym1k.SimpleMegaphone;
import net.neoforged.fml.common.Mod;

@Mod(SimpleMegaphone.MOD_ID)
public final class SimpleMegaphoneNeoForge {
    public SimpleMegaphoneNeoForge() {
        // EventBus.registerModEventBus(SimpleMegaphone.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        // ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        SimpleMegaphone.init();
    }
}

