package com.r1.pages;

import com.r1.utils.FindPageObjects;
import com.r1.utils.WebDriverMethods;

public class HomePage {
	WebDriverMethods      webDriverMethods     =     new   WebDriverMethods();
	FindPageObjects       findPageObjects      =     new   FindPageObjects();
	
	/**
	 * @Constructor of the class
	 * */
	public HomePage() {}
	
	
	public void clickSignIn() {
		try {
			webDriverMethods.click(findPageObjects.getObject("SIGNIN"), 5);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to perform click on Sign In link");
		}
		
	
		}
	
	
	
	public void enterValueInSearchBox() {
		
	}

}
