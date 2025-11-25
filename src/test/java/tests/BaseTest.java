package tests;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        URL gridUrl = new URL("http://localhost:4444/wd/hub");
        options.addArguments("--window-size=1920,1080");

        driver.set(new RemoteWebDriver(gridUrl, options));
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("ScreenshotWhenFalling", new ByteArrayInputStream(screenshot));
        }
        driver.get().quit();
        driver.remove();
    }
}
