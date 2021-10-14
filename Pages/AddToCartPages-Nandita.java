package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;


public class AddToCartPages {
	
	WebDriver driver;	
	
	//UserLogin Credentials
	By username = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input");
	By HeaderText = By.xpath("//*[contains(text(),'My Account')]/parent::div");
	By homeIcon = By.id("menu-url-F5fG9");

	
	By ringItem = By.cssSelector("#BestsellerProducts_Yllc2v2l > div > div.tb_products.tb_listing.tb_grid_view.tb_style_plain.tb_exclude_thumb.tb_buttons_1.tb_buttons_config--wishlist_b--quickview_b.tb_size_4.tb_gut_40.tb_multiline.tb_slider > div > div > div:nth-child(7) > div > div > div.thumbnail > div.image > a > span > span > img");
	                    
	//Featured product item
	By featuredProduct1 = By.xpath("//*[contains(@id,\"RandomProducts\")]//div[3]//following-sibling::a[contains(@class,\"fa-search\")]");
	
	//Cart page credentials
	By updateInputTextbox = By.xpath("//input[contains(@name, \"quantity\")]");
	By refreshButton = By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr/td[4]/div/span/button[1]");
	By deleteButton = By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr/td[4]/div/span/button[2]");
	
	//when cart is empty
	By emptyCart = By.xpath("//*[@id=\"System_V2Exp1o9\"]/div[1]/p");

	//Personalized ring product page cred
	By addToCartButton = By.id("button-cart");
	By cartIcon = By.id("cart");
	
	//xpath for update button: //input[contains(@name, "quantity")]
	//refresh button: //button[@title="Update"]
	//delete button: //button[@title="Update"]//following-sibling::button[@title="Remove"]
	
	
	//initialize Chrome driver
	public AddToCartPages(WebDriver driver)
	{
		this.driver =driver;
	}
	
	//method to scroll down the home page and click on ring product from the bestseller section
	public void addToCartProduct() 
	{
		driver.findElement(homeIcon).click();
		
		WebDriverWait wait = new WebDriverWait(driver,50);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Best Sellers']"))); 
		WebElement l=driver.findElement(By.xpath("//*[text()='Best Sellers']"));  //BestSeller title
		 
	    Actions a = new Actions(driver);
	    a.moveToElement(l);
	    a.perform();
	   
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"BestsellerProducts_Yllc2v2l\"]/div/div[1]/div/div/div[12]/div/div/div[2]/div[1]/a/span/span/img"))); 
	    driver.findElement(ringItem).click();
		
	}

	public void UserLogin(String un,String pw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginButton).click();

	}
	
	//Personalized ring page methods
	
	//method to click on AddToCart button in the product page
	public void clickAddToCartButton() {
		driver.findElement(addToCartButton).click();

	}
	
	//method for clicking on cart icon in the nav bar
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
	
	
	//method for updating product quantity on the input box
	public void updatingProductQuantity(int num) {
		
		WebElement element = driver.findElement(updateInputTextbox);

		//Action keys method
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(element)
				.click()
				.sendKeys(element, Keys.BACK_SPACE)
				.sendKeys(element, String.valueOf(num))
				.build();
		seriesOfActions.perform();
		
		//refresh button
		driver.findElement(refreshButton).click();
			
	}
	
	//method for deleting present item in the cart
	public void deleteProduct() {
		
		driver.findElement(deleteButton).click();
		
		//refresh button
		driver.findElement(refreshButton).click();
		
	}
	
}
