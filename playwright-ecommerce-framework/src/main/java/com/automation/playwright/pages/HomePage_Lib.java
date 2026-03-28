package com.automation.playwright.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

import static com.automation.playwright.objects.HomePage_WebE.*;
import static com.automation.playwright.objects.RegistrationPage_WebE.*;

public class HomePage_Lib {

	private Page page;

	public HomePage_Lib(Page page) {
		this.page = page;
	}

	// Accept Cookies
	public void acceptCookies() {
		if (page.locator(btn_AcceptCookies).isVisible()) {
			page.click(btn_AcceptCookies);
			page.waitForSelector(btn_ConfirmLocation);
		}
	}

	// Accept Cookies
	public void confirmLocation() {
		if (page.locator(btn_ConfirmLocation).isVisible()) {
			page.click(btn_ConfirmLocation);
		}
	}

	// Click Sign In
	public void clickMyAccount() {
		page.click(ico_MyAccount);
	}

	// Click Create Account
	public boolean clickCreateAccount() {
		page.click(btn_CreateAnAccountHome);
		page.waitForLoadState(LoadState.LOAD);
		return page.isVisible(txt_FirstName);
	}

}
