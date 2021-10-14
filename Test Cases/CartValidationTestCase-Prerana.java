package testCases;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import generalFunctionalities.TakeScreenShot;
import pageClasses.CartValidationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CartValidationTestCase {
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
		driver.get("http://retailm1.upskills.in/account/login");
		driver.manage().window().maximize();
		
    }
   
	
   @Test 
	public void checkCartTotal()throws InterruptedException,FileNotFoundException,IOException
	{
	    CartValidationPage login=new CartValidationPage(driver);
		login.cartLogin();
		Thread.sleep(1000);
		int carttotal=login.calculateCartTotal();
		
	/*	shot=new TakeScreenShot(driver);
		String Screenshot=shot.screenshot();
		shot.takeSnapShot(driver, Screenshot);*/
		String finalTotal=driver.findElement(By.xpath("//*[@id=\"total\"]/tbody/tr[2]/td[2]")).getText();
		System.out.println("Cart Total Calulated by User manually = "+carttotal);
		
		System.out.println("Cart Total Displayed on the Page = "+finalTotal);
		
		
		
	
	} 
}