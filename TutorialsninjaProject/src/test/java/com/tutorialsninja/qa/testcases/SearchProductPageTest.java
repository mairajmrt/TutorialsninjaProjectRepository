package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.SearchProductPage;

public class SearchProductPageTest extends Base {

	@BeforeMethod

	public void setup() throws IOException {
		openBrowserWithWebApp();
	}

	@Test(priority = 1)

	void serachValidProduct() {
		SearchProductPage sp=new SearchProductPage(driver);
		sp.setSearchField("HP");
		sp.searchProduct();
		Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).getText(), "HP LP3065");
	}

	@Test(priority = 2)

	void serachInValidProduct() {
		SearchProductPage sp=new SearchProductPage(driver);
		sp.setSearchField("HP123");
		sp.searchProduct();
		String actaulProductName = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"))
				.getText();
		String expectedProductName = "There is no product that matches the search criteria.";
		Assert.assertEquals(actaulProductName, expectedProductName);
	}

	@AfterMethod

	public void terDown() {
		closeBrowserWithWebApp();
	}

}
