package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//div[@class = '_3OO5Xc']//input")
	WebElement search;
	
	@FindBy(xpath = "//button[@class = 'L0Z3Pu']")
	WebElement search_btn;
	
	@FindBy(xpath = "//div[@class = '_1psGvi _3BvnxG']//div//a")
	WebElement login_btn;
	
	@FindBy(xpath = "//span[@class = '_2I9KP_' and text() = 'Women']")
	WebElement Option_Women;
	
	@FindBy(xpath = "//div[@class = '_1fwVde']//span//a[text() = 'Sarees']")
	WebElement option_sarees;
	
	@FindBy(xpath = "//div[@class ='_2QfC02']//button")
	WebElement close_icon;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void closeLoginPage() {
		close_icon.click();
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public SearchPage searchMethod() {
		search.sendKeys("Mobile");
		search_btn.click();
		return new SearchPage();
	}



}
