package com.tokyotreat.test;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tokyotreat.Page.HomePage;
import com.tokyotreat.base.BaseClass;

public class HomePageTest extends BaseClass {
	HomePage homepage;

	@BeforeMethod
	public void beforeMethod() {

		intialisation();

		homepage = new HomePage();

	}

	@Test
	public void homePage() {
		homepage.priceLink();

		Assert.assertEquals(driver.getCurrentUrl(), "https://tokyotreat.com/subscribe");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
