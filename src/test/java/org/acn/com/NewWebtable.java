package org.acn.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWebtable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		
		List<WebElement> table = driver.findElements(By.xpath("/html/body/div[2]/div/div/main/article/div/div/table"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		for (int k = 0; k < table.size(); k++) {
			System.out.println(k);
			
			WebElement tableNo = table.get(k);
			List<WebElement> tRows = tableNo.findElements(By.tagName("tr"));
			
			for (int i = 0; i < tRows.size(); i++) {
				WebElement row = tRows.get(i);
				List<WebElement> tdata = row.findElements(By.tagName("td"));
				
				for (int j = 0; j < tdata.size(); j++) {
					WebElement data = tdata.get(j);
					String a = data.getText();
					System.out.println(a);
			}
		}	System.out.println("");
		
		
		}

	}

}
