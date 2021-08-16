package com.tokyotreat.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tokyotreat.base.BaseClass;

public class SubscribePage extends BaseClass {
	Actions action = new Actions(driver);
	@FindBy(css = "a[class='choice classic ']")
	WebElement classic;

	@FindBy(css = "a[data-type='classic' ][class='btn btn-primary btn-block']")
	WebElement seepricing;
	@FindBy(css = "a[data-id='tokyotreat-classic-3-month-prepay-plan']")
	WebElement selectplan;
	@FindBy(css = "a[class='btn btn-checkout']")
	WebElement getitnow;

	public SubscribePage() {
		waitForDocumentCompleteState(15);
		PageFactory.initElements(driver, this);

	}

	public void classicLink() {

		action.click(classic).build().perform();

	}

	public void seePricing() {
		action.click(seepricing).build().perform();
	}

	public void selectPlan() {
		action.click(selectplan).build().perform();
	}

	public CheckoutPage getItNow() {
		getitnow.click();
		return new CheckoutPage();

	}

	public void chooseYourPlan() {
		classicLink();
		seePricing();
		selectPlan();
		getItNow();
	}
}
