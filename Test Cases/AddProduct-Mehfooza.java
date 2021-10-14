
package retailTestcases;

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
import retailPage.Uslogin;
import retailPage.retailAdminProduct;

public class AddProduct {
	WebDriver driver;
	static retailAdminProduct RETdminlogin; 
	

	String xlFilePath = "Book2.xlsx";
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

	@BeforeClass
	public void initdriver()
	{
		driver=Driver.startBrowser("chrome", "http://retailm1.upskills.in/admin/index.php?route=catalog/product&token=GZ9t9SSlr5HETdCieWZGX4bm7CWYvgSu");
		RETdminlogin=new retailAdminProduct(driver);
    	
    	
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
	
	Assert.assertEquals(curTitle, "Administration");
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
	Assert.assertEquals(isloginsuccess, true);
	
}
@Test(dataProvider = "userData",priority=4)
public void Add(String Pname,String MetaTag,String Model,String Price,String Qty)

{
	
	boolean Addsuccess=RETdminlogin.AddProduct(Pname,MetaTag,Model,Price,Qty);
	Assert.assertEquals(Addsuccess, true);
}

}
