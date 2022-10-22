package pl.tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class SampleTestListener implements ITestListener {

    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I'm starting test");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        driver = DriverFactory.getDriver();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        int randomNumber = ((int)Math.random()*1000);
        String fileName = "faildTest" + randomNumber + ".png";
        File beforefileScreen = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(beforefileScreen, new File("src/test/resources/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screen");

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
