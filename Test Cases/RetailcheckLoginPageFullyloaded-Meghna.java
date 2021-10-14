package RetailShopTestcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import RetailShopPage.RetailLoginPage;

public class RetailcheckLoginPageFullyloaded {
	static String driverPath = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
    static WebDriver driver;	
	
@AfterTest
public void closeAll()
{
	driver.close();
}
    
    
    @BeforeTest
    public void init()
    {
    	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/account/login");
		driver.manage().window().maximize();
	
		
    }
	@Test 
	public void checkPageLoaded()
	{
		RetailLoginPage login=new RetailLoginPage(driver);
		
		String footertext=login.getFooterString();
		
		System.out.println(footertext);
		
		boolean isTextcontainedinfooter = footertext.contains("Copyright");
		
		Assert.assertEquals(isTextcontainedinfooter,true );
		
	
	}
	@Test 
	public void isFooterFound()
	{
		RetailLoginPage login=new RetailLoginPage(driver);
		boolean isFooter=login.isFooterFound();
		
		if(isFooter == true) {
			System.out.println("Found Footer");
		}
		else {
			System.out.println("Page not loaded fully");
		}
		Assert.assertEquals(isFooter,true);
	}
	
	}


