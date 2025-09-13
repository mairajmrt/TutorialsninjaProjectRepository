package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	
	WebDriver driver;

	@FindBy(linkText = "My Account")
	WebElement btnMyAccount;
	
	@FindBy(linkText = "Register")
	WebElement btnRegister;
	
	@FindBy(linkText = "Login")
	WebElement btnLogin;

	public CommonPage(WebDriver driver123) {
	this.driver=driver123;
	PageFactory.initElements(driver, this);
		
	}
	
	public void registerSetUp() {
		btnMyAccount.click();
		btnRegister.click();
		
	}
	
	public void loginSetUp() {
		btnMyAccount.click();
		btnLogin.click();
		
	}
	
	


}
