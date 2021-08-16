package com.tokyotreat.Reports;

import java.io.File;
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
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsList extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Extent Report---" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Extent-Reports/" + reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extentReports = new ExtentReports();

		extentReports.attachReporter(htmlReporter);
		extentReports.setSystemInfo("Name of the Host", "localhost");
		extentReports.setSystemInfo("Environemnt", "Dev");
		extentReports.setSystemInfo("Tester Name", "Harpreet");

		htmlReporter.config().setDocumentTitle("Tokyo Treat QA Automation Project"); // Title of the report
																						// generated
		htmlReporter.config().setReportName("Automation Report"); // Name of the report generated
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart in the report
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		test = extentReports.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test = extentReports.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extentReports.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extentReports.flush();
	}

}
