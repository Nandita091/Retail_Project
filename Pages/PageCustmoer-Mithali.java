package RetailPages;

import org.openqa.selenium.By;

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
public class PageCustmoer {
	static WebDriver driver;	

	//Customer Filter
	By name = By.id("input-name");
	By Cg = By.id("input-customer-group");
	By approval = By.id("input-approved");
	By add_date = By.id("input-date-added");
	By email = 	By.id("input-email");
	By status =	By.id("input-status");
	By ip =	By.id("input-ip");
	By filter = By.id("button-filter");
	By add1  = By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
	
	//delete customer
	By del = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button");
	By selectBox = By.cssSelector("#form-customer > div > table > tbody > tr > td.text-center");
	
	public PageCustmoer(WebDriver driver)
	{
		PageCustmoer.driver =driver;
	}

	
	public void Plusfun() {
		
		driver.findElement(add1).click();
	}
	

	
	
	//Delete Customer	
			public boolean DeleteCust(String cemail)
			{
				boolean status=true;
				try {
					// delete the item by filtering
					 
					 driver.findElement(email).click();
					 driver.findElement(email).sendKeys(cemail);
					 driver.findElement(filter).click();
		
				     driver.findElement(selectBox).click();
				     driver.findElement(del).click();
					 driver.switchTo().alert().accept();
					 System.out.println("Customer Deleted!!!");
						
					 //Check for deleted element
					 driver.findElement(email).click();
					 driver.findElement(email).sendKeys(cemail);
					 driver.findElement(filter).click();
				}
				catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						status=true;
					}
				return status;
			}
			

//Filter customers
			public boolean customerName(String Cname)
			{
				boolean result=true;
				try {
				
				  driver.findElement(name).click();
				    driver.findElement(name).sendKeys(Cname);
				    driver.findElement(filter).click();
				}
				catch(NoSuchElementException e)
				{
					System.out.println("No Result");
					result=false;
				}
			return result;
				  
			  }
			 
				public boolean checkCustomerGrp(String cgname)
				{
					boolean result=true;
					try {
					
				  Select cg = new Select(driver.findElement(Cg));
					cg.selectByVisibleText(cgname);
				    driver.findElement(filter).click();   
					}
					
					catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;
				}
			  
			  
				public boolean checkApprovalY(String CapprovalY)
				{
					boolean result=true;
				 try {
					Select app = new Select(driver.findElement(approval));
					app.selectByVisibleText(CapprovalY);
				    driver.findElement(filter).click();   
				 }
				 catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;
				 
				}

				public boolean  checkApprovalN(String CapprovalN)
				{
					boolean result=true;
					try {
				  Select app = new Select(driver.findElement(approval));
					app.selectByVisibleText(CapprovalN);
				    driver.findElement(filter).click();   
					}
					 catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;
				}
			  
			  
			  public boolean checkDate(String Cdate) {
				  boolean result=true;
				  try {
				  driver.findElement(add_date).sendKeys(Cdate);
				    driver.findElement(filter).click();
			  }
				  catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;
			  }
			  
			  

				public boolean checkEmail(String Cemail)
				{
					boolean result=true;
					try {
					driver.findElement(email).click();
				    driver.findElement(email).sendKeys(Cemail);
				    driver.findElement(filter).click();
					}
					catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;

					
				}

				public boolean checkStatusE(String CSe) 
				{
					boolean result=true;
					try {
				  Select stat = new Select(driver.findElement(status));
					stat.selectByVisibleText(CSe);
				    driver.findElement(filter).click();   
					}
					catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;

				}
			  
			  
				public boolean checkStatusD(String CSd) 
				{
					boolean result=true;
					try {
				  Select stat = new Select(driver.findElement(status));
					stat.selectByVisibleText(CSd);
				    driver.findElement(filter).click();   
					}
					catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;

				}
			 
				public boolean checkIP(String CIP) {
		
					boolean result=true;
					try {
					driver.findElement(ip).click();
				    driver.findElement(ip).sendKeys(CIP);
				    driver.findElement(filter).click();
					}
					catch(NoSuchElementException e)
					{
						System.out.println("No Result");
						result=false;
					}
				return result;

					
				}

}
