package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.CommonFunction;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //for page factory
	}
	
	//using POM 
//	By username = By.name("user_name");
//	By password = By.name("user_password");
//	By theme = By.name("login_theme");
//	By loginbtn = By.name("Login");
//	By logo = By.xpath("//img[@src='include/images/vtiger-crm.gif']");
//	By errMsg=By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
	
	//using Page Factory method
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="user_password")
	WebElement password;
	
	@FindBy(name="login_theme")
	WebElement theme;
	
	@FindBy(name="Login")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement logo;
	
	@FindBy(xpath="//td[contains(text(),'You must specify a valid username and password.')]")
	WebElement errMsg;
	
	public boolean validateTitle(String ExpectedTitle)
	{
		if(driver.getTitle().trim().equals(ExpectedTitle)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateLogo()
	{
		/*if(driver.findElement(logo).isDisplayed()){
			return true;
		}else{
			return false;
		}*/
		
		if(logo.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateLoginTheme()
	{
		CommonFunction.selectvisibletext(driver, theme, "nature");
		/*if(driver.findElement(theme).isDisplayed()){
			return true;
		}else{
			return false;
		}*/
		
		if(theme.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean validateErrorMsg()
	{
		/*if(driver.findElement(errMsg).isDisplayed()){
			return true;
		}else{
			return false;
		}*/
		
		if(errMsg.isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
	
	public void login(String userid, String pwd)
	{
//		for POM
//		driver.findElement(username).clear();
//		driver.findElement(username).sendKeys(userid);
//		driver.findElement(password).clear();
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginbtn).click();	
		
		//for Page factory
		
		username.clear();
		username.sendKeys(userid);
		password.clear();
		password.sendKeys(pwd);
		loginbtn.click();
	}
}
