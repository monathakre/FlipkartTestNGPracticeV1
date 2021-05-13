package com.qa.flipkart.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.flipkart.util.TestUtil;

public class Demof {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurabh\\OneDrive\\Desktop\\Selenium\\Jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//div[@class ='_2QfC02']//button")).click();
		driver.findElement(By.xpath("//div[@class = '_3OO5Xc']//input")).sendKeys("mobile");
		driver.findElement(By.xpath("//button[@class = 'L0Z3Pu']")).click();
		
		Thread.sleep(10000);
		String mobile = "Redmi 9 Prime (Sunrise Flare, 64 GB)";
		
		List<WebElement> mobile_list = driver.findElements(By.xpath("//div[@class='_4ddWXP']//a[@class='s1Q9rs']"));
		for(WebElement el : mobile_list) {
			if(mobile.contains((CharSequence) el)){
				el.click();
			}
		Thread.sleep(10000);
		Select s = new Select(driver.findElement(By.xpath("//div[@class='_1YAKP4']//select[@class = '_2YxCDZ']")));
		s.selectByValue("10000");
		Thread.sleep(10000);
		Select s1 = new Select(driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class = '_2YxCDZ']")));
		s1.selectByValue("18000");
		
		Thread.sleep(20000);
		String nm = "mi";
		driver.findElement(By.xpath("//div[@class='_2pBqj6']//input")).sendKeys(nm);
		
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class = '_2iDkf8 t0pPfW']//div[@class='_3879cV']"));
		for(WebElement ele : checkbox) {
			if(nm.equalsIgnoreCase(ele.getText())) {
				ele.click();
			}
		}
		
		Thread.sleep(20000);
		driver.findElement(By.xpath("//div[@class='_2iDkf8 shbqsL']//input[@type = 'checkbox']")).click();
		Thread.sleep(20000);
		
		}

	}

}
