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
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utility.Utils;

public class RegisterPageTest extends Base {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;

	@BeforeMethod

	public void setup() throws IOException {
		openBrowserWithWebApp();
	}

	@Test(priority = 1)

	public void verifyRegisterPage() throws IOException {
		CommonPage cp = new CommonPage(driver);
		cp.registerSetUp();
		RegisterPage register = new RegisterPage(driver);
		workbook=Utils.getExcellFile();
		sheet=workbook.getSheetAt(1);
		row=sheet.getRow(0);
		register.setFirstnameField(row.getCell(0).getStringCellValue());
		register.setLastnameField(row.getCell(1).getStringCellValue());
		register.setEmailField(Utils.getNewEmailAddress());
		register.setTelephoneField(row.getCell(2).getStringCellValue());
		register.setPasswordField(row.getCell(3).getStringCellValue());
		register.setCofirmField(row.getCell(4).getStringCellValue());
		register.registerUser();
		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),
				"Your Account Has Been Created!");
	}

	@Test(priority = 2)

	public void verifyRegisterPageWithEmptyValues() throws IOException {

		CommonPage cp = new CommonPage(driver);
		cp.registerSetUp();
		RegisterPage register = new RegisterPage(driver);
		row=sheet.getRow(1);
		register.setFirstnameField(row.getCell(0).getStringCellValue());
		register.setLastnameField(row.getCell(1).getStringCellValue());
		register.setEmailField("");
		register.setTelephoneField(row.getCell(2).getStringCellValue());
		register.setPasswordField(row.getCell(3).getStringCellValue());
		register.setCofirmField(row.getCell(4).getStringCellValue());
		register.registerUser();
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[@class='text-danger']"))
				.getText(), "E-Mail Address does not appear to be valid!");

	}

	@AfterMethod

	public void terDown() {
		closeBrowserWithWebApp();
	}

}
