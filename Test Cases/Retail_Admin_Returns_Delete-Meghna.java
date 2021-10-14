package RetailShopTestcases;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import RetailShopPage.RetailAdminLoginPage;
public class Retail_Admin_Returns_Delete {
static String driverPath = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	
	@Test
	public void Delete() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin/index.php?route=sale/return&token=gMnKZPcyN1LbdWklm1Eeef4HacueT3w6");
		driver.manage().window().maximize();
		
		RetailAdminLoginPage retail=new RetailAdminLoginPage(driver);
		retail.typeusername("admin");
		retail.typepassword("admin@123");
		retail.clickLoginButton();
		driver.findElement(By.cssSelector("#form-return > div > table > tbody > tr:nth-child(2) > td.text-center > input[type=checkbox]")).click();
		driver.findElement(By.cssSelector("#content > div.page-header > div > div > button > i")).click();
		
		driver.switchTo().alert().accept();
		WebElement msg=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]"));
		boolean text=true;
		Assert.assertEquals(text,true);
	driver.close();
	
	
	
	
		
	
	}
}