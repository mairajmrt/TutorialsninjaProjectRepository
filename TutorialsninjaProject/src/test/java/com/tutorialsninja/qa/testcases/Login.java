package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.utility.Base;

public class Login extends Base {

	@BeforeMethod

	public void setup() {
		openBrowserApplication();
	}

	@Test(priority = 1)

	public void verifyLoginWithValidCredentials() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj12345678@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Account']")).isDisplayed());
		String expectedValue = "Account";
		String actualValue = driver.findElement(By.xpath("//a[normalize-space()='Account']")).getText();
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 2)

	public void verifyLoginWithInvalidEmailAndValidPassword() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj12345678123@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 3)

	public void verifyLoginWithValidEMailAndInvalidPassword() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj12345678@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 4)

	public void verifyLoginWithInvalidEMailAndInvalidPassword() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 5)

	public void verifyLoginWithInvalidEMailAndValidPassword() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj1234567845678@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password...";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@AfterMethod

	public void terDOwn() {
		if (driver != null) {
			driver.quit();
		}
	}

}
