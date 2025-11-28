package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver(String browserName, boolean useGrid) {
        browserName = browserName.toLowerCase();

        try {
            if (useGrid) {
                return createRemoteDriver(browserName);
            } else {
                return createLocalDriver(browserName);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create driver for: " + browserName, e);
        }
    }

    private static WebDriver createRemoteDriver(String browserName) throws MalformedURLException {
        URL gridUrl = new URL("http://localhost:4444/wd/hub");

        switch (browserName) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");

                return new RemoteWebDriver(gridUrl, chromeOptions);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--window-size=1920,1080");

                return new RemoteWebDriver(gridUrl, firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--window-size=1920,1080");

                return new RemoteWebDriver(gridUrl, edgeOptions);

            case "ie":
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.ignoreZoomSettings();
                internetExplorerOptions.introduceFlakinessByIgnoringSecurityDomains();

                return new RemoteWebDriver(gridUrl, internetExplorerOptions);

            default:
                throw new IllegalArgumentException("Unknown browser: " + browserName);
        }
    }

    private static WebDriver createLocalDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--window-size=1920,1080");

                return new ChromeDriver(chromeOptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
                firefoxDriver.manage().window().setSize(new Dimension(1920, 1080));

                return firefoxDriver;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--window-size=1920,1080");

                return new EdgeDriver(edgeOptions);

            case "ie":
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.ignoreZoomSettings();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();

                return new InternetExplorerDriver(ieOptions);

            default:
                throw new IllegalArgumentException("Unknown local browser: " + browserName);
        }
    }
}
