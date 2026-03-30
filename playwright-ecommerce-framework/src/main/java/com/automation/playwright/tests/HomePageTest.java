package com.automation.playwright.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.playwright.base.BaseTest;
import com.automation.playwright.pages.HomePage_Lib;
import com.automation.playwright.pages.LoginPage_Lib;
import com.automation.playwright.pages.ProductionSelection;
import com.automation.playwright.pages.RegistrationnPage_Lib;

public class HomePageTest extends BaseTest {
	
	HomePage_Lib home;
    RegistrationnPage_Lib registration;
    LoginPage_Lib login;
    ProductionSelection productSelection;
    
    @BeforeMethod
    public void initPages() {
        home = new HomePage_Lib(page);
        registration = new RegistrationnPage_Lib(page);
        login = new LoginPage_Lib(page);
        productSelection = new ProductionSelection(page);
    }

	@Test(priority = 0)
	public void navigateToRegistrationPageTest() {
		home.acceptCookies();
		home.confirmLocation();
		home.clickMyAccount();
		Assert.assertTrue(home.clickCreateAccount());
	}

	@Test(priority = 1)
	public void createAnAccount() {
		Assert.assertTrue(registration.createAnAccount());
	}

	@Test(priority = 2)
	public void login() {
		Assert.assertTrue(login.login());
	}

	@Test(priority = 3)
	public void productSelection() {
		Assert.assertTrue(productSelection.productSelection());
	}

	@Test(priority = 4)
	public void placeOrder() {
		Assert.assertTrue(productSelection.checkPaymentDeclined());
	}
	
	@Test(priority = 5)
	public void emptyCart() {
		Assert.assertTrue(productSelection.emptyCart());
	}

	@Test(priority = 6)
	public void logOut() {
		Assert.assertTrue(login.logout());
	}

}
