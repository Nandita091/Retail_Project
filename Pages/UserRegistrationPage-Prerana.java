package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


 //This class will store all the locators and methods of Login page
 
public class UserRegistrationPage {
WebDriver driver;	
By account= By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i");

By register= By.xpath("//*[@id=\"System_nyHsmShk\"]/div/div[1]/div/div[2]/div/a");
By byfirstname= By.id("input-firstname");
By bylastname = By.id("input-lastname");
By byemail=By.id("input-email");
By bytelephone= By.id("input-telephone");
By byaddress1 =By.id("input-address-1");
By byaddress2= By.id("input-address-2");
By bycity= By.id("input-city");
By byzipcode= By.id("input-postcode");
By country= By.id("input-country");

By state= By.id("input-zone");

By bypassword= By.id("input-password");
By bycpassword= By.id("input-confirm");
By policy= By.xpath("//*[@id=\"System_nyHsmShk\"]/form/div/div[1]/label/input");
By continueButton= By.xpath("//*[@id=\"System_nyHsmShk\"]/form/div/div[2]/input");

//By registerSuccess= By.xpath("//*[@id=\"System_nyHsmShk\"]/div[1]/p[1]");
By registerSuccess=By.xpath("//*[@id=\"System_nyHsmShk\"]/div[1]/p[1]");
//*[@id="System_nyHsmShk"]/div[1]/p[1]
//*[contains(text(),'Congratulations!')
By logout=By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[4]/a/span/span/i");


public UserRegistrationPage(WebDriver driver)
{
	this.driver=driver;
}

public boolean verifyRegistration(String firstname,String lastname,String email,String telephone,
		 String address1,String address2,String city,String zipcode,String password,String cpassword)throws InterruptedException {
	driver.findElement(account).click();
	
	Thread.sleep(1000);
	driver.findElement(register).click();
	Thread.sleep(1000);
	
	driver.findElement(byfirstname).sendKeys(firstname);
	driver.findElement(bylastname).sendKeys(lastname);
	driver.findElement(byemail).sendKeys(email);
	driver.findElement(bytelephone).sendKeys(telephone);
	driver.findElement(byaddress1).sendKeys(address1);
	driver.findElement(byaddress2).sendKeys(address2);
	driver.findElement(bycity).sendKeys(city);
	driver.findElement(byzipcode).sendKeys(zipcode);
	
	
	
	Select drpCountry=new Select(driver.findElement(country));
	drpCountry.selectByVisibleText("India");
	
	Select drpState=new Select(driver.findElement(state));
	drpState.selectByVisibleText("Karnataka");
	
	driver.findElement(bypassword).sendKeys(password);
	driver.findElement(bycpassword).sendKeys(cpassword);
	driver.findElement(policy).click();
	driver.findElement(continueButton).click();
	boolean status;
	try {
		
		status=driver.findElement(registerSuccess).isDisplayed();
		
	    System.out.println("Congratulations! User is Successfully Registered.");
	    Reporter.log("User Data is Successfully registered into the Application.");
	    
	    WebElement ele = driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]"));

	  //Creating object of an Actions class
	    Actions action = new Actions(driver);

	  //Performing the mouse hover action on the target element.
	    action.moveToElement(ele).perform();
	    
	    driver.findElement(logout).click();
	    System.out.println("User Successfully Logged Out.");
	    Reporter.log("After Successful Registration user Logs out from the Application.");
	   
	}
	catch(NoSuchElementException e){
		status=true;
		System.out.println("Email Address is Already Registered! Use a different Email ID to Register.");
		Reporter.log("User cannot register into the application with already registered Email ID.");
	}
	return status;
}

}