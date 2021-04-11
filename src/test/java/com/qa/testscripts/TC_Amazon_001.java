package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.Utilities.excelUtility;


public class TC_Amazon_001 extends TestBase {

	@Test(dataProvider="getData")
	public void searchItem(String category, String itemname) throws IOException {	

		AmazonOR.setCategoryInput(category);
		AmazonOR.setSearchTextBoxInput(itemname);
		AmazonOR.setMagnifierBtnClick();

		String title = driver.getTitle();
		Reporter.log(title,true);	
		
		if(title.contains(itemname)) {
			Assert.assertTrue(true);
			
		}else {
			getScreenshot(driver,"searchItem");
			Assert.assertTrue(false);
		}	

	}

	@DataProvider
	public String[][] getData() throws IOException{

		// excel file path
		String xlpath = "D:\\Devlabs\\Batch 2\\BroadridgeBatch2\\SDET.Devlabs.Batch2\\src\\test\\java\\com\\qa\\testData\\InputData.xlsx";
		// sheet
		String xlSheet = "Sheet2";
		int rowCount = excelUtility.getRowCount(xlpath, xlSheet);

		int cellCount = excelUtility.getCellCount(xlpath, xlSheet, rowCount);	


		String[][] data = new String[rowCount][cellCount];		

		for(int i=1; i<=rowCount; i++) {

			for(int j=0; j<cellCount; j++) {
				data[i-1][j] = excelUtility.getCellData(xlpath, xlSheet, i, j);; //1,0
			}
		}

		return data;
	}


}
