package practicePackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoItPractice {
	
	public static void main(String args[]) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurabh\\OneDrive\\Desktop\\New folder\\Selenium\\Jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://tinyupload.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type='file']")).click();
		Runtime.getRuntime().exec("C:\\Users\\Saurabh\\OneDrive\\Desktop\\New folder\\Selenium\\AutoIt\\FileUploadScript1.exe");
		Thread.sleep(2000);
	}

}
