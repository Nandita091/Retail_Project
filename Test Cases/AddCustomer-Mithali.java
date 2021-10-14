package retailTests;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Driver;
import util.ExcelApiTest;
import RetailPages.AddAcust;
import RetailPages.PageCustmoer;
import RetailPages.retailAdminLoginPage;


@SuppressWarnings("unused")
public class AddCustomer {
	WebDriver driver;
	static retailAdminLoginPage RETdminlogin; 
	static AddAcust addcust;
	static PageCustmoer addsing;	
	
	String xlFilePath = "G:\\CG TRAINING\\retail\\For execution\\Book1.xlsx";
    String sheetName = "Add";
    ExcelApiTest eat = null;
    
	@DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }

	  public Object[][] testData(String xlFilePath, String sheetName) throws Exception
	    {
	        Object[][] excelData = null;
	        eat = new ExcelApiTest(xlFilePath);
	        int rows = eat.getRowCount(sheetName);
	        int columns = eat.getColumnCount(sheetName);
	                 
	        excelData = new Object[rows-1][columns];
	         
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=0; j<columns; j++)
	            {
	                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
	            }
	             
	        }
	        return excelData;
	    }


		@BeforeTest
		public void initdriver()
		{
			driver=Driver.startBrowser("chrome", "http://retailm1.upskills.in/admin/index.php?route=customer/customer/add&token=kXCS3Gi1UICqPC8zGmUC6rjc6VZj0n7E");
			RETdminlogin=new retailAdminLoginPage(driver);
			addcust=new AddAcust(driver);
			addsing=new PageCustmoer(driver);
				
			
		}
		
		@AfterTest
		public void teardown()
		{
			 driver.quit();
		}
		

		@Test(priority=1)
		public void login() {
		    // Write code here that turns the phrase above into concrete actions
			
			RETdminlogin.AdminLogin("admin","admin@123");
			addsing.Plusfun();
					}

		@Test(dataProvider = "userData",priority=2)
		public void Add(String Fname, String Lname, String Ce, String ph, String Fx, String pwd, String cpwd)

		{
			
			boolean Addsuccess=addcust.AddCustomer(Fname,Lname,Ce,ph,Fx,pwd,cpwd);
			Assert.assertEquals(Addsuccess, true);
		}


	

}
