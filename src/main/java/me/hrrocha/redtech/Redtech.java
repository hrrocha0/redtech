package me.hrrocha.redtech;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Redtech implements ModInitializer {
    public static final String MOD_NAME = "Redtech";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello, world!");
    }
}