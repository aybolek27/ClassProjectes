package july10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader2 {
	//String url=CinfigLoader.getMyValue("a key in here");
	//driver.get(url);
	private static Properties prop; 
	
	static {
	
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("configNew.properties");
			prop.load(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
	public static String getMyValue(String key) {
		String value= prop.getProperty(key);
		return value;
	}
	

		

	
}
