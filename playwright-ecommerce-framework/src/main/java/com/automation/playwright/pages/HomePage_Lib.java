package com.automation.playwright.pages;

import com.microsoft.playwright.Page;
import static com.automation.playwright.objects.HomePage_WebE.*;

public class HomePage_Lib {

	private Page page;

	public HomePage_Lib(Page page) {
		this.page = page;
	}

	// Accept Cookies
	public void acceptCookies() {
		if (page.locator(btn_AcceptCookies).isVisible()) {
			page.click(btn_AcceptCookies);
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
	public void clickCreateAccount() {
		page.click(btn_CreateAnAccount);
	}

}
