package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class Linkvalidation extends Base {
	public WebDriver driver;

	@BeforeClass
	public void tearUp() {
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test(priority = 1)
	public void openApplication() {
		driver.get("https://www.rahulshettyacademy.com/");
		Assert.assertTrue(false);
		
	}

	@Test(priority = 2)
	public void printInfo() {
		System.out.println("Title : " + driver.getTitle());
	}

}
