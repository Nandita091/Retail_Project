package retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RetailUserSearchPage {
	WebDriver driver;
	By search = By.id("search_button");
	By text = By.cssSelector("#filter_keyword");
	By click = By.id("search_button");
	
	public RetailUserSearchPage(WebDriver driver)
	{
		this.driver =driver;
	}
	public void clicksearchicontotype()
	{
		driver.findElement(search).click();
	}
	public void typeItemToBeSearched(String s)
	{
		driver.findElement(text).sendKeys(s);
		
		//StringBuffer product=new StringBuffer("Bottle");
		//driver.findElement(By.id("input-product")).sendKeys(product);
	}
	public void clicksearchicontosearch()
	{
		driver.findElement(click).click();
	}
	
	


}
