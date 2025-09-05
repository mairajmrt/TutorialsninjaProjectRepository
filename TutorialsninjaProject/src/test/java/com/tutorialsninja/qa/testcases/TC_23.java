package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Base;
import junit.framework.Assert;

public class TC_23 extends Base {

	
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

	public void verfiyNextPageLocation()  {
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Login']")).click();

		// verify location of next page......
		Assert.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']")).getText(),
				"Returning Customer");

	}
}
