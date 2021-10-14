package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pages.UserLoginPage;
import utils.ExcelAPITest;

public class UserLoginTest {
	
	//Chrome initialization
	static String exePath = "C:\\Users\\nitu2\\Downloads\\chromedriver_win32\\chromedriver.exe";
	static WebDriver driver;
	
	//Excel intialization
	String excelPath = "C:\\Users\\nitu2\\eclipse-workspace\\RetailWebsiteTesting\\src\\main\\java\\utils\\ExcelUtils.java";
	String sheetName = "sheet1";
	
	@AfterTest
	public void closeAll() {
		driver.quit();
	}
	
	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/account/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void checkFooterContent() {
		UserLoginPage login = new UserLoginPage(driver);
		
		String footerText = login.getFooterString();
		boolean isTextContainedInFooter = footerText.contains("All Rights Reserved");
		Assert.assertEquals(isTextContainedInFooter, true);
	}
	
	@Test(priority=2)
	public void enterUsername() {
		UserLoginPage login = new UserLoginPage(driver);
		ExcelAPITest excel = new ExcelAPITest(excelPath, sheetName);
		login.typeUsernamePassword(excel.getUsername(1, 0), excel.getPassword(1, 1));
	}
	
	@Test(priority=3)
	public void signIn() {
		UserLoginPage login = new UserLoginPage(driver);
		login.clickSignIn();
	}

}
