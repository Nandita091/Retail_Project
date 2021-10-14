package retailpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import retailpages.couponsEdits;

public class EditConfirm {static WebDriver driver;
static loginpage1 RETdminlogin; 
static couponsDelete DeleteCoupon;
static couponsAdd AddCoupon;
static couponsEdits EditCoupon;
protected  String testUrl = "http://retailm1.upskills.in/admin/index.php?route=marketing/coupon&token=By3VQXuTEP37VLs9NLaTihzXFQRYnOOC";
	@BeforeTest
	public void inthedriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\Documents\\\\chromed\\\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://retailm1.upskills.in/admin/index.php?route=marketing/coupon&token=jIoEtbLLlBtP11AeBsByTlhhQH88seRu");
    	driver.manage().window().maximize();
    	loginpage1 login = new loginpage1(driver);
		login.Login();
		
	}
	@AfterTest
	public void teardown()
	{
		 driver.quit();
	}
  @Test
  public void save_edit() {
	couponsEdits c=new couponsEdits(driver);
	c.Addnew();
	c.typeCouponName("abcefd");
	c.typeCode("1115");
	c.typeDiscount("12");
	c.typeTotalAmt("11");
	c.clickSaveButton();
	c.successfulEdit();
  }
}
