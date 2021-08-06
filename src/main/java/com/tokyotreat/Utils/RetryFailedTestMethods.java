package com.tokyotreat.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tokyotreat.base.BaseClass;

public class RetryFailedTestMethods extends BaseClass implements IRetryAnalyzer {

	int counter;
	int maxCounter = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < maxCounter) {
			counter++;
			return true;
		}
		return false;
	}
}
