package org.acn.com;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	static WebDriver driver;

	public static void main(String[] args) {

	Scanner a = new Scanner(System.in);
	System.out.println("Enter the desire browser name :");
	String s = a.nextLine();	

	if (s.equalsIgnoreCase("c")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	else if (s.equalsIgnoreCase("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();		
	}
	else if (s.equalsIgnoreCase("Internet Explorer")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://demo.automationtesting.in/Alerts.html");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("/html/body/div/div/div/div/div/ul/li[2]/a")).click();;
	driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div[2]/button")).click();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.alertIsPresent());
	Alert q = driver.switchTo().alert();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	System.out.println(q.getText());
	q.dismiss();
	
	
	}
}
