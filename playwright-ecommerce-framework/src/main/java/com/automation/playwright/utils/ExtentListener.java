package com.automation.playwright.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.playwright.base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

public class ExtentListener implements ITestListener {

	private static ExtentReports extent = ExtentReport.initReport();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		test.get().fail(result.getThrowable());

		try {
			Object currentClass = result.getInstance();
			Page page = ((BaseTest) currentClass).getPage();

			String screenshotPath = ScreenshotUtil.capture(page, result.getMethod().getMethodName());

			test.get().addScreenCaptureFromPath(screenshotPath);

		} catch (Exception e) {
			test.get().fail("Screenshot capture failed: " + e.getMessage());
		}
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}