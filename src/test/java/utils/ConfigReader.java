package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop;
	static FileInputStream file;
	
	public static void initializeProperty() throws IOException {
		
		prop = new Properties();
		file = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//GlobalData.properties");
		prop.load(file);
	}
	
	public static String getProperty(String key) {
		
		return prop.getProperty(key);
	}

}
