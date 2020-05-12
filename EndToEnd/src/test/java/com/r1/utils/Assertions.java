package com.r1.utils;

import org.openqa.selenium.WebElement;

import junit.framework.Assert;



public class Assertions {


	/**
	 * Constructor of the class
	 * **/
	public Assertions() {}

	/**
	 * Function to validate of element is visible
	 * **/
	public void isElementDisplayed(WebElement element) {
		try {
			Assert.assertTrue(element.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(element.toString() + " not displayed");
		}
	}


	/**
	 * @return 
	 * function to check weather element is displayed or not
	 * 
	 * */

	public boolean isElementPresent(WebElement element) {
		boolean flag  = false;
		try {
			if (element.isDisplayed())
				flag = true;

		} catch (Exception e) {

		}
		return flag;
	}


	public void  assertEqual(String expected, String actual) {
		try {
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
