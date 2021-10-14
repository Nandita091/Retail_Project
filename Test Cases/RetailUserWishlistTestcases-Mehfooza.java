package retailTestcases;





import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import Util.Driver;
import retailPage.RetailUserWishlistPages;
import retailPage.retailAdminProduct;



public class RetailUserWishlistTestcases {
	static WebDriver driver;
	static RetailUserWishlistPages RETwish;
	@DataProvider(name="Auth")
	public static Object[][] credentials()
	{	
	return new Object[][] {{"mahfooza701@gmail.com","Mahfooza1"}};	
	}

	@BeforeClass
	public void initdriver()
	{
		driver=Driver.startBrowser("chrome", "http://retailm1.upskills.in/account/login");
		RETwish=new RetailUserWishlistPages(driver);
		
    	
	}
	@AfterClass
	public void teardown()
	{
		 driver.quit();
	}

	@Test(dataProvider="Auth")
	public void loginmethod(String sUsername,String sPassword)
	{
    // Write code here that turns the phrase above into concrete actions
		RETwish.UserLogin(sUsername,sPassword);
}

@Test(priority=2)
public void wishlistProduct() {
    // Write code here that turns the phrase above into concrete actions

	
	boolean check=RETwish.wishlistProduct();
	
	Assert.assertEquals(check, true);
}

@Test(priority=3)
public void delete()
{
	RETwish.RemoveItemFromWishList();
}
	
}
