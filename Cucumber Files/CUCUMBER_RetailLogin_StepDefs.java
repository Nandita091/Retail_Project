package StepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.CUCUMBER_RetailLogin_PAGE;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CUCUMBER_RetailLogin_StepDefs {
	static WebDriver driver;
	static CUCUMBER_RetailLogin_PAGE ulogin; 

	@Before
	public void initdriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver_win32\\chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	ulogin=new CUCUMBER_RetailLogin_PAGE(driver);
    	
	}
	@After
	public void teardown()
	{
		 driver.quit();
	}
	
	
@Given("user is on  login page")
public void user_is_on_login_page() {
    // Write code here that turns the phrase above into concrete actions

	driver.get("http://retailm1.upskills.in/account/login");
	String curTitle = driver.getTitle();
	
	Assert.assertEquals(curTitle, "Account Login");
}

@When("user enters correct {string} and {string} and clicks login")
public void user_enters_correct_and_and_clicks_login(String string1, String string2) {
    // Write code here that turns the phrase above into concrete actions
	ulogin.UserLogin(string1,string2);
}






@Then("User homepage should be loaded successfully")
public void user_homepage_should_be_loaded_successfully() {
    // Write code here that turns the phrase above into concrete actions

	boolean isloginsuccess=ulogin.isHeaderFound();
	Assert.assertEquals(isloginsuccess, true);
	
}


	
	
}
