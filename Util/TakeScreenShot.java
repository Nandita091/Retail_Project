package Util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.TakesScreenshot;

public class TakeScreenShot {
	WebDriver driver;	
	public TakeScreenShot(WebDriver driver)
	{
		this.driver =driver;
	}

	// public static void main(String[] args) {
		 public String screenshot() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM"
	         		+ "ddHHmmss");  
	         LocalDateTime now = LocalDateTime.now();  
	         System.out.println(dtf.format(now));  
	         
	       
	         String failedfilename=("Retailfail"+dtf.format(now)+".jpg");
	         
	        return failedfilename;
		 }
		 
		 public  void takeSnapShot(WebDriver webdriver,String fileWithPath) {
		        //Convert web driver object to TakeScreenshot
			 try {
		        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		        //Call getScreenshotAs method to create image file
		        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		        //Move image file to new destination
		         File DestFile=new File(fileWithPath);
		      //Copy file at destination
		         
		        FileUtils.copyFile(SrcFile, DestFile);
		         }
		         catch(IOException a)
		         {
		        	 
		         }
		    }

}
