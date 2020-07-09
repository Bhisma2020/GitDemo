package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;
import com.crm.qa.util.TestUtil;



//Test Cases should be separated -----independent with each other
//before each test case --------------launch the browser and log in
//@Test ------------------------------execute test case
//after each test case----------------close the browser



public class HomePageTest extends TestBase {

	LogInPage LogInPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	DealsPage dealsPage;
	TaskPage taskPage1;
	
	public HomePageTest() {
			super();
			
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
	TestBase.initialization();
	LogInPage = new LogInPage();
	contactPage = new ContactPage();
	homePage = LogInPage.LogIn();
	dealsPage = new DealsPage();
	taskPage1 = new TaskPage();
	testUtil = new TestUtil();
	//Thread.sleep(2000);
	
	}
	
	@Test(priority =1)
	public void verifyHomePageTest() throws InterruptedException {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Cogmento CRM","HomePage title not matched");
		System.out.println(homePageTitle);
		Thread.sleep(2000);
		
	}
	
	@Test(priority =2)
	public void verifyUserName() throws InterruptedException {
		Assert.assertTrue(homePage.correctUsernameDisplayed());
		Thread.sleep(2000);
		//Assert.assertEquals(homePage.correctUsernameDisplayed(),"Visma Thapa","username not matched");
		
		homePage.printUsername();
	
	}
 
	
	@Test(priority=3)
	public  void verifyContactlinkText() throws InterruptedException  {
		//Thread.sleep(5000);
			System.out.println("clicking on contact page link");
			
		 	contactPage= homePage.verifyClickONContactLink();
		 String contactHeader = 	driver.findElement(By.xpath("//div[text()='Contacts']")).getText();
		Assert.assertEquals(contactHeader, "Contacts");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='New']")).click();
		Thread.sleep(10000);
	}
	
/*	@Test(priority=4)
	public void verifyDealsLinkisClicked() {
		dealsPage = homePage.verifyClickonDealsLink();
//	}
//
//	@Test(priority=5)
//	public void verifyTaskLinkisClicked() {
//		taskPage = homePage.verifyClickonTaskLink();
//	
//	}
	*/
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
}
}