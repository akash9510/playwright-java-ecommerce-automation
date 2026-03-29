package com.automation.playwright.utils;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class ScreenshotUtil {
	
	 public static String capture(Page page, String testName) {

		 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	        String path = "screenshots/" + testName + "_" + timestamp + ".png";

	        page.screenshot(new Page.ScreenshotOptions()
	                .setPath(Paths.get(path))
	                .setFullPage(true));

	        return path;
	    }

}
