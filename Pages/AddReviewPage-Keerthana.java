package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class AddReviewPage {
	static WebDriver driver;	
	
	By AddReview=By.cssSelector("#content > div.page-header > div > div > a");
	By authorName= By.id("input-author");
	By productName= By.id("input-product");
	By selectPredicted=By.xpath("//*[@id=\"form-review\"]/div[2]/div/ul");
	By reviewText= By.id("input-text");
	By rating= By.xpath("//*[@id=\"form-review\"]/div[4]/div/label[5]/input");
	By dateAdded= By.id("input-date-added");
	By status= By.xpath("//*[@id=\"input-status\"]/option[2]");
	By save=By.cssSelector("#content > div.page-header > div > div > button");
	static By successfulAddition=By.xpath("//*[contains(text(),\"Success\")]");

	public AddReviewPage(WebDriver driver)
	{
		AddReviewPage.driver =driver;
	}
	public void clickAddButton()
	{
		driver.findElement(AddReview).click();
	}
	public void addAuthorName(String a)
	{
		driver.findElement(authorName).sendKeys(a);
	}
	public void addProductName(String p)
	{
		driver.findElement(productName).sendKeys(p);
	}
	public void selectPredicted() {
		WebElement predict=driver.findElement(selectPredicted);
		predict.click();
	}
	public void addText(String t)
	{
		driver.findElement(reviewText).sendKeys(t);
	}
	public void rating()
	{
		driver.findElement(rating).click();
	}
	public void dateAdded(String d)
	{
		driver.findElement(dateAdded).sendKeys(d);
	}
	public void status()
	{
		driver.findElement(status).click();
	}
	
	public void clickSave() {
		driver.findElement(save).click();
	}
	public static boolean successfulReviewAddition()
	{
		boolean success;
		try
		{
			driver.findElement(successfulAddition);
			success = true;
		}
		catch(NoSuchElementException e)
		{
			success = false;
		}
		return success;
		
	}
}
