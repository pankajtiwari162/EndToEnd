package com.r1.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.r1.base.Base;

public class WebDriverMethods {
	WebDriverWait     wait;
	WebDriver        driver;
	Base       base    =    new    Base();

	/**
	 *Constructor of the class
	 * **/

	public WebDriverMethods() {
             this.driver   =    base.getDriver();      

	}


/**
 * Function to perform click on webelements
 * **/

	public void click(WebElement element, int timeout) {
		try {
			wait  =   new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed()) {
				element.click();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Element not clicked");

		}

	}
	
	
	/**
	 * Function to perform typing
	 * */
	public void sendKeys(WebElement element,String value,int timeout) {
		try {
			wait  =   new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element)); 
		
			if(element.isDisplayed()) {
				element.sendKeys(value);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to enter the value");
		}
		
	}
	


}
