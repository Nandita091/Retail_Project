package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ReviewPage {
	static WebDriver driver;
	By selectCheckbox=By.xpath("//*[@id=\"form-review\"]/div/table/tbody/tr[1]/td[1]/input");
	By deleteButton=By.cssSelector("#content > div.page-header > div > div > button");
	By productName=By.id("input-product");
	By status=By.xpath("//*[@id=\"input-status\"]/option[3]");
	By author=By.id("input-author");
	By dateAdded=By.id("input-date-added");
	By filterButton=By.cssSelector("#button-filter");
	public static By ProductName=By.xpath("//*[@id=\"form-review\"]/div/table/tbody/tr/td[2]");
	static By successfulDeletion=By.xpath("//*[contains(text(),\"Success\")]");
	//WebElement ProductName=driver.findElement(By.xpath("//*[@id=\"form-review\"]/div/table/tbody/tr/td[2]")).getText();
	public ReviewPage(WebDriver driver)
	{
		ReviewPage.driver =driver;
	}
	public void checkboxSelect()
	{
		driver.findElement(selectCheckbox).click();
	}
	public void deleteReview()
	{
		driver.findElement(deleteButton).click();
	}
	public void typeProductname(StringBuffer product)
	{
		driver.findElement(productName).sendKeys(product);
	}
	public void selectStatus()
	{
		driver.findElement(status).click();
	}
	public void typeAuthorName(String a)
	{
		driver.findElement(author).sendKeys(a);
	}
	public void typeDateAdded(String d)
	{
		driver.findElement(dateAdded).sendKeys(d);
	}
	public void clickFilterButton()
	{
		driver.findElement(filterButton).click();
	}
	public void clearAuthor() {
		driver.findElement(author).clear();
	}
	public void clearProductName() {
		driver.findElement(productName).clear();
	}
	public void cleardateAdded() {
		driver.findElement(dateAdded).clear();
	}
	public static boolean successfulReviewDeletion()
	{
		boolean success;
		try
		{
			driver.findElement(successfulDeletion);
			success = true;
		}
		catch(NoSuchElementException e)
		{
			success = false;
		}
		return success;
		
	}
	
}
