package com.tutorialsninja.qa.testcases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Base;
import GlobalUtility.CommonUtils;

public class TC_18 extends Base {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	String firstname;
	String lastname;
	String email;
	String telephone;
	String password;
	String confirm;

	

	@BeforeMethod
	public void setupt() {
		openBrowserApplication();
	}
	
	@AfterMethod
	public void downApplication() throws InterruptedException {
		if (driver != null) {
			Thread.sleep(4000);
			driver.quit();
		}

	}

	@Test

	public void getRegisterFromOracleDatabase() {
		try {
			conn = CommonUtils.getOracleDatabseConnection();
			// Create statement.............
			stmt = conn.createStatement();
			// Execute query....................
			rs = stmt.executeQuery("select * from ali");
			while (rs.next()) {

				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				email = rs.getString("email");
				telephone = rs.getString("telephone");
				password = rs.getString("password");
				confirm = rs.getString("confirm");
				break;
			}

			// User registration from database values

			if (email == "alimrt@gmail.com") {

				driver.get("https://tutorialsninja.com/demo/");
				driver.findElement(By.linkText("My Account")).click();
				driver.findElement(By.linkText("Register")).click();
				driver.findElement(By.id("input-firstname")).sendKeys(firstname);
				driver.findElement(By.id("input-lastname")).sendKeys(lastname);
				driver.findElement(By.id("input-email")).sendKeys(email);
				driver.findElement(By.id("input-telephone")).sendKeys(telephone);
				driver.findElement(By.id("input-password")).sendKeys(password);
				driver.findElement(By.id("input-confirm")).sendKeys(confirm);
				driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
				driver.findElement(By.xpath("//input[@name='agree']")).click();
				driver.findElement(By.xpath("//input[@value='Continue']")).click();
			}

			// Clean up..................
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception exe) {
			System.out.println("Error By Me...." + exe);
		}

	}

}
