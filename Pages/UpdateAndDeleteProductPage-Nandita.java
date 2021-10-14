package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class UpdateAndDeleteProductPage {
	
	WebDriver driver;
	
	//userlogin cred
	By username = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.cssSelector("#System_nyHsmShk > div > div:nth-child(2) > div > form > div > div.pull-right > input");
	By HeaderText = By.xpath("//*[contains(text(),'My Account')]/parent::div");
	By homeIcon = By.xpath("//*[@id=\"menu_url_F5fG9\"]");
	
	//cart icon
	By cartIcon = By.id("cart");
	
	//update input field in the cart for product
	By updateProduct = By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr/td[4]/div/input");
	
	//refresh button in the cart
	By refreshButton = By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr/td[4]/div/span/button[1]");
	
	//delete product from cart button
	By deleteButton = By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr/td[4]/div/span/button[2]");
	
	
	
	public UpdateAndDeleteProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void userLogin(String un, String pass) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pass);

	}
	
	public void SignIn() {
		driver.findElement(loginButton).click();
//		driver.findElement(homeIcon).click();
	}
	
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
	
	public void updateProduct(int num) {
		
		WebElement element = driver.findElement(updateProduct);
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(element)
				.click()
				.sendKeys(element, Keys.BACK_SPACE)
				.sendKeys(element, String.valueOf(num))
				.build();
		seriesOfActions.perform();
		
		driver.findElement(refreshButton).click();
	}
	
	public void deleteProduct() {
		driver.findElement(deleteButton).click();
		driver.findElement(refreshButton).click();
	}

}
