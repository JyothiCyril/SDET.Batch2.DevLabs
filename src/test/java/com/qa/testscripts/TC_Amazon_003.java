package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class TC_Amazon_003 extends TestBase{
	
	
	@Test
	public void AmazonRegister() throws IOException {
		
		WebElement ele = AmazonOR.getAccountsandLists();		
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();		
		
		AmazonOR.getregLink().click();		
		String title = driver.getTitle();
		
		Reporter.log(title,true);		
		
		if(title.contains("Registration")) {
			Assert.assertTrue(true);
			
		}else {
			getScreenshot(driver,"AmazonRegister");
			Assert.assertTrue(false);
		}	

	}


}
