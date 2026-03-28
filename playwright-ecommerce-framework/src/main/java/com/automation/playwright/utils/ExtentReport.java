package com.automation.playwright.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	private static ExtentReports extent;

    public static ExtentReports initReport() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");

            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("QA Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Akash Gupta");
            extent.setSystemInfo("Framework", "Playwright + TestNG");
        }

        return extent;
    }

}
