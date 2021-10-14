package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class UserLoginPage {
	WebDriver driver;	

	By email= By.id("input-email");
	By password = By.id("input-password");
	By loginbutton = By.cssSelector("#System_nyHsmShk > div > div:nth-child(2) > div > form > div > div.pull-right > input");
	By editAccount=By.xpath("//*[@id='System_nyHsmShk']/align/ul/li[1]/a");
	By firstName=By.id("input-firstname");
	By lastName=By.id("input-lastname");
	By continueButton=By.cssSelector("#edit_account_form > div > div.pull-right > input");
	public UserLoginPage(WebDriver driver)
	{
		this.driver =driver;
	}
	public void typeemail(String s)
	{
		driver.findElement(email).sendKeys(s);
	}

	public void typepassword(String p) {
		driver.findElement(password).sendKeys(p);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginbutton).click();
	}
	public void clickEditAccount() {
		driver.findElement(editAccount).click();
	}
	public void clearFirstName() {
		driver.findElement(firstName).clear();
	}
	public void typeFirstname(String f) {
		driver.findElement(firstName).sendKeys(f);
	}
	public void clearLasttname() {
		driver.findElement(lastName).clear();
	}
	public void typeLastname(String l) {
		driver.findElement(lastName).sendKeys(l);
	}
	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}
	public void verifyEdit() {
		WebElement msg=driver.findElement(By.xpath("//*[contains(@id,'System_nyHsmShk')]//child::div"));
		String text=msg.getText();
		Assert.assertEquals(text,"Success: Your account has been successfully updated.");
	}
	}
