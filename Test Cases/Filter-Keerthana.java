package testcases;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.TestUtil;
import pages.AdminLoginPage;
import pages.ReviewPage;

public class Filter {
	static String driverPath = "C:\\Users\\Padma\\Desktop\\";
	WebDriver driver = new ChromeDriver();
	@BeforeTest
	public void verifylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		
		driver.get("http://retailm1.upskills.in/admin/index.php?route=catalog/review&token=xWHvu7pMIwsXH0irDu5wkbJQQg68uWYR");
		driver.manage().window().maximize();
		
		AdminLoginPage login = new AdminLoginPage(driver);
		
		login.typeusername("admin");
		login.typepassword("admin@123");
		login.clickLoginButton();
	}
	@DataProvider
	public Object[][] getReviewData() throws InvalidFormatException {
		Object data[][] =TestUtil.getTestData("filterData"); 
		return data;
	}
	@Test(dataProvider="getReviewData",priority=1)
	public void VerifyFilter(String ProductName,String AuthorName,String DateAdded ) {
		
		ReviewPage review=new ReviewPage(driver);
		StringBuffer product=new StringBuffer(ProductName);
		review.typeProductname(product);
		review.selectStatus();
		review.typeAuthorName(AuthorName);
		review.typeDateAdded(DateAdded);
		review.clickFilterButton();	
		
		
		
		try {
			WebElement TableData=driver.findElement(ReviewPage.ProductName);
			String assertData=TableData.getText();
			//assertData=Ring
			 StringBuffer datamatch=new StringBuffer(assertData);
			//datamatch=ring
			if(datamatch.substring(0,0).equals(product.substring(0,0))) {
				System.out.println("Matching name found " +datamatch+" is passed " +product+" is obtained");
			}
		}
		catch(NoSuchElementException e){
			System.out.println("Not found");
		}
		review.clearProductName();
		review.clearAuthor();
		review.cleardateAdded();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
