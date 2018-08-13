package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

	private WebDriver driver;
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//By linkLogout = By.linkText("Logout");
	
	//page factory
	@FindBy(linkText = "Logout")
	WebElement linkLogout;
	
	public boolean validateLogout()
	{
		/*if(driver.findElement(linkLogout).isDisplayed()){
			return true;
		}else{
			return false;
		}*/
		
		if(linkLogout.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
}
