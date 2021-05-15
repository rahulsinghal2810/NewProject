package Testing.src.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	public static Properties properties = null;
	static
	{
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" +  File.separator + "Config.properties";		
		properties = new Properties();		
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);						
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	public static String getProperties(String key)
	{
		if(properties !=null)
			return properties.getProperty(key);
		else
			System.out.println("Properties File not loaded Properly");
			return null;
	}
	
	public static void setProperties(String key,String value)
	{
		properties.setProperty(key, value);
	}
}
