package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

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

                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");

                return new RemoteWebDriver(gridUrl, firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--window-size=1920,1080");

                return new RemoteWebDriver(gridUrl, edgeOptions);

            case "ie":
                EdgeOptions ieOptions = new EdgeOptions();

                ieOptions.addArguments("--window-size=1920,1080");

                Map<String, Object> ieModeOptions = new HashMap<>();
                ieModeOptions.put("ie.edgechromium", true);
                ieModeOptions.put("ie.mode", "ieEnterprise");
                ieModeOptions.put("ie.requireWindowFocus", false);
                ieModeOptions.put("ie.ignoreZoomSetting", true);

                ieOptions.setCapability("se:ieOptions", ieModeOptions);

                return new RemoteWebDriver(gridUrl, ieOptions);

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

                return new FirefoxDriver(firefoxOptions);

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--window-size=1920,1080");

                return new EdgeDriver(edgeOptions);

            case "ie":
                WebDriverManager.edgedriver().setup();
                EdgeOptions ieOptions = new EdgeOptions();
                ieOptions.addArguments("--window-size=1920,1080");

                Map<String, Object> ieModeOptions = new HashMap<>();
                ieModeOptions.put("ie.edgechromium", true);
                ieModeOptions.put("ie.mode", "ieEnterprise");
                ieModeOptions.put("ie.requireWindowFocus", false);
                ieModeOptions.put("ie.ignoreZoomSetting", true);

                ieOptions.setCapability("se:ieOptions", ieModeOptions);

                return new EdgeDriver(ieOptions);

            default:
                throw new IllegalArgumentException("Unknown local browser: " + browserName);
        }
    }
}
