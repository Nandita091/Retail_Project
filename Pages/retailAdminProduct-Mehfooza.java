package retailPage;
import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.TakesScreenshot;
import java.util.List;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Util.TakeScreenShot;

 //This class will store all the locators and methods of Login page
 
public class retailAdminProduct {
WebDriver driver;	
public TakeScreenShot shot; 
//login
By username= By.id("input-username");
By password = By.id("input-password");
By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
By HeaderText = By.xpath("//*[@id=\"content\"]/div[1]/div/h1");

//Filter Product
By name=By.id("input-name");
By price=By.id("input-price");
By Status=By.id("input-status");
By enabled=By.xpath("//*[@id=\"input-status\"]/option[2]");
By Assert=By.xpath("//*[@id=\"form-product\"]/div/table/tbody/tr/td[3]");
By filter=By.xpath("//*[@id=\"button-filter\"]");
By Disabled=By.xpath("//*[@id=\"input-status\"]/option[3]");

//Delete Product
By Deletedata=By.xpath("//*[@id=\"form-product\"]/div/table/tbody/tr/td[1]/input");
By DeleteButton=By.xpath("//*[@id=\"content\"]/div[1]/div/div/button[2]");

//Add Product
By AddNew=By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
By Save=By.cssSelector("#content > div.page-header > div > div > button");
By ProductName=By.id("input-name1");
By Metatagtitle=By.id("input-meta-title1");
By Model=By.id("input-model");
By Data=By.linkText("Data");
By PPrice=By.id("input-price");
By Quantity=By.id("input-quantity");


 

//creating parameterized constructor to initialize WebDriver reference
public retailAdminProduct(WebDriver driver)
{
	this.driver =driver;
}

public boolean isHeaderFound()

{
	
	boolean found=false;
	try {
		//Dashboard header present in page?
		found=driver.findElement(HeaderText).isDisplayed();
	}
	
	catch (NoSuchElementException e)
	{
		found=false;
	}
	
	return found;
	
}	
	

	public boolean AdminLogin(String un,String pw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginbutton).click();
		boolean success=this.isHeaderFound();
		return success;
	
	}

	public String getUSLoginTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		
		System.out.println(driver.getTitle());
		String curTitle = driver.getTitle();
		return curTitle;	
	}
	
//FILTER PRODUCT
	public boolean filter(String PrdName,String PrdPrice) {
		boolean status=true;
		
		
		try {
		StringBuffer pname=new StringBuffer(PrdName);
        
		driver.findElement(name).click();
		 driver.findElement(name).sendKeys(pname);
		 driver.findElement(price).click();
		 driver.findElement(price).sendKeys(PrdPrice);
		 Select slc = new Select(driver.findElement(Status));
			slc.selectByValue("1");
			
		// driver.findElement(Status).click();
		// driver.findElement(enabled).click();
		// String txt=driver.findElement(enabled).getText();
		//System.out.println(txt);
		driver.findElement(filter).click();
			WebElement assertDataEle=driver.findElement(Assert);
			String assertData=assertDataEle.getText();
			StringBuffer datamatch=new StringBuffer(assertData);
			
//Take screen shot
			shot=new TakeScreenShot(driver);
			String Screenshot=shot.screenshot();
			shot.takeSnapShot(driver, Screenshot);
			
			
		    if(datamatch.substring(0).equals(pname.substring(0)))
		     {
			System.out.println("Matching Product Found for the  keyword: "+pname+"  is: "+assertData);
			Reporter.log("Matching Product Found for the  keyword: "+pname+"  is: "+assertData);
			status=true;
			 
		     }
		   
		   
		  }
	catch(NoSuchElementException e)
		{
			System.out.println("Not Found");
			Reporter.log("**********No Match Found**********");
			status=true;
			
		}	
		return status;
		
	}
	
	
//Delete Product
	public boolean DeleteProduct(String Pname)
	{
		boolean status=true;
		try {
			// dlete the item by filtering
			 
			 driver.findElement(name).click();
			 driver.findElement(name).sendKeys(Pname);
			 driver.findElement(filter).click();
			 WebElement assertDataEle=driver.findElement(Assert);
		     String assertData=assertDataEle.getText();
		     driver.findElement(Deletedata).click();
		     driver.findElement(DeleteButton).click();
		     if(assertData.equals(Pname))
		         {
		           System.out.println(assertData+" is deleted");
		           Reporter.log("**********"+assertData+" is deleted**********");
		           status=true;
		         }
		}
		catch(NoSuchElementException e)
			{
				System.out.println("No Product present");
				 Reporter.log("**********No product found to delete**********");
				status=true;
			}
		return status;
	}
	
//Add Product
	public boolean AddProduct(String Pname,String MetaTag,String ModeL,String Price,String Qty)
	{
		boolean status=true;
	try {
		driver.findElement(AddNew).click();
		driver.findElement(ProductName).click();
		driver.findElement(ProductName).sendKeys(Pname);
		driver.findElement(Metatagtitle).click();
		driver.findElement(Metatagtitle).sendKeys(MetaTag);
		driver.findElement(Data).click();
		driver.findElement(Model).click();
		driver.findElement(Model).sendKeys(ModeL);
		driver.findElement(PPrice).sendKeys(Price);
		driver.findElement(Quantity).clear();
		driver.findElement(Quantity).sendKeys(Qty);
		driver.findElement(Save).click();
		System.out.println("Products Added Successfully!!!");
		 Reporter.log("**********Products added successfully!!!**********");
		status=true;
	    }
	catch(NoSuchElementException e)
	{
		System.out.println("No Products are Added");
		 Reporter.log("**********No products are added**********");
		status=true;
	}
	return status;	
		
	}
}


