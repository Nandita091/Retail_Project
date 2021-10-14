package retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchItemUser {

	WebDriver driver;
	By email = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.cssSelector("#System_nyHsmShk > div.row > div:nth-child(2) > div > form > div > div.pull-right > input");
	By search = By.id("search_button");
	By text = By.cssSelector("#filter_keyword");
	By click = By.id("search_button");
	
	
	public SearchItemUser(WebDriver driver)
	{
		this.driver =driver;
	}
	public void typeUserName()
	{
		driver.findElement(email).sendKeys("naijajain1999@gmail.com");
		
	}
	public void typePassword()
	{
		driver.findElement(password).sendKeys("12345678");
		
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	public void clicksearchicontotype()
	{
		driver.findElement(search).click();
	}
	public void typeItemToBeSearched()
	{
		driver.findElement(text).sendKeys("Laptop");
	}
	public void clicksearchicontosearch()
	{
		driver.findElement(click).click();
	}
	
}
