package com.tokyotreat.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tokyotreat.base.BaseClass;

public class CheckoutPage extends BaseClass {
	Actions action = new Actions(driver);
	@FindBy(id = "account_form_first_name")
	WebElement firstname;
	@FindBy(id = "account_form_last_name")
	WebElement lastname;
	@FindBy(id = "account_form_email")
	WebElement emailid;
	@FindBy(id = "account_form_password")
	WebElement pass;
	@FindBy(css = "button[class='g-recaptcha submit']")
	WebElement signup;

	public CheckoutPage() {
		waitForDocumentCompleteState(15);
		PageFactory.initElements(driver, this);

	}

	public void firstName() {
		firstname.sendKeys("abc");
	}

	public void lastName() {
		lastname.sendKeys("chauhan");
	}

	public void emailId() {
		emailid.sendKeys("123@gmail.com");
	}

	public void password() {
		pass.sendKeys("fghk");
	}

	public void submitButton() {
		action.click(signup).build().perform();

	}

	public void createAnAccount() {
		firstName();
		lastName();
		emailId();
		password();
		submitButton();
	}
}
