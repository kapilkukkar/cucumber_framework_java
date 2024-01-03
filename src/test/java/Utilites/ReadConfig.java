package Utilites;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadConfig 

{
	Properties properties;
	String path="Config.properties";

	public ReadConfig() 
	{
		try 
		{
			properties = new Properties();   

			// open and load file
			FileInputStream fil = new FileInputStream(path);
			properties.load(fil);
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}

	
	public String getbrowser()
	{
		//read config properties
		String brwsr= properties.getProperty("browser");
		if(brwsr!= null)
			return brwsr;
		else
			throw new RuntimeException("Browser not Specified");
	}
}
