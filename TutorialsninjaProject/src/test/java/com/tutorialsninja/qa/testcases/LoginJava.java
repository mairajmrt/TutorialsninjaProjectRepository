package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginJava {

	private FirefoxDriver driver;

	@Test

	public void verifyLoginPage() {
		driver = new FirefoxDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mairaj12345678@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());
		driver.quit();
	}

}
