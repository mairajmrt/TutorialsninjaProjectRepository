package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.utility.Base;
import com.tutorialsninja.qa.utility.CommonUtils;

public class Register extends Base {

	@BeforeMethod

	public void setup() {
		openBrowserApplication();
	}

	@Test

	public void verifyRegisterPage() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("ali");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.getNewEmailAddress());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9634068065");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("mairaj");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualWelcomeMessage = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		String expectedWelcomeMessage = "Your Account Has Been Created!";
		Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);
	}

	@AfterMethod

	public void terDOwn() {
		if (driver != null) {
			driver.quit();
		}
	}

}
