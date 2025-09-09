package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.utility.Base;

public class SearchProduct extends Base {

	@BeforeMethod

	public void setup() {
		openBrowserApplication();
	}

	@Test(priority = 1)

	void serachValidProduct() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String actaulProductName = driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).getText();
		String expectedProductName = "HP LP3065";
		Assert.assertEquals(actaulProductName, expectedProductName);
	}

	@Test(priority = 2)

	void serachInValidProduct() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP123");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String actaulProductName = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"))
				.getText();
		String expectedProductName = "There is no product that matches the search criteria.";
		Assert.assertEquals(actaulProductName, expectedProductName);
	}

	@AfterMethod

	public void terDOwn() {
		if (driver != null) {
			driver.quit();
		}
	}

}
