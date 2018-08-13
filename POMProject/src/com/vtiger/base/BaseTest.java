package com.vtiger.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vtiger.common.CommonFunction;

public class BaseTest {

	public WebDriver driver;
	public static ExtentReports report;
	public static String extentReport;
	public static ExtentTest logger;
	
	public void createReport()
	{
		report = CommonFunction.setupResult();
	}
	
	public void appLaunch()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\com\\vtiger\\utilities\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
