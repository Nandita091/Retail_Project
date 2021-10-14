package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import pages.ReviewPage;

public class DeleteReview {
	static String driverPath = "C:\\Users\\Padma\\Desktop\\";
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void verifylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver.get("http://retailm1.upskills.in/admin/index.php?route=catalog/review&token=qTYnJTng6kx6cnkkMyo0BtcKtLpgVzXn");
		driver.manage().window().maximize();
		AdminLoginPage login = new AdminLoginPage(driver);
		login.typeusername("admin");
		login.typepassword("admin@123");
		login.clickLoginButton();
		
	}	
	
	@Test
	public void deletereviewbyselecting() {
		ReviewPage review = new ReviewPage(driver);
		review.checkboxSelect();
		review.deleteReview();
		driver.switchTo().alert().accept();
		Assert.assertEquals(true,ReviewPage.successfulReviewDeletion());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
