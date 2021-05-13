package com.qa.flipkart.util;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestUtil {
	
	public static long IMPLICIT_WAIT = 20;
	public static long PAGELOAD_TIMEOUT = 10;
			
	public static String captureScreenshot(WebDriver driver, String scName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir")+"\\Sreenshots\\"+scName+System.currentTimeMillis()+".png";
		
		FileUtils.copyFile(src, new File(dest));
		
		return dest;
	}
	
}
