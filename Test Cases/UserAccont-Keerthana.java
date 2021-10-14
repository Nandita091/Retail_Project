package testcases;


	

	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;
	import pages.UserLoginPage;

	public class UserAccont {
		static String driverPath = "C:\\Users\\Padma\\Desktop\\";
		WebDriver driver = new ChromeDriver();
		UserLoginPage login = new UserLoginPage(driver);
		@Test(priority=1)
		public void verifylogin()
		{
		
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			
			driver.get("http://retailm1.upskills.in/account/login");
			driver.manage().window().maximize();
			login.typeemail("keerthana@gmail.com");
			login.typepassword("Keerthana@4417");
			login.clickLoginButton();
		}
		@Test(priority=2)
		public void editUserDetails() {
			login.clickEditAccount();
			login.clearFirstName();
			login.typeFirstname("keerthana");
			login.clearLasttname();
			login.typeLastname("S");
			login.clickContinueButton();
			login.verifyEdit();
			//*[@id="System_nyHsmShk"]/div/text()
			//*[contains(@id,'System_nyHsmShk')]//child::div
			driver.close();
		}		
}
