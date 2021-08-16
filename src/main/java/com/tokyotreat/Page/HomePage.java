package com.tokyotreat.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tokyotreat.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(css = "ul[class='nav navbar-nav navbar-links']>li:first-of-type")
	WebElement price;

	public HomePage() {

		waitForDocumentCompleteState(15);
		PageFactory.initElements(driver, this);

	}

	public SubscribePage priceLink() {

		price.click();

		return new SubscribePage();
	}

}
