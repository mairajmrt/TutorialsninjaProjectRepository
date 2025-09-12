package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.LoginPage;

public class LoginPageTest extends Base {

	@BeforeMethod

	public void setup() throws IOException {
		openBrowserApplication();
	}

	@Test(priority = 1)

	public void verifyLoginWithValidCredentials() {

		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt123@gmail.com");
		login.getPassword("mairaj");
		login.loginPage();
		Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Account']")).getText(), "Account");

	}

	@Test(priority = 2)

	public void verifyLoginWithInvalidEmailAndValidPassword() {
		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt@gmail.com");
		login.getPassword("mairaj");
		login.loginPage();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 3)

	public void verifyLoginWithValidEMailAndInvalidPassword() {
		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt123@gmail.com");
		login.getPassword("mairaj123");
		login.loginPage();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 4)

	public void verifyLoginWithInvalidEMailAndInvalidPassword() {

		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt123123@gmail.com");
		login.getPassword("mairaj123");
		login.loginPage();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}


	@AfterMethod

	public void terDOwn() {
		if (driver != null) {
			driver.quit();
		}
	}

}
