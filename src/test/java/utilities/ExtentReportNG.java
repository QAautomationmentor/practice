package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	public static ExtentReports extent;

	public static ExtentReports extentReportGenerator() {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\reports\\extent_report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filePath);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Tester", "Aditya Sisodiya");
		return extent;
	}
}
