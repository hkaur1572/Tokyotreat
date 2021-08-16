package com.tokyotreat.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tokyotreat.Page.CheckoutPage;
import com.tokyotreat.Page.HomePage;
import com.tokyotreat.Page.SubscribePage;
import com.tokyotreat.base.BaseClass;

public class CheckoutPageTest extends BaseClass {
	HomePage homepage;

	SubscribePage subscribepage;
	CheckoutPage checkoutpage;

	@BeforeMethod
	public void beforeMethod() {
		intialisation();
		homepage = new HomePage();
		homepage.priceLink();
		subscribepage = new SubscribePage();
		subscribepage.chooseYourPlan();
		checkoutpage = new CheckoutPage();

	}

	@Test
	public void SignUp() {

		checkoutpage.createAnAccount();
		Assert.assertEquals("icon ion-checkmark-circled", "icon ion-checkmark-circled");

	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}

}
