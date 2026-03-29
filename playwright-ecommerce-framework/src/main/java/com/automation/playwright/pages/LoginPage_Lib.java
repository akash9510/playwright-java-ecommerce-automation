package com.automation.playwright.pages;

import static com.automation.playwright.objects.LoginPage_WebE.*;

import com.automation.playwright.utils.ConfigReader;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class LoginPage_Lib {

	private Page page;

	public LoginPage_Lib(Page page) {
		this.page = page;
	}

	public boolean login() {
		try {

			ConfigReader config = new ConfigReader();

			page.waitForLoadState(LoadState.LOAD);

			// First Name & Last Name
			page.fill(txt_EmailAddress, config.get("email"));
			page.fill(txt_Password, config.get("password"));

			page.click(btn_Login);
			page.waitForSelector(lbl_EmailAddress);

			String strEmailAddress = page.textContent(lbl_EmailAddress);

			if (strEmailAddress.equals(config.get("email"))) {
				System.out.println("Login Successfull!!");

				return true;
			} else {
				System.err.println("Login unsuccessfull");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean logout() {
		try {

			page.hover(ico_MyAccount);
			page.waitForSelector(lnk_Logout);

			page.click(lnk_Logout);
			page.waitForSelector(btn_Login);

			if (page.isVisible(btn_Login)) {
				System.out.println("Logout Successfull!!");

				return true;
			} else {
				System.err.println("Logout");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
