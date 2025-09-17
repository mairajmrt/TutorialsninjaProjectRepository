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
import com.tutorialsninja.qa.pages.SearchProductPage;
import com.tutorialsninja.qa.utility.Utils;

public class SearchProductPageTest extends Base {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;

	@BeforeMethod

	public void setup() throws IOException {
		openBrowserWithWebApp();
	}

	@Test(priority = 1)

	void serachValidProduct() throws IOException {
		SearchProductPage sp=new SearchProductPage(driver);
		workbook=Utils.getExcellFile();
		sheet=workbook.getSheetAt(2);
		row=sheet.getRow(0);
		sp.setSearchField(row.getCell(0).getStringCellValue());
		sp.searchProduct();
		Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).getText(), "HP LP3065");
	}

	@Test(priority = 2)

	void serachInValidProduct() {
		SearchProductPage sp=new SearchProductPage(driver);
		row=sheet.getRow(1);
		sp.setSearchField(row.getCell(0).getStringCellValue());
		sp.searchProduct();
		String actaulProductName = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"))
				.getText();
		String expectedProductName = "There is no product that matches the search criteria.";
		Assert.assertEquals(actaulProductName, expectedProductName);
	}

	@AfterMethod

	public void terDown() {
		closeBrowserWithWebApp();
	}

}
