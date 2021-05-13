package com.qa.flipkart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.flipkart.base.TestBase;
import com.qa.flipkart.pages.HomePage;
import com.qa.flipkart.pages.ReviewPage;
import com.qa.flipkart.pages.SearchPage;

public class SearchPageTest extends TestBase{
	
	public static SearchPage searchPageObject;
	public static HomePage homeObject;
	public static ReviewPage reviewPageObject;
	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initiliazation();
		searchPageObject = new SearchPage();
		homeObject = new HomePage();
	}
	
	
	@Test()
	public void selectDesiredItem() throws InterruptedException {
		homeObject.closeLoginPage();
		Thread.sleep(1000);
		homeObject.searchMethod();
		Thread.sleep(1000);
		searchPageObject.assuredProduct();
		Thread.sleep(1000);
		searchPageObject.selectBrand();
		Thread.sleep(1000);
		searchPageObject.priceRange();
		Thread.sleep(1000);
		//reviewPageObject = searchPageObject.selectMobile();
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void destroy() {
		driver.close();
	}

}
