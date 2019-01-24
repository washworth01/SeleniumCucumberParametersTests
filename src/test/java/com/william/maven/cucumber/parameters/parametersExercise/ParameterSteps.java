package com.william.maven.cucumber.parameters.parametersExercise;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.william.maven.cucumber.parameters.selenium.Constants;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParameterSteps 
{
	WebElement element;
	WebDriver driver;
	String searchRequest;
	
	@Before
	public void setup()
	{
		System.setProperty(Constants.CHROMEDRIVER, Constants.CHROMEDRIVERLOCATION);
		driver = new ChromeDriver();
		driver.manage().window();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) 
	{		
		ParametersTestRunner.test = ParametersTestRunner.report.startTest("test");
		driver.get(Constants.LANDINGPAGEURL);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1)
	{
		ParametersTestRunner.test.log(LogStatus.INFO, "Entering Search Request and Sending Search");
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		searchRequest = landingPage.enterSearchRequest(arg1);
		ParametersTestRunner.test.log(LogStatus.INFO, "Search Request sent");
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search()
	{
		ParametersTestRunner.test.log(LogStatus.INFO, "Checking that the Search Page is correct");
		if(driver.getCurrentUrl().contains(searchRequest))
		{
			ParametersTestRunner.test.log(LogStatus.PASS, "The urls should contain the search query | Expected: " + "true" + " | Actual: " + driver.getCurrentUrl().contains(searchRequest));

		}
		else
		{
			ParametersTestRunner.test.log(LogStatus.FAIL, "The urls should contain the search query | Expected: " + "true" + " | Actual: " + driver.getCurrentUrl().contains(searchRequest));
		}
		ParametersTestRunner.report.endTest(ParametersTestRunner.test);
		assertEquals("The urls should contain the search query", true, driver.getCurrentUrl().contains(searchRequest));
	}
}
