package retailpages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import retailpages.couponsAdd;



public class returnsReportTest {
	static WebDriver driver;
	static loginpage1 RETdminlogin; 
	static couponsDelete DeleteCoupon;
	static couponsAdd AddCoupon;
	static returnsReport RReport;
	protected  String testUrl = "http://retailm1.upskills.in/admin/index.php?route=marketing/coupon&token=By3VQXuTEP37VLs9NLaTihzXFQRYnOOC";

	@BeforeTest
	public void inthedriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\User\\\\Documents\\\\chromed\\\\chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://retailm1.upskills.in/admin/index.php?route=report/sale_return&token=pfknFAtTIhxKacy0liZpPmgL8AvpPikR");
    	driver.manage().window().maximize();
    	loginpage1 login = new loginpage1(driver);
		login.Login();
		
	}
	@AfterTest
	public void teardown()
	{
		 driver.quit();
	}



@Test(priority=1)
public void filter_by_parameter()
{
	
	returnsReport r=new returnsReport(driver);
	r.typedatestart("10/07/2021");
	r.typedateend("11/07/2021");
	r.clickfilterButton();
	r.typedatestartc();
	r.typedateendc();
	System.out.println("Filtered returns");
	
}
@Test(priority=2)
public void one_parameter_missing()
{

	returnsReport r=new returnsReport(driver);
	r.typedatestart("");
	r.typedateend("12/07/2021");
	r.clickfilterButton();
	
}

}
