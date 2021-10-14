package test;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pages.UpdateAndDeleteProductPage;

public class UpdateAndDeleteProductTest {

	static WebDriver driver;
//	static UpdateAndDeleteProduct obj;
	
	@BeforeTest
	public void initdriver() {
		
		String exePath = "C:\\Users\\nitu2\\Downloads\\chromedriver_win32\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://retailm1.upskills.in/account/login");
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void userLoginCred() {
		UpdateAndDeleteProductPage obj = new UpdateAndDeleteProductPage(driver);
		obj.userLogin("mailtonandita09@gmail.com","nandita199811");

		obj.SignIn();
	}
	
	@Test(priority=2)
	public void clickCartIcon() {
		UpdateAndDeleteProductPage obj = new UpdateAndDeleteProductPage(driver);

		obj.clickCartIcon();
	}
	
	@Test(priority=3)
	public void updateProductQuantity() {
		UpdateAndDeleteProductPage obj = new UpdateAndDeleteProductPage(driver);

		obj.updateProduct(3);
	}
	
	@Test(priority=4)
	public void deleteCartProduct() {
		UpdateAndDeleteProductPage obj = new UpdateAndDeleteProductPage(driver);

		obj.deleteProduct();
	}
	
}
