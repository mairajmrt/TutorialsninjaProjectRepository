package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	WebElement searchBtn;

	public SearchProductPage(WebDriver driver123) {
		this.driver = driver123;
		PageFactory.initElements(driver,this);
	}

	public void setSearchField(String searchItem) {
		searchField.sendKeys(searchItem);
	}
	
	public void searchProduct() {
		searchBtn.click();
	}
	
}
