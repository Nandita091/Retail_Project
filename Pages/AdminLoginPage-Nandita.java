package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {

	WebDriver driver;
	
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
	By dashboard = By.xpath("//*[@id=\"content\"]/div[1]/div/h1");
	By footerText = By.xpath("//*[@id=\"footer\"]");
	
	
	//creating paramaterized constructor to instantiate WebDriver reference
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isUsernameBoxAvailable() {
		if(driver.findElement(username).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean isUsernameBoxEnabled() {
		if(driver.findElement(username).isEnabled()) {
			return true;
		}
		return false;
	}
	
	public boolean isPasswordBoxEnabled() {
		if(driver.findElement(password).isEnabled()) {
			return true;
		}
		return false;
	}
	
	public void typeUsername(String str) {
		driver.findElement(username).sendKeys(str);
	}
	
	public void typePassword(String str) {
		driver.findElement(password).sendKeys(str);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public String getLoginStatus() {
		String dashboardText;
		
		dashboardText = driver.findElement(dashboard).getText();
		return dashboardText;
	}
	
	public String getFooterString() {
		String footerString;
		try {
			footerString = driver.findElement(footerText).getText();
		}catch(NoSuchElementException e) {
			footerString = "Not found";
		}
		return footerString;
	}
}
