package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import junit.framework.Assert;

public class TC_21 extends Base{

	WebElement privacyPolicyBtnId;

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

	public void verfiyPrivacyPolicyButton() {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		privacyPolicyBtnId = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyBtnId.click();

		// If privacy policy button is selected by default then below condition will
		// execute otherwise test will fail.
		Assert.assertTrue(privacyPolicyBtnId.isSelected());

	}

}
