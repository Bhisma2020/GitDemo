package com.crm.qa.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;
import com.crm.qa.util.TestUtil;


public class ContactPageTest extends TestBase {
	
		LogInPage LogInPage;
		HomePage homePage;
		
		ContactPage contactPage;
		TestUtil testUtil;
		
		String sheetName = "contacts";
		
		public ContactPageTest() {
				super();
				
		}
		
		@BeforeMethod
		public void setup() throws InterruptedException {
		TestBase.initialization();
		testUtil = new TestUtil();
		LogInPage = new LogInPage();
		contactPage = new ContactPage();
		homePage = LogInPage.LogIn();
			
		//testUtil.switchtoFrame();
		contactPage = homePage.verifyClickONContactLink();
		
		}
				
		//@Test(priority=1)
		public void verifyContactLabelIsDisplayed() throws InterruptedException {
			
			 //contactPage.verifycontactisDisplayed();
			Assert.assertTrue(contactPage.verifycontactisDisplayed( ));
		}
		
	@Test(priority=2)
		public void verifyContactsLabelPrinted() throws InterruptedException {
//			
			contactPage.verifyContactsisPrinted();
	}
		
		
		//@Test(priority=3)
		public void verifyContactsSelected() throws InterruptedException {
			
			contactPage.verifyContactisSelected();
		}
		
		
	@DataProvider
		public Object[][] getCRMTestData() throws InterruptedException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		Object data[][]=com.crm.qa.util.TestUtil.getTestData(sheetName);
		return data;
	
	}

		@Test(priority=4,dataProvider="getCRMTestData")
		public void validateCreateNewContact (String FirstName,String LastName) throws InterruptedException    {
			homePage.verifyClickONContactLink();
			
			driver.switchTo().parentFrame();
		contactPage.verifyNewisSelected();
		//contactPage.clickOnNewBtn();
		//Thread.sleep(5000);
		contactPage.createNewContact(FirstName,LastName);
		
		}
		
		//@Test(priority=5)
		public void deleteContacts() throws InterruptedException {
			
			homePage.verifyClickONContactLink();
			driver.switchTo().parentFrame();
			Thread.sleep(5000);
			contactPage.ClickDeleteIcon();
			//contactPage.deleteContacts();*/
		
		
		}
		
		@AfterMethod
		public void tearDown() throws InterruptedException {
			Thread.sleep(5000);
			driver.quit();
		
	
	
}}