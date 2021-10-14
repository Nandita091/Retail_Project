package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserLoginPage {
	
	WebDriver driver;
	
	By username = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input");
	By homePageTitle = By.xpath("//*[@id=\"PageTitleSystem_B083XYxw\"]/h1");
	By footer = By.xpath("//*[@id=\"copy\"]/span");
	
	//creating parameterized constructor to instantiate WebDriver reference
	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isFooterAvailable() {
		if(driver.findElement(footer).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean isHomeTextAvailable() {
		if(driver.findElement(homePageTitle).isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public void typeUsernamePassword(String user, String pass) {
		
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);

	}
	
	
	public void clickSignIn() {
		driver.findElement(loginButton).click();
	}
	
	public String getFooterString() {
		String footerString;
		try {
			footerString = driver.findElement(footer).getText();
		}catch(NoSuchElementException e) {
			footerString = "Not found";
		}
		return footerString;
	}
	
}
