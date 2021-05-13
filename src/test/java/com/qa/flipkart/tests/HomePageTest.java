package com.qa.flipkart.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.flipkart.base.TestBase;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.LoginPage;
import com.qa.flipkart.pages.SearchPage;
import com.qa.flipkart.util.ListnersTestNG;
import com.qa.flipkart.util.Log;


@Listeners(ListnersTestNG.class)
public class HomePageTest extends TestBase{
	
	HomePage homePageObject;
	LoginPage loginPageObject;
	SearchPage s;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws IOException {
		initiliazation();
		homePageObject = new HomePage();
		loginPageObject = new LoginPage();
		//homePageObject.closeLoginPage();
		homePageObject = loginPageObject.login();
		Reporter.log("driver started");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Saurabh\\eclipse-workspace\\flipkart\\test-output\\old\\aa.png"));
	}
	
	
	@Test(priority = 0)
	public void title_validation() {
		Log.startTest("Validate title");
		String title = homePageObject.validateTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		Log.info("Titles matched");
	}
	
	@Test(priority = 1)
	public void searchItem() {
		s = homePageObject.searchMethod();
	}
	
	@Test
	public void skipm() {
		throw new SkipException("method skipped");
	}
	
	@AfterMethod
	public void destroy() {
		driver.close();
		Reporter.log("driver closed");
	}

}
