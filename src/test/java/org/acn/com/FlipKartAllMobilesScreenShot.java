package org.acn.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKartAllMobilesScreenShot {
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url = "https://www.flipkart.com/";
		driver.get(url);
		driver.manage().window().maximize();
		File f = new File("C:\\Users\\Thinesh\\eclipse-workspace\\OverallFlipkart\\src\\test\\resources\\ExcelFile\\Sample"+ System.currentTimeMillis() +".xlsx");
		
		Workbook w = new XSSFWorkbook();
		Sheet s1 = w.createSheet("Thinesh");
		Row r1 = s1.createRow(0);
		Cell c1 = r1.createCell(0);
		c1.setCellValue("Mobile Names");
		FileOutputStream d = new FileOutputStream(f);
		w.write(d);
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Mobiles",Keys.ENTER);			
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement numberOfPages = driver.findElement(By.xpath("//span[contains(text(),'Page 1 of')]"));
		String pageNumber = numberOfPages.getText();
		String[] totalPages = pageNumber.split(" ");
		int x = Integer.parseInt(totalPages[3]);
		
		for (int j = 1; j < 2; j++) {	
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			List<WebElement> listOfMobiles = driver.findElements(By.className("_4rR01T"));
			int numberOfMobiles = listOfMobiles.size();
			for (int i = 0; i < numberOfMobiles; i++) {
				WebElement names = listOfMobiles.get(i);
				String name = names.getText();				
				Row r = s1.createRow(i+1);
				Cell c = r.createCell(0);
				c.setCellValue(name);
				FileOutputStream d1 = new FileOutputStream(f);
				w.write(d1);
						
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_4rR01T'])[1]")));
				
				
				WebElement element = driver.findElement(By.xpath("(//div[@class='_4rR01T'])["+(i+1)+"]"));	
				element.click();
				String parentWindow = driver.getWindowHandle();
				
				Set<String> allWindow = driver.getWindowHandles();
				for (String a : allWindow) {
					if (!a.equals(parentWindow)) {
						driver.switchTo().window(a);

						WebElement particularName = driver.findElement(By.xpath("//span[contains(@class,'NuC')]"));
						String mobileName = particularName.getText();
																
						TakesScreenshot s = (TakesScreenshot)driver;
						File source = s.getScreenshotAs(OutputType.FILE);
						String title1 = driver.getTitle();
						File target = new File("C:\\Users\\Thinesh\\eclipse-workspace\\OverallFlipkart\\target\\" + title1 + ".png");
						FileUtils.copyFile(source, target);
						
						if(i==3) {
							FileInputStream f1 = new FileInputStream(f);
							Workbook w1 = new XSSFWorkbook(f1);
							Sheet s2 = w.getSheet("Thinesh");
							Row r2 = s2.getRow(i+1);
							Cell c2 = r2.getCell(0);
							String c3 = c2.toString();
							System.out.println(c3);
							System.out.println(mobileName);
							if (mobileName.contains(c3)) {
								System.out.println("Yes, It Matches!!!!");
							}
							else {
								System.out.println("It doesn't");
								
							}
						}
					
						for (String b : allWindow) {
							if (!b.equals(parentWindow)) {
								driver.close();
								driver.switchTo().window(parentWindow);
							}
						}
						
				}
						
			}
			}
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		}
	
}
