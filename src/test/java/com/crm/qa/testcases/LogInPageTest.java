package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;

public class LogInPageTest extends TestBase {
	HomePage homePage;
	LogInPage LogInPage;
	
	
	public LogInPageTest() {
			super();
		
		
	}
	
	@BeforeMethod
	public void setup() {
	TestBase.initialization();
	LogInPage = new LogInPage();
	
	}
	
	@Test(priority = 1)
	public void LogInPageTitleTest() {
		 String title = LogInPage.validateLogInPage();
		 Assert.assertEquals(title, "Free CRM software can boost your sales by 30%");
		 	
		
	}
	
	@Test(priority = 2)
	public void crmLogoTest() {
		boolean flag = LogInPage.validatecrmlogo();
		Assert.assertTrue(flag);
		
		
	}
	
	@Test(priority = 3)
	public void LogIntest() throws InterruptedException {
		  homePage = LogInPage.LogIn();
		  LogInPage.verifyAccountName();
	}
	
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
	
}
}
