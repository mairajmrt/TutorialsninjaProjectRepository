package com.tutorialsninja.qa.testcases;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.CommonPage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utility.Utils;

public class RegisterPageTest extends Base {

	@BeforeMethod

	public void setup() throws IOException {
		openBrowserWithWebApp();
	}

	@Test(priority = 1)

	public void verifyRegisterPage() {
		CommonPage cp = new CommonPage(driver);
		cp.registerSetUp();
		RegisterPage register = new RegisterPage(driver);
		register.setFirstnameField("mairaj");
		register.setLastnameField("ali");
		register.setEmailField(Utils.getNewEmailAddress());
		register.setTelephoneField("9634068065");
		register.setPasswordField("mairaj");
		register.setCofirmField("mairaj");
		register.registerUser();
		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),
				"Your Account Has Been Created!");
	}

	@Test(priority = 2)

	public void verifyRegisterPageWithEmptyValues() {

		CommonPage cp = new CommonPage(driver);
		cp.registerSetUp();
		RegisterPage register = new RegisterPage(driver);
		register.setFirstnameField("");
		register.setLastnameField("");
		register.setEmailField("");
		register.setTelephoneField("");
		register.setPasswordField("");
		register.setCofirmField("");
		register.registerUser();
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText(), "First Name must be between 1 and 32 characters!");

	}

	@AfterMethod

	public void terDown() {
		closeBrowserWithWebApp();
	}

}
