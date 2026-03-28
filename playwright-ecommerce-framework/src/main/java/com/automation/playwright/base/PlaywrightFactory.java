package com.automation.playwright.base;

import com.automation.playwright.utils.ConfigReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    public Page initBrowser() {

        ConfigReader config = new ConfigReader();

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(config.get("headless")))
        );

        if (Boolean.parseBoolean(config.get("mobile"))) {
            context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(375, 812));
        } else {
            context = browser.newContext();
        }

        page = context.newPage();
        page.navigate(config.get("url"));

        return page;
    }

    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
