package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListener implements ITestListener {
	public static ExtentReports extent;
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "successfully passed");
		//extentTest.get().pass("successfully passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver;
		Object instance = result.getInstance();
		@SuppressWarnings("rawtypes")
		Class testClass = result.getTestClass().getRealClass();
		try {
			driver = (WebDriver) testClass.getDeclaredField("driver").get(instance);
			extentTest.get().addScreenCaptureFromPath(
					Base.captureScreenshot(result.getMethod().getMethodName(), driver),
					result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		extent = ExtentReportNG.extentReportGenerator();
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
