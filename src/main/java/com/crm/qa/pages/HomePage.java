package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
 
	@FindBy(xpath="//span[contains(text(),'Visma Thapa')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//button[@class='ui linkedin')]")
	WebElement NewcontactsLink;
	
	@FindBy(xpath ="//span[contains(text(),'Deals')]")
	WebElement Deals;
	
	@FindBy(xpath ="//span[contains(text(),'Tasks')]")
	WebElement TaskPage;
	
	@FindBy(xpath="//iframe[@id='downloadFrame']")
	WebElement frame;
	
	
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
		
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactPage verifyClickONContactLink() throws InterruptedException {
		driver.switchTo().parentFrame();
		contactsLink.click();
		
		return new ContactPage();
		
	}
	
	public boolean correctUsernameDisplayed() {
		
		return UserNameLabel.isDisplayed();
	}
	
	public void printUsername () {
		String userName = UserNameLabel.getText();
		System.out.println(userName);
	}
	
	
	public DealsPage verifyClickonDealsLink()  {
		Deals.click();
		//Thread.sleep(5000);
		return new DealsPage();
	}
	
	public TaskPage verifyClickonTaskLink() {
		TaskPage.click();
		//Thread.sleep(5000);
		return new  TaskPage(); 
	
	}
	/*public void CLickonNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(NewcontactsLink).build().perform();
		NewcontactsLink.click();
	}*/

	
}
	
	
	