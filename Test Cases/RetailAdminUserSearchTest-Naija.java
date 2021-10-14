package retail.test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import retail.pages.RetailAdminCustomerSearch;

import retail.pages.RetailUserSearchPage;

import retail.util.TestUtil;
import retail.util.Utiltest;

public class RetailAdminUserSearchTest {

	static String driverPath = "E:\\chrome\\drive\\";
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void initdriver()
	{
	
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		
		driver.get("http://retailm1.upskills.in/");
		driver.manage().window().maximize();
	}
	@DataProvider
	public Object[][] getSearchItem() throws InvalidFormatException {
		Object data[][] = Utiltest.getTestData("GuestSearch"); 
		return data;
	}
	@Test(dataProvider="getSearchItem")
	public void searchedItem(String guestsearchitem) throws InterruptedException {
		RetailUserSearchPage search = new RetailUserSearchPage(driver);
		search.clicksearchicontotype();
    	search.typeItemToBeSearched(guestsearchitem);
    	Thread.sleep(4000);
    	search.clicksearchicontosearch();
    	driver.quit();
	
	}
	
	@Test
	public void verifyadmin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chrome\\drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	RetailAdminCustomerSearch find = new RetailAdminCustomerSearch(driver);
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
			//Scrshot=new TakeScreenShot(driver);
			//String Screenshot=Scrshot.Screenshot();
			//shot.takeSnapShot(driver, Screenshot);
			
		}
    	
    	driver.quit();
    	
		
	}
	
}




//guest searching item checking in admin end using dataprovider excel
//page: RetailAdminCustomerSearch.java   RetailUserSearchPage.java