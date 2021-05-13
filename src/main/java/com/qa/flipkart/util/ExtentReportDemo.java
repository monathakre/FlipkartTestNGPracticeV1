package com.qa.flipkart.util;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {
	
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	@BeforeTest
	public static void startTest() {
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\Extent"+System.currentTimeMillis()+".html");
		htmlReport.config().setDocumentTitle("Automation report");
		htmlReport.config().setReportName("Functional report");
		htmlReport.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		test = extent.createTest("My test");	
	}
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurabh\\OneDrive\\Desktop\\New folder\\Selenium\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();		
	}
	
	@Test
	public void verifyTitle() {
		Assert.assertEquals("Facebook.com", driver.getTitle());
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Testcase passed is "+result.getName());
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test method skipped is "+result.getName());
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Method failed is "+result.getName());
			test.log(Status.FAIL, "Method failed is "+result.getThrowable());
			String scPath = TestUtil.captureScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(scPath);
		}
		
		driver.close();
		
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	

}
