package com.tutorialsninja.qa.testcases;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.Base;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TC_29 extends Base {

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

	void comapreImage() throws IOException {

		driver.get("https://tutorialsninja.com/demo/");
		WebElement logo = driver.findElement(By.xpath("//a[normalize-space()='Qafox.com']"));
		File rscFile=logo.getScreenshotAs(OutputType.FILE);
		File dscFile=new File("C:\\Users\\mali204\\git\\MySeleniumProject\\MyEcommerceJavaMavenProject\\image\\abc.png");
		FileHandler.copy(rscFile, dscFile);
		
		// Take screenshot with AShot
		BufferedImage actualImage = new AShot().shootingStrategy(ShootingStrategies.simple()).takeScreenshot(driver, logo).getImage();
		
		// Load expected image
		BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\mali204\\git\\MySeleniumProject\\MyEcommerceJavaMavenProject\\image\\abc.png"));

		// Compare images
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

		if (diff.hasDiff()) {
			System.out.println("❌ Images are different!");
		} else {
			System.out.println("✅ Images match!");
		}

	}

}
