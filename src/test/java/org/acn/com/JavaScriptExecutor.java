package org.acn.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://adactin.com/HotelApp/index.php");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		// username and password highlighted by green color and red box
		WebElement username = driver.findElement(By.id("username"));
		j.executeScript("arguments[0].setAttribute('style','background: green; border: solid 2px red');", username);
		username.sendKeys("venkat");
		WebElement password = driver.findElement(By.id("password"));
		j.executeScript("arguments[0].setAttribute('style','background: green; border: solid 2px red');", password);
		username.sendKeys("venkat@1234");
		Thread.sleep(2000);
		// Login button highlighted by yellow color and green box
		WebElement login = driver.findElement(By.id("login"));
		j.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px green');", login);
		login.click();
		}


}
