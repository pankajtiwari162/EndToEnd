package com.r1.pages;

import org.openqa.selenium.WebDriver;

import com.r1.base.Base;
import com.r1.utils.FindPageObjects;
import com.r1.utils.PropertyFileReader;
import com.r1.utils.WebDriverMethods;
import com.vimalselvam.cucumber.listener.Reporter;

public class Authenitication {
    Base                base                     =    new Base();
	FindPageObjects     findPageObjects          =   new   FindPageObjects();
	WebDriverMethods    webDriverMethods         =    new WebDriverMethods();


	public Authenitication() {

	}


	public void enterUsername(String username) {
		try {
			
			webDriverMethods.sendKeys(findPageObjects.getObject("EMAILADDRESSINPUTBOX"), username, 5);
			Reporter.addStepLog(username   + " entered in username input box");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(username   + " unable to enter in username field");
			throw new RuntimeException(username   + " unable to enter in username field");
		}

	}



	public void enterPassword(String password) {
		try {
			
			webDriverMethods.sendKeys(findPageObjects.getObject("PWDINPUTBOX"), password, 5);
			Reporter.addStepLog(password   + " entered in password input box");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog(password   + " unable to enter in password field");
			throw new RuntimeException(password   + " unable to enter in password field");
		}

	}


	public void clickSignIn() {
		try {
			webDriverMethods.click(findPageObjects.getObject("SIGNINBUTTON"), 5);
			Reporter.addStepLog("Clicked on Sign in");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Unable to perform click on Sign in field");
			throw new RuntimeException("Unable to perform click on Sign in field");
		}

	}
	
	
	
	

}
