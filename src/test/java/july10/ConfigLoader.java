package july10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	public static void main(String[] args) {
		
		Properties prop=new Properties();

		try {
			FileInputStream fis=new FileInputStream("configNew.properties");
			prop.load(fis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("fairfax"));

		System.out.println(prop.getProperty("Washington DC"));
		
		System.out.println(prop);
		
	
	}

}
