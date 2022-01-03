package org.acn.com;

import java.awt.AWTException;
import java.io.IOException;import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricbuzz {
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url = "https://www.cricbuzz.com/";
		driver.get(url);
		driver.manage().window().maximize();
		WebElement form = driver.findElement(By.name("form"));
		driver.switchTo().frame(form);
		
		driver.findElement(By.xpath("/html/body/header/div/nav/div[7]/div/div/form/div/div/div/span")).click();
		
	}
	
}
	
	
