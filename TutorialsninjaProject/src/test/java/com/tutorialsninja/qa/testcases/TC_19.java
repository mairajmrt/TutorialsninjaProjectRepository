package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;

public class TC_19 extends Base {

	WebElement continueBtnId;
	WebElement fisrtnameId;

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

	/*
	 * @Test public void verifyWidhtHeightData() {
	 * driver.get("https://tutorialsninja.com/demo/");
	 * driver.findElement(By.linkText("My Account")).click();
	 * driver.findElement(By.linkText("Register")).click(); String
	 * expectedWidth="701.25px"; String expectedHeight="34px"; actaulWidht =
	 * driver.findElement(By.id("input-firstname")).getCssValue("width");
	 * actaulHeight =
	 * driver.findElement(By.id("input-firstname")).getCssValue("height");
	 * Assert.assertEquals(actaulWidht, expectedWidth);
	 * Assert.assertEquals(actaulHeight, expectedHeight); actaulWidht =
	 * driver.findElement(By.id("input-lastname")).getCssValue("width");
	 * actaulHeight =
	 * driver.findElement(By.id("input-lastname")).getCssValue("height");
	 * Assert.assertEquals(actaulWidht, expectedWidth);
	 * Assert.assertEquals(actaulHeight, expectedHeight); actaulWidht =
	 * driver.findElement(By.id("input-email")).getCssValue("width"); actaulHeight =
	 * driver.findElement(By.id("input-email")).getCssValue("height");
	 * Assert.assertEquals(actaulWidht, expectedWidth);
	 * Assert.assertEquals(actaulHeight, expectedHeight); actaulWidht =
	 * driver.findElement(By.id("input-telephone")).getCssValue("width");
	 * actaulHeight =
	 * driver.findElement(By.id("input-telephone")).getCssValue("height");
	 * Assert.assertEquals(actaulWidht, expectedWidth);
	 * Assert.assertEquals(actaulHeight, expectedHeight); actaulWidht =
	 * driver.findElement(By.id("input-password")).getCssValue("width");
	 * actaulHeight =
	 * driver.findElement(By.id("input-password")).getCssValue("height");
	 * Assert.assertEquals(actaulWidht, expectedWidth);
	 * Assert.assertEquals(actaulHeight, expectedHeight); actaulWidht =
	 * driver.findElement(By.id("input-confirm")).getCssValue("width"); actaulHeight
	 * = driver.findElement(By.id("input-confirm")).getCssValue("height");
	 * Assert.assertEquals(actaulWidht, expectedWidth);
	 * Assert.assertEquals(actaulHeight, expectedHeight);
	 * driver.findElement(By.xpath(
	 * "//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
	 * driver.findElement(By.xpath("//input[@name='agree']")).click();
	 * driver.findElement(By.xpath("//input[@value='Continue']")).click();
	 * driver.quit();
	 * 
	 * }
	 */

	@Test
	public void verifyTextualData() throws InterruptedException {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		fisrtnameId = driver.findElement(By.id("input-firstname"));
		fisrtnameId.sendKeys(" m ");
		System.out.println(fisrtnameId.getAttribute("value").toString());
		driver.quit();
	}

}
