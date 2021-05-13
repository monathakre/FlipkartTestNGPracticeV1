package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.flipkart.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='IiD88i _351hSN']//input[@type ='text']")
	WebElement email;
	
	@FindBy(xpath = "//div[@class ='IiD88i _351hSN']//input[@type ='password']")
	WebElement pass;
	
	@FindBy(xpath = "//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement login_btn;
	
	@FindBy(xpath = "//div[@class ='_2QfC02']//button")
	WebElement close;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login() {
		email.sendKeys(prop.getProperty("userID"));
		pass.sendKeys(prop.getProperty("pass"));
		login_btn.click();	
		return new HomePage();
	}

}
