package retail.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.appname.pages.REAdminLoginPage;
import retail.pages.AdminCustomerSearch;
import retail.pages.GuestSearchPage;

public class RetailUserSearchTest1 {
	static WebDriver driver;
	static GuestSearchPage search;
	
	@Test
	public void initdriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	search = new GuestSearchPage(driver);
    	driver.get("http://retailm1.upskills.in/");
    	search.clicksearchicontotype();
    	search.typeItemToBeSearched();
    	search.clicksearchicontosearch();
    	
	
		 driver.quit();
	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}




	@Test
	public void verifyadmin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	AdminCustomerSearch find = new AdminCustomerSearch(driver);
    	driver.get("http://retailm1.upskills.in/admin/index.php?route=common/dashboard&token=KEuO9vrvK99JHEetlGtw9f3jN8yq9aTE");
    	find.typeUsername();
    	find.typePassword();
    	find.clickLoginButton();
    	find.clickGraph();
    	find.clickCustomer();
    	find.clickCustomerSearches();
    	//find.startdate();
    	//find.enddate();
    	find.typeKeyword();
    	//find.customer();
    	//find.Ipaddress();
    	Thread.sleep(4000);
    	find.clickFilter();
    	Thread.sleep(4000);
    	
    	//driver.quit();
    	StringBuffer product=new StringBuffer("Laptop");
    	By ProductName=By.xpath("//*[@id='content']/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]");
    	//StringBuffer product=new StringBuffer("Bottle");
    	//By ProductName=By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[1]");
    	
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
	
}






















//normal
//guest searching item
//page: GuestSearchPage.java AdminCustomerSearch.java





































/*
public class RetailAdminCustomerSearch {

	
	WebDriver driver1;
	RetailAdminCustomerSearch find;
	

	public RetailAdminCustomerSearch(WebDriver driver1) {
		// TODO Auto-generated constructor stub
	}
	private void clickFilter() {
		// TODO Auto-generated method stub
		
	}


	private void typeKeyword() {
		// TODO Auto-generated method stub
		
	}


	private void clickCustomerSearches() {
		// TODO Auto-generated method stub
		
	}


	private void clickCustomer() {
		// TODO Auto-generated method stub
		
	}


	private void clickGraph() {
		// TODO Auto-generated method stub
		
	}


	private void clickLoginButton() {
		// TODO Auto-generated method stub
		
	}


	private void typePassword() {
		// TODO Auto-generated method stub
		
	}


	private void typeUsername() {
		// TODO Auto-generated method stub
		
	}
	
	*/
	
/*
@Test
public void verifyloginadmin() {
	
	
	//RetailAdminCustomerSearch find = new RetailAdminCustomerSearch(driver1);
	System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//find = new RetailUserSearchPage(driver);
	driver.get("http://retailm1.upskills.in/admin/");
	
	RetailAdminCustomerSearch login = new RetailAdminCustomerSearch(driver);
	//boolean success=login.AdminLogin("admin", "admin@123");
	//Assert.assertEquals(success, true);
	login.typeUsername();
	login.typePassword();
	login.clickLoginButton();
	
	
	
}*/
/*@Test
public void verifysearcheditem() throws InterruptedException {
	RetailAdminCustomerSearch find = new RetailAdminCustomerSearch(driver);
	find.clickGraph();
	find.clickCustomer();
	find.clickCustomerSearches();
	find.typeKeyword();
	Thread.sleep(4000);
	find.clickFilter();
	Thread.sleep(4000);
	
}*/
