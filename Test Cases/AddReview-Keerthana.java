package testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.TestUtil;
import pages.AdminLoginPage;
import Util.TakeScreenShot;
import pages.AddReviewPage;
public class AddReview {
	static String driverPath = "C:\\Users\\Padma\\Desktop\\";
	WebDriver driver = new ChromeDriver();
	public TakeScreenShot shot; 
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
	@DataProvider
	public Object[][] getReviewData() throws InvalidFormatException {
		Object data[][] =TestUtil.getTestData("AddReview"); 
		return data;
	}
	@Test(dataProvider="getReviewData")
	public void addnewReview(String AuthorName,String Product,String text,String dateAdded) throws InterruptedException {
		AddReviewPage review=new AddReviewPage(driver);
		try {
		review.clickAddButton();
		review.addAuthorName(AuthorName);
		review.addProductName(Product);
		Thread.sleep(1000);
		review.selectPredicted();
		review.addText(text);
		review.rating();
		review.dateAdded(dateAdded);
		review.status();
		review.clickSave();
		Assert.assertEquals(true,AddReviewPage.successfulReviewAddition());
		
	}catch(NoSuchElementException e) {
		System.out.println("Failure");
		shot=new TakeScreenShot(driver);
		String Screenshot=shot.screenshot();
		shot.takeSnapShot(driver, Screenshot);
	}
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}