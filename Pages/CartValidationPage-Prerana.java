package pageClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

 //This class will store all the locators and methods of Login page
 
public class CartValidationPage {
WebDriver driver;	

By email= By.id("input-email");
By password = By.id("input-password");
By loginbutton=By.cssSelector("#System_nyHsmShk > div > div:nth-child(2) > div > form > div > div.pull-right > input");
By cart=By.xpath("//*[@id=\"cart\"]/ul/li/h3/a/i");


//creating parameterized constructor to initialize WebDriver reference
public CartValidationPage(WebDriver driver)
{
	this.driver =driver;
}
public void cartLogin() throws InterruptedException,FileNotFoundException,IOException
{
	Properties obj=new Properties();
	FileInputStream objfile=new FileInputStream("userCartLogin.properties");
	obj.load(objfile);
	String mail=obj.getProperty("uemail");
	String pass=obj.getProperty("password");
	driver.findElement(email).sendKeys(mail);
	driver.findElement(password).sendKeys(pass);
	driver.findElement(loginbutton).click();
	driver.findElement(cart).click();

}
public int calculateCartTotal()
{
	String total1=driver.findElement(By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr[1]/td[6]")).getText();
	String total2=driver.findElement(By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr[2]/td[6]")).getText();
   
	total1 = total1.replace("Rs.", "");
    total1 = total1.replace(",", "");
    
    total2 = total2.replace("Rs.", "");
    total2 = total2.replace(",", "");
    
	int item1 = Integer.parseInt(total1.trim());
	int item2 = Integer.parseInt(total2.trim());
	return item1+item2;
	

}	
	
}