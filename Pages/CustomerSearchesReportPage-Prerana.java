package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

 //This class will store all the locators and methods of Login page
 
public class CustomerSearchesReportPage {
WebDriver driver;	

By username= By.id("input-username");
By password = By.id("input-password");
By loginbutton=By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
By report=By.xpath("//*[@id=\"menu-report\"]/a/i");
By customer=By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/a");
By customerSearch=By.xpath("//*[@id=\"menu-report\"]/ul/li[3]/ul/li[3]/a");


//creating parameterized constructor to initialize WebDriver reference
public CustomerSearchesReportPage(WebDriver driver)
{
	this.driver =driver;
}
public void adminLogin() throws InterruptedException
{
	driver.findElement(username).sendKeys("admin");
	driver.findElement(password).sendKeys("admin@123");
	driver.findElement(loginbutton).click();
	driver.findElement(report).click();
	Thread.sleep(1000);
	driver.findElement(customer).click();
	Thread.sleep(1000);
	driver.findElement(customerSearch).click();
}

/*public String findNullFoundProducts()
{
	
}*/

	
}