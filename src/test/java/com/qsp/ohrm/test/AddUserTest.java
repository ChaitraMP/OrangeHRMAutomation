package com.qsp.ohrm.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddUserPage;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;

public class AddUserTest extends BaseTest
{

	
	OrangeHRMLoginPage oLoginpage= null;
	OrangeDashboardPage odp = null;
	OrangeHRMAddUserPage Adduserpage=null;
	
	@BeforeClass
 	public void preConfig(){
 		Log.startReport("setup");
 		
		driver = DriverUtils.getWebDriver();
		oLoginpage = new OrangeHRMLoginPage(driver);
		odp = new OrangeDashboardPage(driver);
		Adduserpage=new OrangeHRMAddUserPage(driver);
		
 	}
	@Test(priority=1)
	public void validateLoginTest(){
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		Log.pass("Login to Applicaiton Success");
		Log.info("--Completeds Executing Test - validateLoginTest");
 		//Log.endReport("validateLoginTest");
		oLoginpage.loginToOrangeHRM(driver, "Admin", "QSPAdmin1@#");
		Adduserpage.clickadminUseradmin();
		Adduserpage.clickusers();
		Adduserpage.clickAddUser();
		Adduserpage.selectRoleByIndex("byIndex", "1");
		Adduserpage.enterEmployeeName("Rajesh Krishna");
		Adduserpage.enterUserName("RajeshK1");
		Adduserpage.selectStatus("byIndex", "0");
		Adduserpage.enterPassword("April@2019@2018@2017");
		Adduserpage.confirmPassword("April@2019@2018@2017");
		Adduserpage.clickOnSaveUserButton();
	}
	@Test(priority=2)
	public void searchUsers()
	{
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		Log.pass("Login to Applicaiton Success");
		Log.info("--Completeds Executing Test - validateLoginTest");
		oLoginpage.loginToOrangeHRM(driver, "Admin", "admin123");
		Adduserpage.clickadminUseradmin();
		Adduserpage.clickusers();
		Adduserpage.enterValueToSearchUser("RajeshK");
		Adduserpage.clickSearchButton();
	}
}
