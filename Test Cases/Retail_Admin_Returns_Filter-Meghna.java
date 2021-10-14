package RetailShopTestcases;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import RetailShopPage.RetailAdminLoginPage;
import Util.TakeScreenShot;
public class Retail_Admin_Returns_Filter {
	static String driverPath = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	final String order_id="123"; 
	
	@Test
	public void FilterByOrderIDTest() {
		boolean filterSuccess=false;
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin/index.php?route=sale/return&token=gMnKZPcyN1LbdWklm1Eeef4HacueT3w6");
		driver.manage().window().maximize();
		
		RetailShopPage.RetailAdminLoginPage retail=new RetailShopPage.RetailAdminLoginPage(driver);
		
		retail.typeusername("admin");
		retail.typepassword("admin@123");
		retail.clickLoginButton();
		
		RetailShopPage.RetailAdminProductReturnsPage search=new RetailShopPage.RetailAdminProductReturnsPage(driver);
		filterSuccess=search.searchByOrderID(order_id);
		
		//compare return id
		//StringBuffer oid=new StringBuffer("123");
//		driver.findElement(By.id("input-order-id")).sendKeys(order_id);

		driver.findElement(By.id("button-filter")).click();
		
		Assert.assertEquals(filterSuccess,true);
		//driver.close();
		
	}
}		
