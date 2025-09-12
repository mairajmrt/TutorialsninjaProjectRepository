package com.tutorialsninja.qa.base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utility.Utils;

public class Base {

	protected WebDriver driver;
	protected Properties prop;

	public void openBrowserApplication() throws IOException {
		prop = Utils.getPropertyFile();

		if (prop.getProperty("brosername").equals("chrome")) {
			driver = new ChromeDriver();
		}

		else if (prop.getProperty("brosername").equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (prop.getProperty("brosername").equals("edge")) {
			driver = new EdgeDriver();
		}

		else if (prop.getProperty("brosername").equals("ie")) {
			driver = new InternetExplorerDriver();
		}

		else if (prop.getProperty("brosername").equals("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}

}
