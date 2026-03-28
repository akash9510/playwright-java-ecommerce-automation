package com.automation.playwright.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.playwright.base.BaseTest;
import com.automation.playwright.pages.HomePage_Lib;

public class HomePageTest extends BaseTest {
	
	@Test
    public void navigateToRegistrationPageTest() {

        HomePage_Lib home = new HomePage_Lib(page);

        home.acceptCookies();

        home.confirmLocation();
        home.clickMyAccount();
        home.clickCreateAccount();

        // ✅ Validation
        boolean isOnRegistrationPage =
                page.url().contains("account/create");

        Assert.assertTrue(isOnRegistrationPage,
                "User is not navigated to Registration Page");
    }

}
