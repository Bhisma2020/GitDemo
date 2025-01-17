package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.constant;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;	
	public static WebEventListener eventListener;	
	public TestBase() {
		
			
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\Automation\\CrmMyTest\\src\\main\\java\\com\\crm\\qa"
					+ "\\config\\config.properties");
			prop.load(ip);
//			System.out.println(prop.getProperty("browser"));
		}
			catch(FileNotFoundException e) {
				e.printStackTrace();
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
	}
		
		
		public static void initialization() {
			
 			String browserName = prop.getProperty("browser");
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver","F:\\Submission Tracking\\chromedriver.exe");
				
				 driver = new ChromeDriver();
			}
			else if (browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver","//F:\\Submission Tracking\\geckodriver.exe");
				
				 driver = new FirefoxDriver();
			}
			

			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
		
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().(TestUtil.EXPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().pageLoadTimeout(constant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(constant.IMPLICIT_WAIT,TimeUnit.SECONDS);
			
			
	}
	
	
	
	
}
