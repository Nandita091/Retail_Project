package retail.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import retail.pages.AdminCustomerSearch;
import retail.pages.GuestSearchPage;
import retail.pages.SearchItemInAdmin;
import retail.pages.SearchItemUser;

public class SearchingItemTest {
	
	static WebDriver driver;
	static SearchItemUser search;
	
	@Test
	public void initdriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	search = new SearchItemUser(driver);
    	driver.get("http://retailm1.upskills.in/account/login");
    	search.typeUserName();
    	search.typePassword();
    	search.clickLoginButton();
    	search.clicksearchicontotype();
    	search.typeItemToBeSearched();
    	search.clicksearchicontosearch();
    	
	
		 driver.quit();
	
	}
	@Test
	public void verifyloginadmin() throws InterruptedException {
		
		
		//RetailAdminCustomerSearch find = new RetailAdminCustomerSearch(driver1);
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	//find = new RetailUserSearchPage(driver);
    	driver.get("http://retailm1.upskills.in/admin/");
    	
    	SearchItemInAdmin find = new SearchItemInAdmin(driver);
		//boolean success=login.AdminLogin("admin", "admin@123");
		//Assert.assertEquals(success, true);
    	find.typeUsername();
    	find.typePassword();
    	find.clickLoginButton();
    	find.clickGraph();
    	find.clickCustomer();
    	find.clickCustomerSearches();
    	find.typeKeyword();
    	Thread.sleep(4000);
    	find.clickFilter();
    	Thread.sleep(4000);
    	
    	//driver.quit();
    	StringBuffer product=new StringBuffer("Laptop");
    	By ProductName=By.xpath("//*[@id='content']/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]");
		//WebElement ProductName=driver.findElement(By.xpath("//*[@id=\"form-review\"]/div/table/tbody/tr/td[2]")).getText();
		try {
			WebElement TableData=driver.findElement(ProductName);
			////*[@id="form-review"]/div/table/tbody/tr/td[2]
			String assertData=TableData.getText();
			//assertData=Ring
			StringBuffer datamatch=new StringBuffer(assertData);
			//datamatch=ring
			if(datamatch.substring(0,0).equals(product.substring(0,0))) {
				System.out.println("Matching name found " + datamatch +" is passed  " +  product +" is obtained");
			}
		}
		catch(NoSuchElementException e){
			System.out.println("Not found");
		}
    	
    	driver.quit();
    	
		
		
	}
	/*@Test
	public void verifysearcheditem() throws InterruptedException {
		SearchItemInAdmin find = new SearchItemInAdmin(driver);
		find.clickGraph();
		find.clickCustomer();
		find.clickCustomerSearches();
		find.typeKeyword();
		Thread.sleep(4000);
		find.clickFilter();
		Thread.sleep(4000);
		
	}*/
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}


}
//registered user search for item and verifying in Admin End
//page: SearchItemUser.java SearchItemInAdmin.java
//normal