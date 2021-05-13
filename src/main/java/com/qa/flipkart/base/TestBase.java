package com.qa.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.flipkart.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fp = new FileInputStream("C:\\Users\\Saurabh\\eclipse-workspace\\flipkart\\src\\main\\java\\com\\qa\\flipkart\\config\\config.properties");
			prop.load(fp);			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		public static void initiliazation() {
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurabh\\eclipse-workspace\\flipkart\\src\\main\\java\\com\\qa\\flipkart\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "");
				driver = new FirefoxDriver();
			}
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		}
		
		
	
}
