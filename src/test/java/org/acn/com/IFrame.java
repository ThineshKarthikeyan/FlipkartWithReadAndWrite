package org.acn.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrame {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		int a = driver.findElements(By.tagName("iframe")).size();
		System.out.println(a);
		WebElement frame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
//		driver.switchTo().frame(frame);
		driver.switchTo().frame(0);
		
		
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Thinesh");
	}

}
