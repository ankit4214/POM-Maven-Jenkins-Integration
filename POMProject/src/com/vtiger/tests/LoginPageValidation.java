package com.vtiger.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vtiger.base.BaseTest;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LoginPage;

public class LoginPageValidation extends BaseTest{

	@BeforeClass
	public void AppLaunch()
	{
		createReport();
		appLaunch();
	}
	
	@Test
	public void verifyTitle()
	{
		logger = report.startTest("verifyTitle");
		LoginPage loginpage = new LoginPage(driver);
		boolean value = loginpage.validateTitle("vtiger CRM - Commercial Open Source CRM");
		if(value){
			logger.log(LogStatus.PASS, "Title matched successfully");
		}else{
			logger.log(LogStatus.FAIL, "Title did not match");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@Test
	public void verifyLogo()
	{
		logger = report.startTest("verifyLogo");
		LoginPage loginpage = new LoginPage(driver);
		boolean value = loginpage.validateLogo();
		if(value){
			logger.log(LogStatus.PASS, "Logo displayed successfully");
		}else{
			logger.log(LogStatus.FAIL, "Logo not found");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@Test
	public void verifyLoginTheme()
	{
		logger = report.startTest("verifyLoginTheme");
		LoginPage loginpage = new LoginPage(driver);
		boolean value = loginpage.validateLoginTheme();
		if(value){
			logger.log(LogStatus.PASS, "Theme selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Theme not selected");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@Test
	public void verifyInvalidLogin()
	{
		logger = report.startTest("verifyInvalidLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("", "");
		loginpage.login("admin1", "admin");
		loginpage.login("admin", "admin1");
		loginpage.login("admin1", "admin1");
		boolean value = loginpage.validateErrorMsg();
		if(value){
			logger.log(LogStatus.PASS, "Error messege displayed");
		}else{
			logger.log(LogStatus.FAIL, "Error messege not displayed");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@Test
	public void verifyValidLogin()
	{
		logger = report.startTest("verifyValidLogin");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		HeaderPage headerpage = new HeaderPage(driver);
		boolean value = headerpage.validateLogout();
		if(value){
			logger.log(LogStatus.PASS, "Valid login working successfully");
		}else{
			logger.log(LogStatus.FAIL, "valid login not working");
		}
		report.endTest(logger);
		report.flush();
	}
	
	@AfterClass
	public void appClose()
	{
		driver.quit();
	}
}
