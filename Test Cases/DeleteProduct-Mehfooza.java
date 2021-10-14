package retailTestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.Driver;
import Util.ExcelApiTest;
import retailPage.retailAdminProduct;

public class DeleteProduct {
	WebDriver driver;
	static retailAdminProduct RETdminlogin; 
	static Driver driverobj;
	String xlFilePath = "Book2.xlsx";
    String sheetName = "Delete";
    ExcelApiTest eat = null;
	@DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }
     
    @Test
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
	@BeforeClass
	public void initdriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver_win32\\chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	RETdminlogin=new retailAdminProduct(driver);
    	driver.get("http://retailm1.upskills.in/admin/index.php?route=catalog/product&token=GZ9t9SSlr5HETdCieWZGX4bm7CWYvgSu");
    	//driver.get("http://uniformm1.upskills.in/admin/index.php?route=sale/order&filter_order_status=5%2C1%2C2%2C12%2C3&token=9WjiKUWAK0fhz0nqypDrXk5NFKaCOg7k");
    	
	}
	@AfterClass
	public void teardown()
	{
		 driver.quit();
	}
	
	
@Test(priority=1)
public void user_is_on_admin_login_page() {
    // Write code here that turns the phrase above into concrete actions

	
	String curTitle = RETdminlogin.getUSLoginTitle(driver);
	
	AssertJUnit.assertEquals(curTitle, "Administration");
}

@Test(priority=2)
public void user_enters_correct_and_and_clicks_login() {
    // Write code here that turns the phrase above into concrete actions
	
	RETdminlogin.AdminLogin("admin","admin@123");
}





@Test(priority=3)
public void admin_homepage_should_be_loaded_successfully() {
    // Write code here that turns the phrase above into concrete actions

	boolean isloginsuccess=RETdminlogin.isHeaderFound();
	AssertJUnit.assertEquals(isloginsuccess, true);
	
}
@Test(dataProvider = "userData",priority=4)
public void Delete(String Pname)

{
	
	boolean Deletesuccess=RETdminlogin.DeleteProduct(Pname);
	AssertJUnit.assertEquals(Deletesuccess, true);
}

}
