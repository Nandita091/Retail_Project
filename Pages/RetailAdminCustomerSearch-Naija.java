package retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetailAdminCustomerSearch {
	WebDriver driver;
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
	By graph = By.cssSelector("#menu-report > a");
	By customer =By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/a");
	By customerSearches =  By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/ul/li[3]/a");
	//By datestart = By.cssSelector("#input-date-start");
	//By dateend = By.cssSelector("#input-date-end");
	By keyword = By.id("input-keyword");
	//By customername = By.id("input-customer");
	//By IP = By.id("input-ip");
	By filter = By.id("button-filter");
	
	public RetailAdminCustomerSearch(WebDriver driver)
	{
		this.driver =driver;
	}
	public void typeUsername()
	{
		driver.findElement(username).sendKeys("admin");
	}
	public void typePassword()
	{
		driver.findElement(password).sendKeys("admin@123");
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	public void clickGraph()
	{
		driver.findElement(graph).click();
	}
	public void clickCustomer()
	{
		driver.findElement(customer).click();
	}
	public void clickCustomerSearches()
	{
		driver.findElement(customerSearches).click();
	}
	
	/*public void startdate()
	{
		driver.findElement(datestart).sendKeys("2021-10-11");
	}
	public void enddate()
	{
		driver.findElement(dateend).sendKeys("2021-10-11");
	}*/
	
	public void typeKeyword()
	{
		driver.findElement(keyword).sendKeys("Laptop");
	}
	/*public void customer()
	{
		driver.findElement(customername).sendKeys("GUEST");
	}
	public void Ipaddress()
	{
		driver.findElement(IP).sendKeys("202.12.82.169");
	}*/
	public void clickFilter()
	{
		driver.findElement(filter).click();
	}
	
	

}
