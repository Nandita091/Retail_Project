package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import utils.TakeScreenShot;

public class AdminLoginTest {
	
	static String exePath = "C:\\Users\\nitu2\\Downloads\\chromedriver_win32\\chromedriver.exe";
	static WebDriver driver;
	static TakeScreenShot shot;
	
	
	@AfterTest
	public void closeAll() {
		driver.quit();
	}
	
	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void checkFooterContent() {
		
		AdminLoginPage login = new AdminLoginPage(driver);

		
		String footerText = login.getFooterString();
		boolean isTextContainedInFooter = footerText.contains("All Rights Reserved");
		Assert.assertEquals(isTextContainedInFooter, true);
	}
	
	@Test (priority=2)
	public void login() {
		
		AdminLoginPage login = new AdminLoginPage(driver);

		login.typeUsername("admin");
		login.typePassword("admin@123");
	}
	
	@Test(priority=3)
	public void signIn() {
		AdminLoginPage login = new AdminLoginPage(driver);
		
		login.clickLoginButton();
		
		
		//Screen shot code
		shot=new TakeScreenShot(driver);
		String Screenshot=shot.screenshot();
		shot.takeSnapShot(driver, Screenshot);
		String from_to = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")).getText();
		System.out.println("========Details of Searched Keyword/product are========");
        System.out.println(from_to);
        System.out.println("The product searched by the User matches the product displayed at the Admin Page of Customer Searches Report!! ");
        Reporter.log("The Item/Product searched by the customer at the Home Page of application matches the product displayed at the Admin Customer Searches Report.");
	}
	
	@Test(priority=4)
	public void checkDashboard() {
		
		AdminLoginPage login = new AdminLoginPage(driver);

		
		String dashboardText = login.getLoginStatus();
		boolean isTextContainedInDashboard = dashboardText.contains("board");

		Assert.assertEquals(isTextContainedInDashboard, true);
	}
}
