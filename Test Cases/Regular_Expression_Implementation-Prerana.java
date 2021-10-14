package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Pattern;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import generalFunctionalities.TakeScreenShot;
import pageClasses.CustomerSearchesReportPage;

import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Regular_Expression_Implementation {
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
	
        
   // Implementation of Regular Expression
        
        String txt=login.containsCustomer();
		
		boolean b=Pattern.compile("^Customer.*").matcher(txt).find();
		
		Assert.assertEquals(b,true );
		
		
	    System.out.println("The given Expression matches with the pattern!!");
	    System.out.println("Admin Customer Reports page starts with Customer!");
		
		
	
	} 
}