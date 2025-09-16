package com.tutorialsninja.qa.testcases;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.CommonPage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utility.Utils;

public class LoginPageTest extends Base {

	private XSSFWorkbook workbook;

	@BeforeMethod

	public void setup() throws IOException {
		openBrowserWithWebApp();
	}

	@Test(priority = 1)

	public void verifyLoginWithValidCredentials() throws IOException {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		workbook = Utils.getExcellFile();
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		String email = row.getCell(0).getStringCellValue();
		String password = row.getCell(1).getStringCellValue();
		login.getEMailAdress(email);
		login.getPassword(password);
		login.loginUser();
		Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Account']")).getText(), "Account");

	}

	@Test(priority = 2)

	public void verifyLoginWithInvalidEmailAndValidPassword() {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		String email = row.getCell(0).getStringCellValue();
		String password = row.getCell(1).getStringCellValue();
		login.getEMailAdress(email);
		login.getPassword(password);
		login.loginUser();
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				"Warning: No match for E-Mail Address and/or Password.");

	}

	@Test(priority = 3)

	public void verifyLoginWithValidEMailAndInvalidPassword() {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(2);
		String email = row.getCell(0).getStringCellValue();
		String password = row.getCell(1).getStringCellValue();
		login.getEMailAdress(email);
		login.getPassword(password);
		login.loginUser();
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				"Warning: No match for E-Mail Address and/or Password.");
	}

	@Test(priority = 4)

	public void verifyLoginWithInvalidEMailAndInvalidPassword() throws InterruptedException {
		CommonPage cp = new CommonPage(driver);
		cp.loginSetUp();
		LoginPage login = new LoginPage(driver);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(3);
		String email = row.getCell(0).getStringCellValue();
		String password = row.getCell(1).getStringCellValue();
		login.getEMailAdress(email);
		login.getPassword(password);
		login.loginUser();	
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				"Warning: No match for E-Mail Address and/or Password.");

	}

	@AfterMethod

	public void terDown() {
		closeBrowserWithWebApp();
	}

}
