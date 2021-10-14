package RetailShopPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Util.TakeScreenShot;
public class RetailAdminLoginPage {
	WebDriver driver;
	public TakeScreenShot shot;
	By username= By.id("input-username");
	By password = By.id("input-password");
	By loginstatus = By.cssSelector("#flash");
	By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
	
	//retunsadd
	By add=By.cssSelector("#content > div.page-header > div > div > a > i");
	By orderid=By.id("input-order-id");
	By orderdate=By.id("input-date-ordered");
	By customer=By.id("input-customer");
	By firstname=By.id("input-firstname");
	By lastname=By.id("input-lastname");
	By email=By.id("input-email");
	By telephone=By.id("input-email");
	By product=By.id("input-product");
	By model=By.id("input-model");
	By quantity=By.id("input-quantity");
	By returnreason=By.cssSelector("#input-return-reason");
	By open=By.cssSelector("#input-opened");
	By comment=By.id("input-comment");
	By returnstatus=By.id("input-return-status");
	By save=By.cssSelector("#content > div.page-header > div > div > button");                                    
	
	public RetailAdminLoginPage(WebDriver driver)
	{
		this.driver =driver;
	}
	public void typeusername(String s)
	{
		driver.findElement(username).sendKeys(s);
	}

	public void typepassword(String p) {
		driver.findElement(password).sendKeys(p);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginbutton).click();
	}
	public void clickAddButton()
	{
		driver.findElement(add).click();
	}
	public void addOrderID(String oid)
	{
		driver.findElement(orderid).sendKeys(oid);
	}
	public void addOrderDate(String od)
	{
		driver.findElement(orderdate).sendKeys(od);
	}
	public void addCustomer(String cust) {
		driver.findElement(customer).sendKeys(cust);
	}
	public void addFirstName(String first) {
		driver.findElement(firstname).sendKeys(first);
	}
	public void addLastName(String last) {
		driver.findElement(lastname).sendKeys(last);
	}
	public void addEmail(String em) {
		driver.findElement(email).sendKeys(em);
	}
	public void addTelephone (String tel) {
		driver.findElement(telephone).sendKeys(tel);
	}
	public void addProduct(String pro) {
		driver.findElement(product).sendKeys(pro);
	}
	public void addModel(String mod) {
		driver.findElement(model).sendKeys(mod);
	}
	public void addQuantity(String qty) {
		driver.findElement(quantity).sendKeys(qty);
	}
	public void retunreason()
	{
		driver.findElement(returnreason).click();
	}
	public void open_status() {
		driver.findElement(open).click();
	}
	public void addComment(String comm) {
		driver.findElement(comment).sendKeys(comm);
	}
	
	public void returnstatus() {
		driver.findElement(returnstatus).click();
	}
	
	public void clickSave() {
		driver.findElement(save).click();
		shot=new TakeScreenShot(driver);
		String Screenshot=shot.screenshot();
		shot.takeSnapShot(driver, Screenshot);
		
	}
	}

