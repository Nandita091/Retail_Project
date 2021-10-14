package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

 
public class AdminLoginPage {
WebDriver driver;	

By username= By.id("input-username");
By password = By.id("input-password");
By loginstatus = By.cssSelector("#flash");
By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");

public AdminLoginPage(WebDriver driver)
{
	this.driver =driver;
}
public void typeusername(String s)
{
	driver.findElement(username).sendKeys(s);
}

public void typepassword(String p) {
	driver.findElement(password).sendKeys(p);
}
public void clickLoginButton()
{
	driver.findElement(loginbutton).click();
}
}