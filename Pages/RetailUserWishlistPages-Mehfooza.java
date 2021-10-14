package retailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
public class RetailUserWishlistPages {
	
	WebDriver driver;	
	

	By username= By.id("input-email");

	By password = By.id("input-password");
	By loginbutton = By.cssSelector("#System_nyHsmShk > div > div:nth-child(2) > div > form > div > div.pull-right > input");

	By HeaderText = By.xpath("//*[contains(text(),'My Account')]/parent::div");

	By Home=By.cssSelector("#menu_url_F5fG9 > a > span");
	By item2=By.cssSelector("#RandomProducts_RoiFQGb2 > div > div > div:nth-child(2) > div > div.thumbnail > div.image > a > span > span > img");
	By Item=By.cssSelector("#BestsellerProducts_Yllc2v2l > div > div.tb_products.tb_listing.tb_grid_view.tb_style_plain.tb_exclude_thumb.tb_buttons_1.tb_buttons_config--wishlist_b--quickview_b.tb_size_4.tb_gut_40.tb_multiline.tb_slider > div > div > div:nth-child(7) > div > div > div.thumbnail > div.image > a > span > span > img");
	By Wish = By.cssSelector("#ProductAddToCartSystem_C8WkgNNi > div.tb_cart_wrap > div.tb_actions > div > a");
	                    
	By icon =By.cssSelector("#Menu_Wmt3OMY3 > nav > ul > li.tb_link.wishlist_total.tb_menu_system_account_wishlist > a > span > span.tb_icon > i");
	By Itemout=By.xpath("\"//*[@id=\\\"ProductInfoSystem_IcyE9WlD\\\"]/dl/dd[2]\"");
	By Itemin=By.xpath("//*[@id=\"System_s3bhXNDb\"]/div[1]/table/tbody/tr/td[3]");
	By DeleteItem=By.xpath("//*[@id=\"System_s3bhXNDb\"]/div[1]/table/tbody/tr/td[6]/a");
	By SuccessDelete=By.xpath("//*[@id=\"System_s3bhXNDb\"]/div[1]");
	
	
	public RetailUserWishlistPages(WebDriver driver)
	{
		this.driver =driver;
	}
	
	//loginsucces
	public boolean UserLogin(String un,String pw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginbutton).click();
		boolean found=true;
		try {
			//Dashboard header present in page?
			found=driver.findElement(HeaderText).isDisplayed();
		    }
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
	}
	
	//choose item click wishlist
	public boolean wishlistProduct() 
	{
		driver.findElement(Home).click();
		WebDriverWait wait = new WebDriverWait(driver,50);
		
		//scroll down
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Best Sellers']"))); 
		 WebElement l=driver.findElement(By.xpath("//*[text()='Best Sellers']"));
	      // Actions class with moveToElement()
	      Actions a = new Actions(driver);
	      a.moveToElement(l);
	      a.perform();
	      
	      //click the item from best seller section
	      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"BestsellerProducts_Yllc2v2l\"]/div/div[1]/div/div/div[12]/div/div/div[2]/div[1]/a/span/span/img"))); 
	      driver.findElement(Item).click();
	      
	      //get the code of the item wishlisted
	      WebElement i=driver.findElement(By.xpath("//*[@id=\"ProductInfoSystem_IcyE9WlD\"]/dl/dd[2]"));
	      String c=i.getText();
			
	     // get the item code present in wish list
	      driver.findElement(Wish).click();
		driver.findElement(icon).click();
		////*[contains(@id,"RandomProducts")]//div[3]//following-sibling::a[contains(@class,"fa-search")]
		
		WebElement j=driver.findElement(Itemin);
		String b=j.getText();
		System.out.println("first :"+c+"   second"+b);
		boolean success=false;
		if(c.equals(b))
		{
			success=true;
		}
		else
		{
			success=false;
		}
		return success;
		
	}
	
	public void RemoveItemFromWishList()
	{
	
		driver.findElement(DeleteItem).click();
		WebElement j=driver.findElement(SuccessDelete);
		String b=j.getText();
		System.out.println(b);
		
		
	}
	

}






