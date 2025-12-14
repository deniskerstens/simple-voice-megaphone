package com.sluym1k;

import com.sluym1k.items.SimpleMegaphoneItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SimpleMegaphone {
    public static final String MOD_ID = "simplemegaphone";
    public static float distanceMultiplier = 2f;

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Simple Voice Megaphone mod got initialized!");
        SimpleMegaphoneItems.init();
    }
}
