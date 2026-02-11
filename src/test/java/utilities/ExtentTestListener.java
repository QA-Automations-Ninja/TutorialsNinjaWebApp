   package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestListener implements ITestListener {

    private static ExtentReports extent;
    // Thread-safe ExtentTest for parallel execution
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create test and store in ThreadLocal
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, result.getName() + " passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, result.getName() + " failed");
        extentTest.get().log(Status.INFO, result.getThrowable());

        // Capture screenshot        
        try {
            String imgPath = new ScreenshotUtil(driver).captureScreen(result.getName());
            if (imgPath != null) {
                extentTest.get().addScreenCaptureFromPath(imgPath);
            }
        } catch (IOException e) {
            extentTest.get().log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, result.getName() + " skipped");
        if (result.getThrowable() != null) {
            extentTest.get().log(Status.INFO, result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        ExtentReportManager.openReport();
    }

    
}
