package practicePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicSearch {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurabh\\OneDrive\\Desktop\\New folder\\Selenium\\Jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing");
		Thread.sleep(2000);
		List<WebElement> ele = driver.findElements(By.xpath("//ul[@class='erkvQe']//li//div[@class='sbl1']"));
		
		for(int i=0; i<ele.size(); i++) {
			if(ele.get(i).getText().contains("testing tools")) {
				ele.get(i).click();
			}
		}
		

	}

}
