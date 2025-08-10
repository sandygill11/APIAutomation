package api.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

	public static String getConfigValue(String key) {

		Properties property = new Properties();
		FileInputStream file = null;

		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			property.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return property.getProperty(key);

	}
}
