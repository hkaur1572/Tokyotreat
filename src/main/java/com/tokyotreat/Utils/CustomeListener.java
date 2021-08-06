package com.tokyotreat.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tokyotreat.base.BaseClass;

public class CustomeListener extends BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test Starts" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test Failed" + result.getMethod().getMethodName() + "Take Screen Shot!!!!!");
		Utils.takeFailedTestCasesScreenShot(result.getTestName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
