package GlobalUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class CommonUtils {

	public static String getNewEmailAddress() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";

	}

	public static Connection getOracleDatabseConnection() throws ClassNotFoundException, SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe"; // Replace with your DB URL
		// Load Oracle JDBC Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Establish connection
		return DriverManager.getConnection(jdbcURL, "mairaj", "mairaj");
	}

}
