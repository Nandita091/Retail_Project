package retailpages;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class couponsEdits {
	static WebDriver driver;
        By Addnew=By.xpath("//*[@id=\"form-coupon\"]/div/table/tbody/tr[1]/td[8]/a");
		By CouponName= By.xpath("//*[@id=\"input-name\"]");
		By Code= By.id("input-code");
		By Discount= By.id("input-discount");
		By TotalAmt= By.id("input-total");
		By SaveButton= By.xpath("//*[@id=\"content\"]/div[1]/div/div/button/i");
		static By successfuledit=By.xpath("//*[@id=\"content\"]/div[2]/div[1]");
		
		public couponsEdits(WebDriver driver) 
		{
			this.driver=driver;
		}
	
		
		public void typeCouponName(String s)
		{
			driver.findElement(CouponName).clear();
			driver.findElement(CouponName).sendKeys(s);
		}
		
		public void typeCode(String p)
		{driver.findElement(Code).clear();
			driver.findElement(Code).sendKeys(p);
		}
		
		public void typeDiscount(String q)
		{driver.findElement(Discount).clear();
			driver.findElement(Discount).sendKeys(q);
		}
		public void typeTotalAmt(String r)
		{driver.findElement(TotalAmt).clear();
			driver.findElement(TotalAmt).sendKeys(r);
		}
		public void clickSaveButton()
		{
			driver.findElement(SaveButton).click();
		}
		public void Addnew()
		{
			driver.findElement(Addnew).click();
		}
		public static boolean successfulEdit()
		{
			
			boolean success;
			try
			{
				driver.findElement(successfuledit);
				success = true;
			}
			catch(NoSuchElementException e)
			{
				success = false;
			}
			return success;
			
		}
    }
