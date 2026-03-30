package com.automation.playwright.pages;

import static com.automation.playwright.objects.ProductSelection_WebE.*;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class ProductionSelection {

	private Page page;

	public ProductionSelection(Page page) {
		this.page = page;
	}

	public boolean productSelection() {
		boolean bstatus = false;

		try {
			// Wait for page load
			page.waitForLoadState(LoadState.LOAD);

			// Navigate to product
			page.waitForSelector(lnk_NewIn);
			page.hover(lnk_NewIn);

			page.waitForSelector(lnk_NewArrival);
			page.click(lnk_NewArrival);

			page.waitForSelector(lnk_FirstProduct);
			page.click(lnk_FirstProduct);

			// Capture product name
			page.waitForSelector(btn_AddToBasket);
			String strProduct = page.textContent(lbl_ProductTitle);

			// Add to basket
			page.click(btn_AddToBasket);

			page.waitForSelector(lnk_ProccedToCheckout);
			page.click(lnk_ProccedToCheckout);

			page.waitForLoadState(LoadState.LOAD);

			// Validate product on checkout page
			String strProductOnCheckout = page.textContent(lbl_ProductName_Checkout);

			if (strProductOnCheckout.equals(strProduct)) {
				System.out.println("Same Product on checkout!!!");
				bstatus = true;
			} else {
				System.err.println("Different Product found on checkout");
				bstatus = false;
			}

			// =========================
			// Address Section
			// =========================

			page.click(chk_AddressManually);

			Locator streetFields = page.locator(txt_StreetAddress);

			streetFields.nth(0).fill("221B Baker Street");
			page.fill(txt_City, "London");
			page.fill(txt_Country, "London");
			page.fill(txt_PostCode, "NW1 6XE");
			page.fill(txt_PhoneNumber, "+44 7700 900123");

			page.click(btn_SaveContninue);

			// Wait for payment section
			page.waitForSelector(lst_PaymentGroup);

			return bstatus;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean checkPaymentDeclined() {

		boolean bstatus = false;

		try {
			page.waitForLoadState(LoadState.NETWORKIDLE);

			// Select Card option
			page.waitForSelector(rdo_Cards);
			page.click(rdo_Cards);

			page.waitForSelector(frm_SecuredField);

			FrameLocator frame = page.frameLocator(frm_SecuredField);

			frame.nth(0).locator(txt_CardNumber).fill("4111111111111111");

			frame.nth(1).locator(txt_ExpriryDate).fill("03/30");

			frame.nth(2).locator(txt_CVV).fill("737");
			
			page.click(btn_PlaceOrder);

			page.waitForSelector(lbl_ErrorMessage);

			String errorMsg = page.textContent(lbl_ErrorMessage);

			if (errorMsg != null && errorMsg.toLowerCase().contains("declined")) {
				System.out.println("Payment declined as expected");
				bstatus = true;
			} else {
				System.err.println("Payment not declined");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bstatus;
	}

	public boolean emptyCart() {
		boolean bstatus = false;

		try {
			// Wait for page load
			page.waitForLoadState(LoadState.LOAD);

			page.waitForSelector(ico_Logo);
			page.click(ico_Logo);

			page.waitForSelector(ico_Cart);
			page.click(ico_Cart);

			page.waitForLoadState(LoadState.LOAD);
			page.waitForSelector(btn_ClearBasket);
			page.click(btn_ClearBasket);

			page.waitForSelector(btn_Yes);
			page.click(btn_Yes);

			page.waitForSelector(lbl_EmptyCart);

			// Validate Cart is Empty or not
			String strEmptyCart = page.textContent(lbl_EmptyCart);

			if (strEmptyCart.equals("Your Shopping Cart is Empty")) {
				System.out.println("Your Shopping Cart is Empty");
				bstatus = true;
			} else {
				System.err.println("Your Shopping Cart is not Empty");
				bstatus = false;
			}

			return bstatus;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
