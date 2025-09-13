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
		openBrowserApplication();
	}

	@Test(priority = 1)

	public void verifyRegisterPage() {
		CommonPage cp=new CommonPage(driver);
		cp.commonSetUp();
		RegisterPage register=new RegisterPage(driver);
		register.setFirstnameField("mairaj");
		register.setLastnameField("ali");
		register.setEmailField(Utils.getNewEmailAddress());
		register.setTelephoneField("9634068065");
		register.setPasswordField("mairaj");
		register.setCofirmField("mairaj");
		register.loginPart();
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),"Your Account Has Been Created!");	
	}

	/*@Test(priority = 2)

	public void verifyRegisterPageWithEmptyValues() {

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String actualFirstName = driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualFirstName, "First Name must be between 1 and 32 characters!",
				"Firstname is not displayed");
		String actualLastName = driver
				.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualLastName, "Last Name must be between 1 and 32 characters!",
				"Lastname is not displayed");
		String actualEmail = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
				.getText();
		Assert.assertEquals(actualEmail, "E-Mail Address does not appear to be valid!", "Email is not displayed");
		String actualTel = driver
				.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualTel, "Telephone must be between 3 and 32 characters!", "Telephone is not displayed");
		String actualPass = driver
				.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
				.getText();
		Assert.assertEquals(actualPass, "Password must be between 4 and 20 characters!", "Password is not displayed");

	}*/

	@AfterMethod

	public void terDown() {
	//closeBrowserApplication();
	}

}
