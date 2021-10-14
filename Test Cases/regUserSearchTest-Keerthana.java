package retail.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import retail.pages.GuestSearchPage;
import retail.pages.regUserSearchPage;

public class regUserSearchTest {
	
	static WebDriver driver;
	static regUserSearchPage search;
	
	
	@Test
	public void initdriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	//search = new UserSearchPage(driver);
    	driver.get("http://retailm1.upskills.in/account/login");
    	
    	regUserSearchPage search = new regUserSearchPage(driver);
    	search.typeemail("naijajain1999@gmail.com");
    	search.typePassword("12345678");
    	search.clickLoginButton();
    	search.clickSearchToType();
    	search.typeItemToBeSearched("Ring");
    	search.clicksearchicontosearch();
    	search.sortBy();
    	Thread.sleep(4000);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,500)");
	}
    	
	
	@Test
	public void verifyanothersearchitemisgiven() throws InterruptedException {
		regUserSearchPage search = new regUserSearchPage(driver);
    	
		driver.findElement(By.cssSelector("#filter_keyword")).clear();
		
    	search.clickSearchToType();
    	search.typeItemToBeSearched("Laptop");
    	search.clicksearchicontosearch();
    	Thread.sleep(4000);
    	//search.sortBy();
    	//Thread.sleep(4000);
    	//search.option();
    	
	}
	@Test
	public void verifywhennosearchitemisgiven() throws InterruptedException {
		regUserSearchPage search = new regUserSearchPage(driver);
		driver.findElement(By.cssSelector("#filter_keyword")).clear();
    	search.clickSearchToType();
    	search.typeItemToBeSearched("");
    	search.clicksearchicontosearch();
	}
	@AfterTest
	public void teardown()
	{
		 driver.quit();
	}
	
}
























//normal
//user search
//page: regUserSearchPage.java




































	
	/*
	@BeforeTest
	public void initdriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	search = new UserSearchPage(driver);
    	driver.get("http://retailm1.upskills.in/account/login");
	}*/
	
	/*@Test
	public void when_search_Item_is_Given() throws InterruptedException {
		search.SearchItem("naijajain1999@gmail.com", "12345678", "automation");
		Thread.sleep(4000);
	}
    @Test
	public void when_No_search_Item_is_Given() {
		search.SearchItem("naijajain1999@gmail.com", "12345678", "");
	}*/
	
    	//search.typeItemToBeSearched();
    
    	//search.clicksearchicontosearch();
    	//System.out.println("Success");
		
	//}
	//public void whenNosearchitemisgiven() {
		//search.typeItemToBeSearched();
		
	

/*search.typeUserName();
search.typePassword();
search.clickLoginButton();
search.clickSearchToType();
search.typeItemToBeSearched();
search.clicksearchicontosearch();*/

/*search.typeemail("naijajain1999@gmail.com");
search.typePassword("12345678");
search.clickLoginButton();*/
/*<parameter name="p_username" value="naijajain1999@gmail.com"/>
    <parameter name="p_password" value="12345678"/>*/
