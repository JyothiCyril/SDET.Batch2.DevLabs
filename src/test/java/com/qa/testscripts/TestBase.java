package com.qa.testscripts;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;

public class TestBase {
	WebDriver driver;
	AmazonPages AmazonOR;

	@Parameters({"Browser", "Url"})
	@BeforeClass
	public void setUp(String Browser, String Url) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Software\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","D:\\Selenium Software\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","path of geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Selenium Software\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		AmazonOR = new AmazonPages(driver);
		driver.get(Url);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}



	public void getScreenshot(WebDriver driver, String tname) throws IOException {
		TakesScreenshot Ts = (TakesScreenshot)driver;
		File Source = Ts.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "/Screenshots/" + tname + ".png";
		FileUtils.copyFile(Source, new File(Destination));
		System.out.println("Screenshot captured...");
	}

}
