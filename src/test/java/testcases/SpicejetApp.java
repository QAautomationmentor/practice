package testcases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class SpicejetApp extends Base {
	public WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.get("https://www.spicejet.com/");
	}
}
