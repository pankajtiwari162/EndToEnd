package com.r1.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author pankaj.tiwari
 * */

public class PropertyFileReader {

	private static String  confgiFilePath    =  "./Config/Config.properties";   
	private static String  locatorFilePath    =  "./OR/locator.properties";



	/**
	 * Constructor of the class
	 * **/
	public PropertyFileReader() {}

	
	
	
/**
 * @author pankaj.tiwari
 * @Des  - To read the values from Config file
 * @param - Pass the keyName
 **/
	public static String readConfigFile(String key) {
		String keyvalue = null;
		try {
			File                 file         =     new    File(confgiFilePath);
			FileInputStream      fis          =     new    FileInputStream(file);
			Properties           properties   =     new  Properties();
			properties.load(fis);
			keyvalue = properties.getProperty(key);
		} catch (Exception e) {
          System.out.println(key + " not found in Config file");
		}
		return keyvalue;

	}

	public static void main(String[] args) {
       System.out.println(readConfigFile("URL"));
	}



	/**
	 * @author pankaj.tiwari
	 * @Des  - To read the values from locator file
	 * @param - Pass the keyName
	 **/

	public static String readLocatorFile(String key) {
		String keyvalue = null;
		try {
			File                 file         =     new    File(locatorFilePath);
			FileInputStream      fis          =     new    FileInputStream(file);
			Properties           properties   =     new  Properties();
			properties.load(fis);
			keyvalue = properties.getProperty(key);
		} catch (Exception e) {
          System.out.println("Error");
		}
		return keyvalue;

	}

}
