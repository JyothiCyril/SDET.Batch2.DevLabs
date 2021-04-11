package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC_Amazon_002 extends TestBase {
	
	@Test
	public void AmazonCareers() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//JavascriptExecutor Js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
				
		WebElement ele = AmazonOR.getCareersLink();
		System.out.println(ele.getText());
		Thread.sleep(3000);
		//Js.executeScript("arguments[0].scrollIntoView()",ele);
		Thread.sleep(3000);
		
		ele.click();
		Thread.sleep(3000);
		boolean contains = driver.getCurrentUrl().contains("jobs");
		
		if(contains) {
			Assert.assertTrue(true);
			
		}else {
			getScreenshot(driver,"AmazonCareers");
			Assert.assertTrue(false);
		}
		
		
	}

}
