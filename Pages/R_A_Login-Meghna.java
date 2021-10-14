package RetailShopPage;





import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;

import Util.TakeScreenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


 //This class will store all the locators and methods of Login page
 
public class R_A_Login {
WebDriver driver;	
public TakeScreenShot shot; 
//login
By username= By.id("input-username");
By password = By.id("input-password");
By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
By HeaderText = By.xpath("//*[@id=\"content\"]/div[1]/div/h1");

//Add Product
By add=By.xpath("//*[@id=\"content\"]/div[1]/div/div/a/i");
By orderid=By.id("input-order-id");
By customer=By.id("input-customer");
By firstname=By.id("input-firstname");
By lastname=By.id("input-lastname");
By email=By.id("input-email");
By telephone=By.id("input-telephone");
By product=By.id("input-product");
By model=By.id("input-model");
By quantity=By.id("input-quantity");
By returnreason=By.cssSelector("#input-return-reason");
By open=By.cssSelector("#input-opened");
By comment=By.id("input-comment");
By returnstatus=By.id("input-return-status");
By save=By.xpath("//*[@id=\"content\"]/div[1]/div/div/button"); 


//creating parameterized constructor to initialize WebDriver reference
public R_A_Login(WebDriver driver)
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
	

	
//Add Product
	public boolean AddProduct(String id,String cust,String fname,String lname,String em,String tel,String prod,String mod,String qty,String commen)
	{
		boolean status=true;
	try {
		driver.findElement(add).click();
		
		driver.findElement(orderid).sendKeys(id);
		driver.findElement(customer).sendKeys(cust);
		driver.findElement(firstname).sendKeys(fname);
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(email).sendKeys(em);
		driver.findElement(telephone).sendKeys(tel);
		driver.findElement(product).sendKeys(prod);
		driver.findElement(model).sendKeys(mod);
		driver.findElement(quantity).sendKeys(qty);
		driver.findElement(returnreason).click();
		driver.findElement(open).click();
		driver.findElement(comment).sendKeys(commen);
		driver.findElement(returnstatus).click();
		
		driver.findElement(save).click();
		
		System.out.println("Products Added Successfully!!!");
		shot=new TakeScreenShot(driver);
		String Screenshot=shot.screenshot();
		shot.takeSnapShot(driver, Screenshot);
		status=true;
		
	    }
	catch(NoSuchElementException e)
	{
		System.out.println("No Products are Added");
		status=true;
	}
	return status;	
		
	}

	


	}
	




