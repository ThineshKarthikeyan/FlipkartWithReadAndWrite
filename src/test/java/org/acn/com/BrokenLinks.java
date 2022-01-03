package org.acn.com;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		String cUrl = driver.getCurrentUrl();
		String url;
		HttpURLConnection huc = null;
		List<WebElement> a = driver.findElements(By.tagName("a"));

		for (int i = 0; i < a.size(); i++) {
			WebElement b = a.get(i);
			url = b.getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("Link is empty");
				continue;
				}
			if (!url.startsWith(cUrl)) {
				System.out.println("This link belongs to other site");
				continue;
			}
			
			huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			int respCode = huc.getResponseCode();
			
			if (respCode > 400) {
				System.out.println("Invalid link" + url);
			}
			
			else {
				System.out.println("Valid link" + url);
			}
		}
		
				
		

	}

}
