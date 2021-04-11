package com.qa.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{

	ExtentHtmlReporter HtmlReporter;
	ExtentReports xReports;
	ExtentTest xTest;

	public void onStart(ITestContext testContext) {
		String name = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String ReportName = "Test-Results" + name +".html";

		HtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" + ReportName);
		HtmlReporter.config().setDocumentTitle("Automation Testing");
		HtmlReporter.config().setReportName("Function Test Report");
		HtmlReporter.config().setTheme(Theme.DARK);
		HtmlReporter.config().setAutoCreateRelativePathMedia(true);

		xReports = new ExtentReports();
		xReports.attachReporter(HtmlReporter);
		xReports.setSystemInfo("QA Name", "Jyothi");
		xReports.setSystemInfo("OS", "WINDOWS");
	}

	public void onTestSuccess(ITestResult tr) {
		xTest =  xReports.createTest(tr.getName());		  
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		xTest =  xReports.createTest(tr.getName());		  
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File screenshot = new File(screenshotPath); 
		if(screenshot.exists())
		{
			try {
				xTest.fail("Screenshot is below:" + xTest.addScreenCaptureFromPath(screenshotPath));
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult tr) {
		xTest =  xReports.createTest(tr.getName());		  
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	}

	public void onFinish(ITestContext testContext) {		  
		xReports.flush();		  
	}

}
