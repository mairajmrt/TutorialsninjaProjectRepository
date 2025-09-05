package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;

public class TC_25 extends Base{
	
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
	public void verifyRegisterPage() {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		String expectedTitle= "Register Account";
		String actualTitle = driver
				.findElement(By.xpath("//h1[normalize-space()='Register Account']"))
				.getText();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		String expectedPageUrl= "https://tutorialsninja.com/demo/index.php?route=account/register";
		String actPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(actPageUrl, expectedPageUrl);
		driver.quit();
	}

}
