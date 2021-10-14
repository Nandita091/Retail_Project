package testcases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.AdminLoginPage;

public class AdminLogin {
	static String driverPath = "C:\\Users\\Padma\\Desktop\\";
	@Test
	public void verifylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://retailm1.upskills.in/admin/index.php?route=report/product_viewed&token=a5DQjiRumhweovL1a59l0yRXo3jncSKW");
		driver.manage().window().maximize();
		
		AdminLoginPage login = new AdminLoginPage(driver);
		
		login.typeusername("admin");
		login.typepassword("admin@123");
		login.clickLoginButton();
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\Padma\\eclipse-workspace\\Retailupskills\\Products viewed.xlsx");
		
		if(!reader.isSheetExist("Products Viewed")){
		reader.addSheet("Products Viewed");
		reader.addColumn("Products Viewed","Product Name");
		reader.addColumn("Products Viewed","Model");
		reader.addColumn("Products Viewed","Viewed");
		reader.addColumn("Products Viewed","Percentage");
				}
		
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[1]
		
		String beforeXpath_pname="//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/table/tbody/tr[";
		String afterXpath_pname="]/td[1]";
		
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[2]
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]
		
		String beforeXpath_model="//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/table/tbody/tr[";
		String afterXpath_model="]/td[2]";
		
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[3]
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[3]
		
		String beforeXpath_viewed="//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/table/tbody/tr[";
		String afterXpath_viewed="]/td[3]";
		
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[4]
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[4]
				
		String beforeXpath_per="//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/table/tbody/tr[";
		String afterXpath_per="]/td[4]";
		
		List<WebElement> rows=driver.findElements(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/table//tr"));
		//*[@id="content"]/div[2]/div/div[2]/div[1]/table
		
		int rowCount= rows.size();
		System.out.println(rowCount);
		
		
		
		for(int i=1;i<rowCount;i++) {
			String actualXpath_pname=beforeXpath_pname+i+afterXpath_pname;
			String ProductName=driver.findElement(By.xpath(actualXpath_pname)).getText();
			System.out.println(ProductName);
			reader.setCellData("Products viewed","Product Name",(i+1),ProductName);
			
			String actualXpath_model=beforeXpath_model+i+afterXpath_model;
			String Model=driver.findElement(By.xpath(actualXpath_model)).getText();
			System.out.println(Model);
			reader.setCellData("Products viewed","Model",(i+1),Model);
			
			String actualXpath_viewed=beforeXpath_viewed+i+afterXpath_viewed;
			String Viewed=driver.findElement(By.xpath(actualXpath_viewed)).getText();
			System.out.println(Viewed);
			reader.setCellData("Products viewed","Viewed",(i+1),Viewed);
			
			String actualXpath_per=beforeXpath_per+i+afterXpath_per;
			String Percentage=driver.findElement(By.xpath(actualXpath_per)).getText();
			System.out.println(Percentage);
			reader.setCellData("Products viewed","Percentage",(i+1),Percentage);
			
		}
	}
	
}
