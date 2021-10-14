package testCases;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generalFunctionalities.ExcelApiTest;
import pageClasses.UserRegistrationPage;

public class verifyUserRegistration {
	public WebDriver driver;
	public WebDriverWait wait;
	String xlFilePath = "d:\\UserRegisterData.xlsx";
    String sheetName = "Sheet1";
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
	public void dofirst()
	{
		String exePath="C:\\Users\\User\\eclipse-workspace\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",exePath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, 5);
		driver.get("http://retailm1.upskills.in");
	
	}

	


    @Test(dataProvider="userData")
	public void VerifyRegister(String firstname,String lastname,String email,String telephone,
		 String address1,String address2,String city,String zipcode,String password,String cpassword) throws InterruptedException {
		
	    UserRegistrationPage register=new UserRegistrationPage(driver);
	    boolean regsiterSuccess=register.verifyRegistration(firstname,lastname,email,telephone,
	   		 address1,address2,city,zipcode, password, cpassword);
		Assert.assertEquals(regsiterSuccess, true);
		
		
	} 
	
}