package com.automation.playwright.pages;

import static com.automation.playwright.objects.RegistrationPage_WebE.*;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;

public class RegistrationnPage_Lib {

	private Page page;

	public RegistrationnPage_Lib(Page page) {
		this.page = page;
	}
	public boolean createAnAccount() {
		try {
			
			page.waitForLoadState(LoadState.LOAD);
			
			// First Name & Last Name
			page.fill(txt_FirstName, "TestFirstName");
			page.fill(txt_LastName, "TestLastName");

			// DOB Selection
			page.click(txt_Birthday);
			page.locator(slct_datePickerYear).selectOption("1993");

			page.locator(slct_datePickerMonth).selectOption(new SelectOption().setLabel("Jan"));

			page.click(lnk_FirstDate);

			// Gender
			page.locator(slct_Gender).selectOption(new SelectOption().setLabel("Male"));

			// Email & Password
			page.fill(txt_EmailAddress, "test123@gmail.com");
			page.fill(txt_Password, "Testing@123");
			page.fill(txt_ConfirmPassword, "Testing@123");

			// Subscribe checkbox (safe click)
			if (!page.isChecked(chk_IsSubscribed)) {
				page.check(chk_IsSubscribed);
			}

			// Create Account
			page.click(btn_CreateAnAccount);
			page.waitForLoadState(LoadState.LOAD);
			page.waitForSelector(lbl_SucessMessage);
			
			

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
