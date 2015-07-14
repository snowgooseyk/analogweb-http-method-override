package org.analogweb.com.github.snowgooseyk.ahmo;

import org.analogweb.ModulesBuilder;
import org.analogweb.UserModulesConfig;

public class ModulesConfig implements UserModulesConfig {

	@Override
	public ModulesBuilder prepare(ModulesBuilder builder) {
		builder.addApplicationProcessorClass(HttpMethodOverride.class);
		return builder;
	}

}
