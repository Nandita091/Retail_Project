package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import generalFunctionalities.TakeScreenShot;
import pageClasses.CustomerSearchesReportPage;

import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class verifyAdminCustomerSearches {
	String exePath="C:\\Users\\User\\eclipse-workspace\\Selenium\\chromedriver.exe";
    static WebDriver driver;
    public TakeScreenShot shot; 
	
/*@AfterTest
public void closeAll()
{
	driver.close();
}*/
    
    
    @BeforeClass
    public void init()
    {
    	System.setProperty("webdriver.chrome.driver",exePath);
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin");
		driver.manage().window().maximize();
		
    }
   
	
   @Test 
	public void checkSearch()throws InterruptedException,FileNotFoundException,IOException
	{
		CustomerSearchesReportPage login=new CustomerSearchesReportPage(driver);
		login.adminLogin();
		Properties obj=new Properties();
		FileInputStream objfile=new FileInputStream("searchKeyword.properties");
		obj.load(objfile);
		String key=obj.getProperty("keyword");
		driver.findElement(By.id("input-keyword")).sendKeys(key);

		driver.findElement(By.cssSelector("#button-filter")).click();
		
		shot=new TakeScreenShot(driver);
		String Screenshot=shot.screenshot();
		shot.takeSnapShot(driver, Screenshot);
		String from_to = driver.findElement(By.cssSelector("#content > div.container-fluid > div > div.panel-body > div.table-responsive > table > tbody > tr:nth-child(1)")).getText();
		System.out.println("========Details of Searched Keyword/product are========");
        System.out.println(from_to);
        System.out.println("The product searched by the User matches the product displayed at the Admin Page of Customer Searches Report!! ");
        Reporter.log("The Item/Product searched by the customer at the Home Page of application matches the product displayed at the Admin Customer Searches Report.");
		
		
	
	} 
}
			
			