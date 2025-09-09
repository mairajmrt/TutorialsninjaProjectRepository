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

	@Test(priority = 1)

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

	@Test(priority = 2)

	public void verifyRegisterPageWithEmptyValues() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualFirstName = driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualFirstName, "First Name must be between 1 and 32 characters!",
				"Firstname is not displayed");
		String actualLastName = driver
				.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualLastName, "Last Name must be between 1 and 32 characters!",
				"Lastname is not displayed");
		String actualEmail = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
				.getText();
		Assert.assertEquals(actualEmail, "E-Mail Address does not appear to be valid!", "Email is not displayed");
		String actualTel = driver
				.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualTel, "Telephone must be between 3 and 32 characters!", "Telephone is not displayed");
		String actualPass = driver
				.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
				.getText();
		Assert.assertEquals(actualPass, "Password must be between 4 and 20 characters!", "Password is not displayed");

	}

	@AfterMethod

	public void terDOwn() {
		if (driver != null) {
			driver.quit();
		}
	}

}
