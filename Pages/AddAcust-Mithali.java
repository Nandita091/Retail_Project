package RetailPages;


	import org.testng.annotations.Test;

	import static org.testng.AssertJUnit.assertEquals;

	import java.io.IOException;
	import java.util.List;
	import org.testng.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	@SuppressWarnings("unused")
	public class AddAcust
	{
		
		WebDriver driver;	
		
		//Add Customer
		By addNew = By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
		By Cgrup = By.id("input-customer-group");
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By Cemail = By.id("input-email");
		By Cphone = By.id("input-telephone");
		By Cfax = By.id("input-fax");
		By Cpwd = By.id("input-password");
		By Ccpwd = By.id("input-confirm");
		By News = By.id("input-newsletter");
		By Cstatus =	By.id("input-status");
		By Capproval = By.id("input-approved");
		By Csafe =	By.id("input-safe");
		By save = By.cssSelector("#content > div.page-header > div > div > button");


		//creating parameterized constructor to initialize WebDriver reference
		public AddAcust(WebDriver driver)
		{
			this.driver =driver;
		}

		//Add Product		
		public boolean AddCustomer(String Fname, String Lname, String Ce, String ph, String Fx, String pwd, String cpwd)
		{
			boolean status=true;
			
		try {
			driver.findElement(addNew).click();
	
			driver.findElement(fname).click();
			driver.findElement(fname).sendKeys(Fname);
			
			driver.findElement(lname).click();
			driver.findElement(lname).sendKeys(Lname);
			
			driver.findElement(Cemail).click();
			driver.findElement(Cemail).sendKeys(Ce);
			
			driver.findElement(Cphone).click();
			driver.findElement(Cphone).sendKeys(ph);
			
			driver.findElement(Cfax).click();
			driver.findElement(Cfax).sendKeys(Fx);
			
			driver.findElement(Cpwd).click();
			driver.findElement(Cpwd).sendKeys(pwd);
			
			driver.findElement(Ccpwd).click();
			driver.findElement(Ccpwd).sendKeys(cpwd);
			driver.findElement(save).click();
			System.out.println("Customer Added Successfully!!!");
			status=true;
		    }
		catch(NoSuchElementException e)
		{
			System.out.println("No Customers are Added");
			status=true;
		}
		return status;	
			
		}

			
			}


