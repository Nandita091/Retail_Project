package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import generalFunctionalities.Driver;

public class userSearchKeyword {
	

	static WebDriver driver;
	
	@BeforeClass
	public void dofirst()
	{
		/*String exePath="C:\\Users\\User\\eclipse-workspace\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://retailm1.upskills.in/");*/
		driver=Driver.startBrowser("chrome", "http://retailm1.upskills.in");
	}
	
	
	@Test
	public void searchMethod()throws IOException
	{
		Properties obj=new Properties();
		FileInputStream objfile=new FileInputStream("searchKeyword.properties");
		obj.load(objfile);
		String key=obj.getProperty("keyword");
		driver.findElement(By.id("filter_keyword")).sendKeys(key);
		
		driver.findElement(By.cssSelector("#search_button")).click();
		Reporter.log("User searches for a product/item using the Search icon in the Home Page of application.");
		Reporter.log("This process is done to check whether the same product is displayed at the Admin Customer Searches Report.");
		
} 
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}