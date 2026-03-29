package com.automation.playwright.objects;

public class ProductSelection_WebE {
	
	public static final String lnk_NewIn = "//a[@title='NEW IN']";
	public static final String lnk_NewArrival = "//a[@title='NEW ARRIVALS']";
	public static final String lnk_FirstProduct = "(//span[@class='product-image-container'])[1]";
	public static final String btn_AddToBasket = "#product-addtocart-button";
	public static final String lnk_ProccedToCheckout = "#top-cart-btn-checkout";
	public static final String lbl_ProductTitle = ".page-title";
	public static final String lbl_ProductName_Checkout = ".product-item-name";
	public static final String txt_StreetAddress = ".field.street.admin__control-fields.required .input-text";
	public static final String txt_Country = "//div[@name='shippingAddress.region']//input";
	public static final String txt_City = "//div[@name='shippingAddress.city']//input";
	public static final String txt_PostCode = "//div[@name='shippingAddress.postcode']//input";
	public static final String txt_PhoneNumber = "//div[@name='shippingAddress.telephone']//input";
	public static final String btn_SaveContninue = ".button.action.continue.primary";
	public static final String lst_PaymentGroup = ".payment-group";
	public static final String chk_AddressManually = ".field.manual-address-toggle input";
	public static final String ico_Logo = ".logo";
	public static final String ico_Cart = ".action.showcart";
	
	public static final String btn_ClearBasket = "#empty_cart_button";
	public static final String btn_Yes = ".action-primary.action-accept";
	public static final String lbl_EmptyCart = ".cart-empty p.title";

}
