package com.automation.playwright.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.playwright.base.BaseTest;
import com.automation.playwright.pages.HomePage_Lib;
import com.automation.playwright.pages.LoginPage_Lib;
import com.automation.playwright.pages.RegistrationnPage_Lib;

public class HomePageTest extends BaseTest {

	@Test(priority = 0)
    public void navigateToRegistrationPageTest() {

        HomePage_Lib home = new HomePage_Lib(page);
        home.acceptCookies();
        home.confirmLocation();
        home.clickMyAccount();
        Assert.assertTrue(home.clickCreateAccount());
    }
	
	@Test(priority = 1)
    public void createAnAccount() {

        RegistrationnPage_Lib registration = new RegistrationnPage_Lib(page);
        Assert.assertTrue(registration.createAnAccount());
    }
	
	@Test(priority = 2)
    public void login() {

        LoginPage_Lib login = new LoginPage_Lib(page);
        Assert.assertTrue(login.login());
    }

}
