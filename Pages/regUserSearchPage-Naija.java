package retail.pages;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class regUserSearchPage {
	WebDriver driver;
	By email = By.id("input-email");
	By password = By.id("input-password");
	By loginButton = By.cssSelector("#System_nyHsmShk > div.row > div:nth-child(2) > div > form > div > div.pull-right > input");
	By HeaderText = By.cssSelector("#wpbody-content > div.wrap > h1");
	By search = By.id("search_button");
	By text = By.cssSelector("#filter_keyword");
	By click = By.id("search_button");
	//By selectOption =By.xpath("//*[@id=\\\"ProductsSystem_YD9pMDOx\\\"]/nav/div/div[3]/select");
	
	//WebElement firstEle =sel1.getFirstSelectedOption();
	
	
	
	
	public regUserSearchPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	
	public void typeemail(String e)
	{
		driver.findElement(email).sendKeys(e);
	}
	public void typePassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	
	
	public void clickSearchToType()
	{
		driver.findElement(search).click();
	}
	public void typeItemToBeSearched(String sh)
	{
		driver.findElement(text).sendKeys(sh);
	}
	public void clicksearchicontosearch()
	{
		driver.findElement(click).click();
	}
	
	public void sortBy() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"ProductsSystem_YD9pMDOx\"]/nav/div/div[3]/select"));
		Select Sb = new Select(element);
		Sb.selectByVisibleText("Price (Low > High)");
		
		//driver.findElement(selectoption).click();
	}
}
	

	





/*public void sortBy()
{
	driver.findElement(sort).click();
}*/


/*public void option() {
driver.findElement(By.xpath("//*[@id=\"ProductsSystem_YD9pMDOx\"]/nav/div/div[3]/select/option[4]")).click();
}*/


//By sort = By.cssSelector("#ProductsSystem_YD9pMDOx > nav > div > div.sort > select");
	//By selectoption = By.xpath("//*[@id=\"ProductsSystem_YD9pMDOx\"]/nav/div/div[3]/select/option[6]");
	/*WebElement t=driver.findElement(By.xpath("//*[@id=\"ProductsSystem_YD9pMDOx\"]/nav/div/div[3]/select"));
  //Select class for dropdown
  Select select = new Select(t);
  // select an item with text visible
  select.selectByValue("http://retailm1.upskills.in/product/search?sort=rating&order=DESC&search=ring")
  // get selected option with getFirstSelectedOption() with its text
  WebElement o = select.getFirstSelectedOption();
  String selectedoption = o.getText();
  System.out.println( "Selected element: " + selectedoption);
	//Select select_string = 
	//private boolean success;*/
	//Select se = new Select(driver.findElement(By.cssSelector("#ProductsSystem_YD9pMDOx > nav > div > div.sort > select")));
	
	// Select the option with value "6"
	//se.selectByValue("");
	





















/*public void SearchItem(String un, String pw, String sh) {
WebElement element = driver.findElement(email);
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
driver.findElement(email).sendKeys(un);
driver.findElement(password).sendKeys(pw);
driver.findElement(loginButton).click();
driver.findElement(search).click();
driver.findElement(text).sendKeys(sh);
driver.findElement(click).click();
//*[@id="ProductsSystem_YD9pMDOx"]/nav/div/div[3]/select
*/
//boolean success=this.isHeaderFound();

//return success;




/*public String getRELoginTitle(WebDriver driver) {
// TODO Auto-generated method stub

System.out.println(driver.getTitle());
String curTitle = driver.getTitle();
return curTitle;*/





//public void typeemail(String email) {
	//	dr
	//}
	
	/*public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
			WebElement element = driver.findElement(HeaderText);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Dashboard header present in page?
			found=driver.findElement(HeaderText).isDisplayed();
		}
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
		
	}	*/