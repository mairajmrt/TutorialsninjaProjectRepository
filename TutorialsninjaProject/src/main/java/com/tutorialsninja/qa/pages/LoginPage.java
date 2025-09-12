package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(linkText = "My Account")
	WebElement acountBtn;

	@FindBy(linkText = "Login")
	WebElement loginBtn;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailField;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passField;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn2;

	private WebDriver driver;

	public LoginPage(WebDriver driver123) {
		this.driver = driver123;
		PageFactory.initElements(driver, this);
	}

	public void getEMailAdress(String emailName) {
		acountBtn.click();
		loginBtn.click();
		emailField.sendKeys(emailName);
	}

	public void getPassword(String password) {
		passField.sendKeys(password);
	}

	public void loginPage() {

		loginBtn2.click();
	}

}
