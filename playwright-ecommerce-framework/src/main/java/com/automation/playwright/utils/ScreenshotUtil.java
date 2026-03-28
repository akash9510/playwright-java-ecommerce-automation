package com.automation.playwright.utils;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class ScreenshotUtil {
	
	 public static String capture(Page page, String testName) {

	        String path = "screenshots/" + testName + ".png";

	        page.screenshot(new Page.ScreenshotOptions()
	                .setPath(Paths.get(path)));

	        return path;
	    }

}
