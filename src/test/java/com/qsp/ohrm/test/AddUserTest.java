package com.qsp.ohrm.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddUserPage;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.utils.ConfigFileReader;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.ExtentReportFactory;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;
import com.qsp.ohrm.utils.Screenshots;

public class AddUserTest extends BaseTest
{

	
	ConfigFileReader config ;
	WebDriver driver;
	OrangeHRMLoginPage olp = null;
	OrangeHRMAddUserPage aup = null;
	OrangeDashboardPage odp = null;
	@BeforeClass
	public void setup(){
		config = new ConfigFileReader();
		Log.configureReport();
		Log.startReport("setup");
		driver = DriverUtils.getWebDriver(config.getBrowserType());
		olp = new OrangeHRMLoginPage(driver);
		odp = new OrangeDashboardPage(driver);
		aup = new OrangeHRMAddUserPage(driver);
	
	}
	
	
	@Test
	public void AddUserTest(){
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		olp.loginToOrangeHRM(driver, config.getUserName(), config.getPasswordName());
		aup.selectUserRoleByText("");
		
	}
}
