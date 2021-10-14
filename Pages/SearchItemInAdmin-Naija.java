package retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchItemInAdmin {

	WebDriver driver;
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
	By graph = By.cssSelector("#menu-report > a");
	By customer =By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/a");
	By customerSearches =  By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/ul/li[3]/a");
	By keyword = By.id("input-keyword");
	By filter = By.id("button-filter");
	
	public SearchItemInAdmin(WebDriver driver)
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
	public void typeKeyword()
	{
		driver.findElement(keyword).sendKeys("Laptop");
	}
	public void clickFilter()
	{
		driver.findElement(filter).click();
	}
	
	
}
