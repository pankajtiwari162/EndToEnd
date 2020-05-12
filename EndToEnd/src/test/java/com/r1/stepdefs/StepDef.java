package com.r1.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.r1.base.Base;
import com.r1.pages.Authenitication;
import com.r1.pages.HomePage;
import com.r1.pages.MyAccount;
import com.r1.utils.Assertions;
import com.r1.utils.FindPageObjects;
import com.r1.utils.PropertyFileReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	WebDriver           driver;
	Base                base                  =     new Base();
	HomePage            homepage              =     new HomePage();
	Authenitication     authenitication       =     new Authenitication();
	Assertions          assertions            =     new Assertions();
	FindPageObjects     findPageObjects       =     new FindPageObjects();
	MyAccount             myAccount             =     new MyAccount();

	/**
	 * @Constuctor of the class
	 * */

	public StepDef() {
		this.driver   =    base.getDriver();
	}

	@Given("^I open the browser$")
	public void i_open_the_browser() throws Throwable {

		driver.get(PropertyFileReader.readConfigFile("URL"));
		driver.manage().window().maximize();

	}

	@When("^I click on Sign i link$")
	public void i_click_on_Sign_i_link() throws Throwable {
		homepage.clickSignIn();
	}

	@When("^I enter username \"(.*?)\"$")
	public void i_enter_username(String username) throws Throwable {
		authenitication.enterUsername(username);
	}

	@When("^I enter Password \"(.*?)\"$")
	public void i_enter_Password(String password) throws Throwable {
		authenitication.enterPassword(password);
	}

	@When("^I click on Sign In$")
	public void i_click_on_Sign_In() throws Throwable {
		authenitication.clickSignIn();
	}

	@Then("^Validate login is successfull$")
	public void validate_login_is_successfull() throws Throwable {
		assertions.isElementDisplayed(findPageObjects.getObject("HOMEICON"));
		myAccount.clickSignOut();

	}
	
	
	@Then("^validate URL \"(.*?)\" is displaying$")
	public void validate_URL_is_displaying(String expectedURL) throws Throwable {
	String actualURL =   driver.getCurrentUrl();
	assertions.assertEqual(expectedURL, actualURL);
	System.out.println("PASS");
	
	}
	
	
	

	@After
	public void tearDown(Scenario scenario) {

		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png"); //stick it in the report
		}

		if(driver!=null)

		{
			driver.quit();
			base.setDriver();

		}



	}

}
