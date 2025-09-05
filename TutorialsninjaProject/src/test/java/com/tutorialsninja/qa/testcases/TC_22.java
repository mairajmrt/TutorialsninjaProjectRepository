package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Base;
import junit.framework.Assert;

public class TC_22 extends Base {

	WebDriver driver;

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

	public void verfiyToggledButton() {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();

		// verify toggled buttons
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("type"), "password");
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("type"), "password");

	}

}
