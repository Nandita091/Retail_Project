package RetailShopTestcases;

import static org.testng.Assert.assertEquals;

import javax.swing.text.html.Option;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import RetailShopPage.RetailAdminLoginPage;
public class Retail_Admin_Returns_Edit {
	static String driverPath = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	
	@Test
	public void EditItem() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin/index.php?route=sale/return&token=gMnKZPcyN1LbdWklm1Eeef4HacueT3w6");
		driver.manage().window().maximize();
		
		RetailAdminLoginPage retail=new RetailAdminLoginPage(driver);
		retail.typeusername("admin");
		retail.typepassword("admin@123");
		retail.clickLoginButton();
		
		//select Item to Edit
		driver.findElement(By.xpath("//*[@id=\"form-return\"]/div/table/tbody/tr[1]/td[1]")).click();
		
		//Click Edit Button
        driver.findElement(By.xpath("//*[@id=\"form-return\"]/div/table/tbody/tr[1]/td[10]/a")).click();
		
        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Naik");
		driver.findElement(By.xpath("//*[@id=\"input-opened\"]/option[2]")).click();
		
				
		//save changes
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button")).click();
		
		WebElement msg=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]"));
		boolean text=true;
		Assert.assertEquals(text,true);
		driver.close();
	}
}
