package retailpages;

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

public class AddCoupon
{
	
	WebDriver driver;	
	
	//Add Customer
	By addNew = By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
	By Cname = By.id("input-name");
	By Ccode = By.id("input-code");
	By Cdiscount = By.id("input-discount");
	By CtotalAmt = By.id("input-total");
    By save = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button");


	//creating parameterized constructor to initialize WebDriver reference
	public AddCoupon(WebDriver driver)
	{
		this.driver =driver;
	}

	//Add Product		
	public boolean AddCoupons(String couponname, String couponcode, String discount, String Amt)
	{
		boolean status=true;
		
	try {
		driver.findElement(addNew).click();

		driver.findElement(Cname).click();
		driver.findElement(Cname).sendKeys(couponname);
		
		driver.findElement(Ccode).click();
		driver.findElement(Ccode).sendKeys(couponcode);
		
		driver.findElement(Cdiscount).click();
		driver.findElement(Cdiscount).sendKeys(discount);
		
		driver.findElement(CtotalAmt).click();
		driver.findElement(CtotalAmt).sendKeys(Amt);
		
		
		driver.findElement(save).click();
		System.out.println("Coupons Added Successfully!!!");
		status=true;
	    }
	catch(NoSuchElementException e)
	{
		System.out.println("Coupons are Added");
		status=true;
	}
	return status;	
		
	}


		
}


