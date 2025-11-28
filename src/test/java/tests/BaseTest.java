package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

import java.io.ByteArrayInputStream;

public abstract class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }

    @Parameters({"browserName", "useGrid"})
    @BeforeMethod
    public void setUp(String browserName, boolean useGrid) {
        WebDriver webDriver = DriverFactory.createDriver(browserName, useGrid);
        driver.set(webDriver);
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            WebDriver webDriver = driver.get();
            byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("ScreenshotWhenFalling", new ByteArrayInputStream(screenshot));
        }

        driver.get().quit();
        driver.remove();
    }
}
