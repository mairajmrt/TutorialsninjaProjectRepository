package com.tutorialsninja.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	private static Properties prop;

	public static String getNewEmailAddress() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";

	}

	public static Connection getOracleDatabseConnection() throws ClassNotFoundException, SQLException {
		// Replace with your DB URL
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";

		// Load Oracle JDBC Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Establish connection
		return DriverManager.getConnection(jdbcURL, "mairaj", "mairaj");
	}

	public static Properties getPropertyFile() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\config\\prop.properties");
		prop = new Properties();
		prop.load(file);
		return prop;

	}

	public static XSSFWorkbook getExcellFile() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\file\\webdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		return workbook;
	}
}
