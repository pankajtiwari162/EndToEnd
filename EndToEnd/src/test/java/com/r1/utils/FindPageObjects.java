package com.r1.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.r1.base.Base;

public class FindPageObjects {
	Base         base     =      new    Base();
	WebDriver     driver;
	/**
	 *Constructor of the class
	 **/
	public FindPageObjects() {
		this.driver  =    base.getDriver();

	}



	/**
	 * Function to get the page objects
	 * **/
	public WebElement getObject(String key) {
		WebElement  element  = null;
		String      locType   = null;
		String      locValue  = null;

		String keyValue  =	PropertyFileReader.readLocatorFile(key);
		String[]   locator =  keyValue.split("~");

		locType        = locator[0];  
		locValue       = locator[1];
		
		System.out.println("LocType " + locType + "locvalue " + locValue  );

		try {
			if(locType.equalsIgnoreCase("ID")) {
				element =  driver.findElement(By.id(locValue));				
			}
			else if (locType.equalsIgnoreCase("NAME")) {
				element =  driver.findElement(By.name(locValue));
			}
			else if (locType.equalsIgnoreCase("XPATH")) {
				element =  driver.findElement(By.xpath(locValue));
			}

			else if (locType.equalsIgnoreCase("CSS")) {
				element =  driver.findElement(By.cssSelector(locValue));
			}

			else if (locType.equalsIgnoreCase("PartialLinkText")) {
				element =  driver.findElement(By.partialLinkText(locValue));
			}

			else if (locType.equalsIgnoreCase("LinkText")) {
				element =  driver.findElement(By.linkText(locValue));
			}
			

			else if (locType.equalsIgnoreCase("Class")) {
				element =  driver.findElement(By.className(locValue));
			}

			else if (locType.equalsIgnoreCase("Tag")) {
				element =  driver.findElement(By.tagName(locValue));
			}

			else {
				System.out.println(locType  + " is not correct");
			}


		} catch (Exception e) {
			// TODO: handle exception
		}

		return   element;

	}


}
