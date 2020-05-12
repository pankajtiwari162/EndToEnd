package com.r1.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.r1.utils.PropertyFileReader;

public class Base {

	static WebDriver  driver = null;

	/**
	 * Construtor of the class
	 * **/
	public Base() {}


	public String getBrowser() {
		
		try {
			String browserValue = PropertyFileReader.readConfigFile("Browser");
			System.out.println("browser value is "+ browserValue);
			return browserValue;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Browser Name is Invalid");
		}
		

	}


	public WebDriver getDriver() {

		if(driver==null) {

			if(getBrowser().equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.silentOutput", "true");
				System.setProperty("webdriver.chrome.driver",PropertyFileReader.readConfigFile("CHROMEDRIVERPATH"));
				driver =  new ChromeDriver();
			}

			else if(getBrowser().equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",PropertyFileReader.readConfigFile("FIREFOXDRIVERPATH"));
				driver =  new FirefoxDriver();
			}

			else if(getBrowser().equalsIgnoreCase("IE") ) {
				System.setProperty("webdriver.ie.driver",PropertyFileReader.readConfigFile("FIREFOXDRIVERPATH"));
				driver =  new InternetExplorerDriver();
			}

			else {
				System.setProperty("webdriver.chrome.driver",PropertyFileReader.readConfigFile("CHROMEDRIVERPATH"));
				driver =  new ChromeDriver();
			}

		}
		return driver;
	}




	/**
	 * initialize the base driver to null
	 * */
	public void setDriver() {
		this.driver=null;
	}

}
