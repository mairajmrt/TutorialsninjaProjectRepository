package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;

public class TC_31 extends Base {
	
	@BeforeClass

	void setup() {
		openBrowserApplication();
		System.out.println("Application is opend successfully");
	}

	@Test
	void homePage() {
		Assert.assertEquals(driver.getTitle(), "Your Store");
		System.out.println("You are sucessfully on home page");
	}
	
	@Test

	void loginPage() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-email']")).isDisplayed()&&driver.findElement(By.xpath("//input[@id='input-password']")).isDisplayed()&&
				driver.findElement(By.xpath("//input[@value='Login']")).isDisplayed());
			System.out.println("Login page opened successfully");
			
	}

	@AfterClass
	void teardown() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(4000);
			driver.quit();
		System.out.println("Application is closed successfully");
		}
	}

	

}
