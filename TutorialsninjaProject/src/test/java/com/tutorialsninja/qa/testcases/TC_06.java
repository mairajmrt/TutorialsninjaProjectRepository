package com.tutorialsninja.qa.testcases;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;

public class TC_06 extends Base {

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
	public void registerNonSubscriber() {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("mairaj");
		driver.findElement(By.id("input-lastname")).sendKeys("ali");
		String emailid = new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";
		driver.findElement(By.id("input-email")).sendKeys(emailid);
		driver.findElement(By.id("input-telephone")).sendKeys("9634068065");
		driver.findElement(By.id("input-password")).sendKeys("Adden@1982");
		driver.findElement(By.id("input-confirm")).sendKeys("Adden@1982");
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//h1[normalize-space()='Newsletter Subscription']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='0']")).isSelected());
	}

}
