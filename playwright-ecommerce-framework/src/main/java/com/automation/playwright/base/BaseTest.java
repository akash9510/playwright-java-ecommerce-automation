package com.automation.playwright.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

public class BaseTest {
	
	protected Page page;
    protected PlaywrightFactory factory;

    @BeforeTest
    public void setup() {
        factory = new PlaywrightFactory();
        page = factory.initBrowser();
    }

    @AfterTest
    public void tearDown() {
        factory.tearDown();
    }
    
    public Page getPage() {
        return page;
    }

}
