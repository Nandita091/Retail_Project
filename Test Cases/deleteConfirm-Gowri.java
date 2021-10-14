package retailpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import retailpages.couponsDelete;

import retailpages.loginpage1;



public class deleteConfirm {
	static WebDriver driver;
	static loginpage1 RETdminlogin; 
	static couponsDelete DeleteCoupon;


@Test(priority=1)
public void delete_a_coupon()
{
	
	
	DeleteCoupon=new couponsDelete(driver);
	System.setProperty ("webdriver.chrome.driver","C:\\Users\\User\\Documents\\chromed\\chromedriver.exe" );
    WebDriver driver = new ChromeDriver(); 
	
	driver.get("http://retailm1.upskills.in/admin/index.php?route=marketing/coupon&token=jIoEtbLLlBtP11AeBsByTlhhQH88seRu");
	driver.manage().window().maximize();
	loginpage1 login = new loginpage1(driver);
	login.Login();
	couponsDelete d=new couponsDelete(driver);
	d.clickcheckbox();
	
	d.clickdeletebutton();
	driver.switchTo().alert().accept();
	d.displaymsg();
	d.successfuldeletion();
	
	
		}	

	
	

}








	
	

