package aaTests.testNGRelated;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DeltaFrameworkListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("**********************HELLO EVERYONE TESTING**********************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
