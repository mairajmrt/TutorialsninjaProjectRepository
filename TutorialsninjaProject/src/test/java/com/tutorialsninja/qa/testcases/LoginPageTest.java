package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.CommonPage;
import com.tutorialsninja.qa.pages.LoginPage;

public class LoginPageTest extends Base {

	@BeforeMethod

	public void setup() throws IOException {
		openBrowserWithWebApp();
	}

	@Test(priority = 1)

	public void verifyLoginWithValidCredentials() {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt123@gmail.com");
		login.getPassword("mairaj");
		login.loginUser();
		Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Account']")).getText(), "Account");

	}

	@Test(priority = 2)

	public void verifyLoginWithInvalidEmailAndValidPassword() {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt@gmail.com");
		login.getPassword("mairaj");
		login.loginUser();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 3)

	public void verifyLoginWithValidEMailAndInvalidPassword() {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt123@gmail.com");
		login.getPassword("mairaj123");
		login.loginUser();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 4)

	public void verifyLoginWithInvalidEMailAndInvalidPassword() {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		login.getEMailAdress("mairajmrt123123@gmail.com");
		login.getPassword("mairaj123");
		login.loginUser();
		String actualValue = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualValue, expectedValue);

	}

	@AfterMethod

	public void terDown() {
		closeBrowserWithWebApp();
	}

}
