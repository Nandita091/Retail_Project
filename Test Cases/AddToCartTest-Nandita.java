package test;


import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pages.AddToCartPages;



public class AddToCartTest {
	
	WebDriver driver;
	AddToCartPages obj;
	

	@BeforeClass
	public void initdriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nitu2\\Downloads\\chromedriver_win32\\chromedriver.exe");
    
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

    	obj=new AddToCartPages(driver);
    	
    	driver.get("http://retailm1.upskills.in/account/login");
    	
	}
	@AfterTest
	public void teardown()
	{
		 driver.quit();
	}

	
	@Test(priority=1)
	public void user_enters_correct_and_and_clicks_login() {
	    // Write code here that turns the phrase above into concrete actions
		
		obj.UserLogin("mailtonandita09@gmail.com","nandita199811");
		
	}
	

	@Test(priority=2)
	public void clickOnBestSellerProduct() {
		
		obj.addToCartProduct();
		
	}
	
}
