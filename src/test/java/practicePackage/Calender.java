package practicePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurabh\\OneDrive\\Desktop\\New folder\\Selenium\\Jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		driver.findElement(By.id("src")).sendKeys("Nagpur");
		System.out.println("1");
		driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
		System.out.println("2");
		String monthYear = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tr[@class='rb-monthHeader']//td[@class='monthTitle']")).getText();
		System.out.println(monthYear);
		while(!monthYear.contains("Mar")) {		
			System.out.println(monthYear);
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='next']//button")).click();
			Thread.sleep(1000);
			monthYear = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tr[@class='rb-monthHeader']//td[@class='monthTitle']")).getText();
		}
		
		String date = "6";
		List<WebElement> day = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//tr//td[contains(@class, 'day')]"));
		for(int i=0; i<day.size(); i++) {
			if(day.get(i).getText()==date) {
				day.get(i).click();
				break;
			}
		}
		
		//driver.findElement(By.id("search_btn"));
		//driver.close();

	}

}
