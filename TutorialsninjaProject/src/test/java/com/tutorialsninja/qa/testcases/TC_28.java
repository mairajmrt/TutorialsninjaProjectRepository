package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import GlobalUtility.CommonUtils;

public class TC_28 extends Base {

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

	void verifyRegisterPageDiffEnv() throws InterruptedException {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Mairaj");
		driver.findElement(By.id("input-lastname")).sendKeys("Ali");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getNewEmailAddress());
		driver.findElement(By.id("input-telephone")).sendKeys("1266666");
		driver.findElement(By.id("input-password")).sendKeys("1212");
		driver.findElement(By.id("input-confirm")).sendKeys("1212");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String expectedmsg = "Your Account Has Been Created!";
		String actmsg = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))
				.getText();
		Assert.assertEquals(actmsg, expectedmsg);

	}

}
