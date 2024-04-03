package de.jagenka;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IsNOmia implements ModInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger("isnomia");

	@Override
	public void onInitialize()
	{
		LOGGER.info("IsNOmia loaded.");
	}
}