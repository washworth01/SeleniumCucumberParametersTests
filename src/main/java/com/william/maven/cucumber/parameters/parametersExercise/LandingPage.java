package com.william.maven.cucumber.parameters.parametersExercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage
{
	@FindBy(xpath = "//*[@id=\"sb_form_q\"]")
	private WebElement searchBar;
	
	public String enterSearchRequest(String input)
	{
		searchBar.sendKeys(input + Keys.RETURN);
		return input.replaceAll(" ", "+");
	}
} 
