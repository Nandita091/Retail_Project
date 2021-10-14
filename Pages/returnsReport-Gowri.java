package retailpages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class returnsReport {
	//public returnsReport(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		WebDriver driver;
	
	By datestart = By.id("input-date-start");
	By dateend = By.id("input-date-end");
    By filter = By.xpath("//*[@id=\"button-filter\"]");
    public returnsReport(WebDriver driver)
	{
		this.driver =driver;
	}

	
	
	public void typedatestart(String s)
	{
		driver.findElement(datestart).sendKeys(s);
	}
	
	public void typedateend(String p)
	{
		driver.findElement(dateend).sendKeys(p);
	}
	
	public void clickfilterButton()
	{
		driver.findElement(filter).click();
	}
	public void typedatestartc()
	{
		driver.findElement(datestart).clear();
	}
	public void typedateendc()
	{
		driver.findElement(dateend).clear();
	}
	
		
}
    



