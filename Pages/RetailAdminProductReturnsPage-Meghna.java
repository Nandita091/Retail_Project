package RetailShopPage;
import java.util.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import Util.TakeScreenShot;
public class RetailAdminProductReturnsPage {
	WebDriver driver;
	public TakeScreenShot shot; 
	By returnid= By.id("input-return-id");
	By orderid = By.id("input-order-id");
	By product = By.id("input-product");
	By customer = By.id("input-customer");
	By model=By.id("input-model");
	By dataAdded=By.id("input-date-added");
	By dateModified=By.id("input-date-modified");
	By noresultsmsg=By.xpath("//*[contains(text(),'No results')]");
	//By returnstatus=By.cssSelector("#input-return-status > option:nth-child(2)\"");
	By filterButton=By.id("button-filter");
	public RetailAdminProductReturnsPage(WebDriver driver) {
		this.driver =driver;
	}
	public boolean searchByOrderID(String order_id) {
		boolean filterSuccess;
		
		driver.findElement(orderid).sendKeys(order_id);
		driver.findElement(filterButton).click();
		
			//WebElement TableData=driver.findElement(By.xpath("//*[@id=\"form-return\"]/div/table"));
			//List<WebElement> orderid= driver.findElements(By.xpath("//*[contains(text(),"+order_id+")]"));
			
		    java.util.List<WebElement> orderid= driver.findElements(By.xpath("//*[contains(text(),"+order_id+")]"));
		    
			int numorder=orderid.size();
			
			if(numorder>=2) {
				filterSuccess=true;
				Reporter.log("Found Order ID "+order_id);
				System.out.println(numorder);
			}else {
				filterSuccess=true;
				System.out.println("No results are found");
				Reporter.log("No Data Found for Order ID "+order_id);
				System.out.println(numorder);
			}
			
			shot=new TakeScreenShot(driver);
			String Screenshot=shot.screenshot();
			shot.takeSnapShot(driver, Screenshot);
			
		return filterSuccess;
	}
}
