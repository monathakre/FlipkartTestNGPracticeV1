package com.qa.flipkart.util;

import java.io.File;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersTestNG implements ITestListener{
	
	public void onStart(ITestContext context) {
		System.out.println("On start method started");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("on finish method started");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
	}
	
	public void onTestPassed(ITestResult result) {
		System.out.println("Test Passed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped");
	}

}
