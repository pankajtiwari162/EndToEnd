package com.r1.pages;

import com.r1.utils.FindPageObjects;
import com.r1.utils.WebDriverMethods;
import com.vimalselvam.cucumber.listener.Reporter;

public class MyAccount {
	WebDriverMethods    webDriverMethods   =   new WebDriverMethods();
	FindPageObjects     findPageObjects    =   new  FindPageObjects();
	
	
	public MyAccount() {}
	
	
	public void clickSignOut() {
		try {
			webDriverMethods.click(findPageObjects.getObject("SIGNOUT"), 5);
			Reporter.addStepLog("Clicked on Sign Out");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.addStepLog("Unable to perform click on Sign Out field");
			throw new RuntimeException("Unable to perform click on Sign Out field");
		}
	}

}
