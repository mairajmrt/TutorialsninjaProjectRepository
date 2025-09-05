package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import GlobalUtility.CommonUtils;

public class TC_20 extends Base {

	@AfterMethod
	public void downApplication() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(4000);
			driver.quit();
		}

	}

	@BeforeMethod
	public void setupt() {
		openBrowserApplication();
	}

	@Test
	public void verifyTrimData() throws InterruptedException {
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		String expectedFirstname = "  mairaj  ";
		driver.findElement(By.id("input-firstname")).sendKeys(expectedFirstname);
		String expectedLastname = "  ali  ";
		driver.findElement(By.id("input-lastname")).sendKeys(expectedLastname);
		String expectedEmail = CommonUtils.getNewEmailAddress();
		driver.findElement(By.id("input-email")).sendKeys(expectedEmail);
		String expectedtelephone = "    9634068065  ";
		driver.findElement(By.id("input-telephone")).sendKeys(expectedtelephone);
		String expectedPassword = "12345";
		driver.findElement(By.id("input-password")).sendKeys(expectedPassword);
		String expectedConfirm = "12345";
		driver.findElement(By.id("input-confirm")).sendKeys(expectedConfirm);
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.linkText("Edit Account")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']")).getAttribute("value"),
				expectedFirstname.trim());
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']")).getAttribute("value"),
				expectedFirstname.trim());
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']")).getAttribute("value"),
				expectedFirstname.trim());

		// There is outcome from above test, input value leading spaces before and after
		// are not trimmed on server side so above test case is failed
	}

}
