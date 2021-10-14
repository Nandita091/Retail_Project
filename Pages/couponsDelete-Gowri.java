package retailpages;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class couponsDelete {
	static WebDriver driver;
        By checkbox=By.xpath("//*[@id=\"form-coupon\"]/div/table/tbody/tr[1]/td[1]/input");
		
		By deletebutton= By.xpath("//*[@id=\"content\"]/div[1]/div/div/button");
		By msg=By.xpath("//*[@id=\"content\"]/div[2]/div[1]");
		static By successfulDeletion=By.xpath("//*[@id=\"content\"]/div[2]/div[1]");
		public couponsDelete(WebDriver driver) 
		{
			this.driver=driver;
		}
	
		
		public void clickcheckbox()
		{
			driver.findElement(checkbox).click();
		}
		public void clickdeletebutton()
		{
			driver.findElement(deletebutton).click();
		}
		public void displaymsg()
		{
			String text=driver.findElement(msg).getText();
			
			System.out.println(text);
			
		}
		public static boolean successfuldeletion()
		{
			
			boolean success;
			try
			{
				driver.findElement(successfulDeletion);
				success = true;
			}
			catch(NoSuchElementException e)
			{
				success = false;
			}
			return success;
			
		}
	    
    }
