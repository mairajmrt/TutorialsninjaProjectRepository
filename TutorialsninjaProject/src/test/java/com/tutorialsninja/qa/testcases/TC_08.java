package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Base;
import GlobalUtility.CommonUtils;

public class TC_08 extends Base {

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

	public void getWrongPassowrd() {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("mairaj");
		driver.findElement(By.id("input-lastname")).sendKeys("ali");
		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getNewEmailAddress());
		driver.findElement(By.id("input-telephone")).sendKeys("9634068065");
		driver.findElement(By.id("input-password")).sendKeys("Maa@1987");
		driver.findElement(By.id("input-confirm")).sendKeys("Maa@198");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(),
				"Password confirmation does not match password!");

	}

}
