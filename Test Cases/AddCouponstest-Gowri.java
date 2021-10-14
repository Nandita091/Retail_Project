package retailpages;

import org.testng.annotations.Test;
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

import Util.Driver;
import Util.ExcelApiTest;
import retailpages.AddCoupon;
//import retailpages.PageCustmoer;
import retailpages.loginpage1;


@SuppressWarnings("unused")
public class AddCouponstest {
	WebDriver driver;
	static AddCoupon addcoupon;	
	
	String xlFilePath = "C:\\Users\\User\\eclipse-workspace\\Retail\\src\\main\\java\\testdata\\coupons.xlsx";
    String sheetName = "abc";
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
			driver=Driver.startBrowser("chrome", "http://retailm1.upskills.in/admin/index.php?route=marketing/coupon&token=jIoEtbLLlBtP11AeBsByTlhhQH88seRu");
			addcoupon =new AddCoupon(driver);
			loginpage1 login = new loginpage1(driver);
			login.Login();
			
		}
		
		
		@AfterTest
		public void teardown()
		{
			 driver.quit();
		}
		

		

		@Test(dataProvider = "userData",priority=1)
		public void Add(String couponname, String couponcode, String discount, String Amt)

		{
			
			boolean Addsuccess=addcoupon.AddCoupons(couponname,couponcode,discount,Amt);
			Assert.assertEquals(Addsuccess, true);
		}


	

}
