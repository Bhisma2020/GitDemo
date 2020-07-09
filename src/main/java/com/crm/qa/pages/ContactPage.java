package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath ="//button[contains(text(),'New')]")
	WebElement NewBtn;
	
	@FindBy(xpath ="//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//tr[1]//td[8]//div[1]//button[1]")
	WebElement ClickDeleteIcon;
		
	@FindBy(xpath ="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath ="//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath ="//*[text()='New']")
	WebElement contactsLabel;
	
	@FindBy(xpath ="//div[@class='ui checked fitted read-only checkbox']//label")
	WebElement Clickcheckbox;
	
	@FindBy(xpath="//td[contains(text(),'visma Thapa')]")
	WebElement SelectContacts;	
	
	@FindBy(xpath="(//*[@type='checkbox'])[1]")
	WebElement clickAllContacts;
	
	@FindBy(xpath="//*[@class='ui basic button item']")
	WebElement clickDeleteContacts;
	//*[@class='ui basic button item']
	
	@FindBy(xpath="//button[@class='ui button']")
	WebElement CLickDelete;
	public ContactPage() {
	
	PageFactory.initElements(driver,this);
	
}
	public boolean verifycontactisDisplayed() throws InterruptedException {
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		return  contactsLabel.isDisplayed();
	
	}
	
	public void verifyContactsisPrinted() throws InterruptedException {
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		String contact= contactsLabel.getText();
		System.out.println(contact);
	}
	
	public  void verifyContactisSelected() throws InterruptedException {
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
	 SelectContacts.click();
	}
	
		
	public  void verifyNewisSelected() throws InterruptedException {
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(NewBtn).build().perform();
		NewBtn.click();
	
}
	
	public void clickOnNewBtn() {
		NewBtn.click();
	}
	
	public void createNewContact(String FtName,String LtName) {
		//Select select = new Select(By.xpath(xpathExpression))
		FirstName.sendKeys(FtName);
		LastName.sendKeys(LtName);
		saveBtn.click();
		
	}
	
	
	public void deleteContacts() {
		
		
		Actions action = new Actions(driver);
		action.moveToElement(ClickDeleteIcon).build().perform();
		ClickDeleteIcon.click();
	}
	
	public void ClickDeleteIcon() {
		CLickDelete.click();
	}
	
	
}