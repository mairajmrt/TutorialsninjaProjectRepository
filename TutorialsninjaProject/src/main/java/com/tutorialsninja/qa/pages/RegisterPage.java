package com.tutorialsninja.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstnameField;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastnameField;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailField;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephoneField;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement cofirmField;

	public void setFirstnameField(String firststname) {
		firstnameField.sendKeys(firststname);
	}

	public void setLastnameField(String lastname) {
		lastnameField.sendKeys(lastname);;
	}

	public void setEmailField(String email) {
		emailField.sendKeys(email);;
	}

	public void setTelephoneField(String telephone) {
		telephoneField.sendKeys(telephone);;
	}

	public void setPasswordField(String password) {
		passwordField.sendKeys(password);;
	}

	public void setCofirmField(String confirm) {
		cofirmField.sendKeys(confirm);;
	}

	@FindBy(xpath = "//input[@value='0']")
	WebElement subscribeBtn;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyPolicyBtn;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;
	
	public RegisterPage(WebDriver driver123){
	this.driver=driver123;
	PageFactory.initElements(driver, this);
	}
	
	public void registerUser() {
		subscribeBtn.click();
		privacyPolicyBtn.click();
		continueBtn.click();
		
		
	}
	
}
