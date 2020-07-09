package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.WebdriverWaitUtil;

public class LogInPage extends TestBase {

	//Page factory or object repository
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Log In']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement SignUpLink;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement Logintab;
	
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	@FindBy(xpath="//*[text()='Visma Thapa']")
	WebElement accountName;
	
	public LogInPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLogInPage() {
		return driver.getTitle();
	}
	
	
	public boolean validatecrmlogo() {
		 return crmlogo.isDisplayed();
	}
	
	public void verifyAccountName() {
		String PageAcName = accountName.getText();
		String acName = prop.getProperty("accountName");
		Assert.assertEquals(PageAcName, acName);
	}
	
	public HomePage LogIn() throws InterruptedException {

//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfAllElements(LoginBtn));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", LoginBtn);

		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		Logintab.click();
		Thread.sleep(5000);
		return new HomePage();
	
	}
	
}
