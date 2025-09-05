package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Base;

public class TC_13 extends Base {

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

	public void getVerificationUnderPlaceHolder() {

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		String firstNamePLaceHolderText = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),
				firstNamePLaceHolderText);
		String lastNamePLaceHolderText = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),
				lastNamePLaceHolderText);
		String emailNamePLaceHolderText = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"),
				emailNamePLaceHolderText);
		String telephoneNamePLaceHolderText = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"),
				telephoneNamePLaceHolderText);
		String passwordNamePLaceHolderText = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"),
				passwordNamePLaceHolderText);
		String confirmNamePLaceHolderText = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"),
				confirmNamePLaceHolderText);

	}

}
