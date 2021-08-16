package com.tokyotreat.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import com.tokyotreat.Page.HomePage;
import com.tokyotreat.Page.SubscribePage;
import com.tokyotreat.base.BaseClass;

public class SubscribePageTest extends BaseClass {
	HomePage homepage;

	SubscribePage subscribepage;

	@BeforeMethod
	public void beforeMethod() {
		intialisation();
		homepage = new HomePage();
		homepage.priceLink();
		subscribepage = new SubscribePage();

	}

	@Test
	public void classicTab() {

		subscribepage.classicLink();
		subscribepage.seePricing();

		subscribepage.selectPlan();
		subscribepage.getItNow();
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://checkout.tokyotreat.com/tokyotreat-classic-3-month-prepay-plan");

	}

	@Test
	public void selectPriceOfPlan() {
		subscribepage.classicLink();
		subscribepage.seePricing();
		subscribepage.selectPlan();

	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}
}
