package retailpages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class loginpage1 {
	private WebDriver driver;

		By Username= By.xpath("//*[@id=\"input-username\"]");
		By Password= By.id("input-password");
		By LoginButton= By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
		
		
		public loginpage1(WebDriver driver) 
		{
			this.driver=driver;
		}
	
		public void Login()
		{
			driver.findElement(Username).sendKeys("admin");
			driver.findElement(Password).sendKeys("admin@123");
			driver.findElement(LoginButton).click();
		}
		public void typeUsername(String un)
		{
			driver.findElement(Username).sendKeys(un);
		}
		
		public void typePassword(String pn)
		{
			driver.findElement(Password).sendKeys(pn);
		}
		
	
		public void clickLoginButton()
		{
			driver.findElement(LoginButton).click();
		}
	
    }



