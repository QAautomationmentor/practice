package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Base;

public class NaukriApp extends Base {
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
		driver.get("https://www.naukri.com/nlogin/login");
	}

	@Test(priority = 2)
	public void printInfo() {
		System.out.println("Title : " + driver.getTitle());
	}

	@Test(priority = 3)
	public void printURL() {
		System.out.println("Title : " + driver.getCurrentUrl());
	}
	@Test(priority = 4)
	public void printHelloMessage() {
		System.out.println("hello aditya");
	}
}
