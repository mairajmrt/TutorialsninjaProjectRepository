package com.tutorialsninja.qa.testcases;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginJava {

	private FirefoxDriver driver;

	@Test(priority = 1)

	public void verifyLoginWithValidCredentials() {
		driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/");
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
		driver.quit();
	}

	@Test(priority = 2)

	public void verifyLoginWithInvalidEmailAndValidPassword() {
		driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj12345678123@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);
		driver.quit();
	}

	@Test(priority = 3)

	public void verifyLoginWithValidEMailAndInvalidPassword() {
		driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj12345678@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);
		driver.quit();
	}

	@Test(priority = 4)

	public void verifyLoginWithInvalidEMailAndInvalidPassword() {
		driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);
		driver.quit();
	}
	@Test(priority = 5)

	public void verifyLoginWithInvalidEMailAndValidPassword() {
		driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj1234567845678@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);
		driver.quit();
	}
	@Test(priority = 6)
	public void verifyTimeStampWithDate() {
		Date date=new Date();
		System.out.println(date.toString().replaceAll(" ", ""));
		
	}

}
