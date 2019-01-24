package com.william.maven.cucumber.parameters.parametersExercise;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.william.maven.cucumber.parameters.selenium.Constants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class ParametersTestRunner 
{
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeClass
	public static void setup()
	{
		System.setProperty(Constants.CHROMEDRIVER, Constants.CHROMEDRIVERLOCATION);
		report = new ExtentReports(Constants.REPORTLOCATION, true);
	}
	
	@AfterClass
	public static void tearDown()
	{
		report.flush();
	}
}
	
