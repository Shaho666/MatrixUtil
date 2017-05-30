package com.example.matrixui.uiframe;

import java.util.Properties;

public class PropertiesInterface {

	private static Properties properties = new Properties();
	private static Properties proper = new Properties();

	public static Properties getProperties() {
		try {

			properties.load(PropertiesInterface.class.getResourceAsStream("/com/example/matrixui/configchinese.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return properties;
	}

	public static Properties getAllItems() {
		try {

			proper.load(PropertiesInterface.class.getResourceAsStream("/com/example/matrixui/pagemapchinese.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return proper;
	}
	
}
