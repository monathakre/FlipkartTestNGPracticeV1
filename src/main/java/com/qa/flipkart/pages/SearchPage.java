package com.qa.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.flipkart.base.TestBase;

public class SearchPage extends TestBase {
	
	@FindBy(xpath = "//div[@class='_1YAKP4']//select[@class = '_2YxCDZ']")
	WebElement min_val;
	
	@FindBy(xpath = "//div[@class='_3uDYxP']//select[@class = '_2YxCDZ']")
	WebElement max_val;
	
	@FindBy(xpath = "//label[@class='_2iDkf8 shbqsL']//div[@class='_24_Dny _3tCU7L']")
	WebElement fAssured;
	
	@FindBy(xpath = "//div[@class='_2pBqj6']//input")
	WebElement brand;
	
	@FindBy(xpath = "//div[@class = '_2iDkf8 t0pPfW']//div[@class='_3879cV']")
	List<WebElement> checkbox;
	
	@FindBy(xpath = "//div[@class='_4ddWXP']//a[@class='s1Q9rs']")
	List<WebElement> mobile_list;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void priceRange() throws InterruptedException {
		Select s = new Select(min_val);
		s.selectByValue("10000");
		Thread.sleep(10000);
		Select s1 = new Select(max_val);
		s1.selectByValue("25000");
	}
	
	public void assuredProduct() {
		fAssured.click();
	}
	
	public void selectBrand() {
		String nm = "mi";
		brand.sendKeys(nm);
		
		for(WebElement ele : checkbox) {
			if(nm.equalsIgnoreCase(ele.getText())) {
				ele.click();
			}
		}
	}
	
	public ReviewPage selectMobile() {
		String mobile = prop.getProperty("mobile");
		
//		for(WebElement el : mobile_list) {
//			if(mobile.contains((CharSequence) el)) {
//				el.click();
//			}
//		}
		
		for(WebElement el : mobile_list) {
			if(mobile.contains((CharSequence) el)) {
				el.click();
			}
		}
		return new ReviewPage();
	}
	
	

}
