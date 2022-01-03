package org.acn.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		
		WebElement table = driver.findElement(By.tagName("table"));
		List<WebElement> tr = table.findElements(By.tagName("tr"));
		for (int i = 1; i < tr.size(); i++) {
			WebElement rows = tr.get(i);
			List<WebElement> th = rows.findElements(By.tagName("td"));
//			for (int j = 0; j < th.size(); j++) {
				WebElement t = th.get(0);
				String q = t.getText();
				System.out.println(q);
			}
		}

	}

//}
