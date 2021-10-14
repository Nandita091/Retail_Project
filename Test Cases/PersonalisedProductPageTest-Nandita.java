package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddToCartPages;

public class PersonalisedProductPageTest {

	String exePath = "C:\\Users\\nitu2\\Downloads\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
//	AddToCartPages obj;
	
	@AfterTest
	public void closeAll() {
		driver.quit();
	}
	
	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		
		driver.get("http://retailm1.upskills.in/Engagement%20Rings");
		driver.manage().window().maximize();
	}
	
	//click on bestSeller product-ring
//	@Test(priority=2)
//	public void clickOnBestSellerProduct() {
//		
//		AddToCartPages obj = new AddToCartPages(driver); 
//		obj.addToCartProduct();
//	}
//	
//	//user logging in using credentials
//	@Test(priority=1)
//	public void user_enters_correct_and_and_clicks_login() {
//	    // Write code here that turns the phrase above into concrete actions
//		AddToCartPages obj = new AddToCartPages(driver); 
//
//		obj.UserLogin("mailtonandita09@gmail.com","nandita199811");
//	}
	
	//click on addToCart button to add item in cart
	@Test(priority=3)
	public void clickAddToProductButton() {
		
		AddToCartPages obj = new AddToCartPages(driver); 

		obj = new AddToCartPages(driver);
		obj.clickAddToCartButton();
	}

}
