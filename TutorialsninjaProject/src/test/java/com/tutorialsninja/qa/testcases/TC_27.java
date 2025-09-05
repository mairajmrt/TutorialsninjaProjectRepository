package com.tutorialsninja.qa.testcases;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;

public class TC_27 extends Base {

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
	public void verifyTakesscreen() throws Exception {
		driver.get("https://tutorialsninja.com/demo/");
		WebElement mobileID = driver.findElement(By.xpath("//span[@id='cart-total']"));
		File src = mobileID.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\mali204\\git\\MySeleniumProject\\MyEcommerceJavaMavenProject\\image\\abc.png");
		FileHandler.copy(src, dest);
		driver.quit();

	}

}
