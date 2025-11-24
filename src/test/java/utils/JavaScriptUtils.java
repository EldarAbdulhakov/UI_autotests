package utils;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private final JavascriptExecutor js;

    public JavaScriptUtils(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    @Step("Remove focus from element")
    public void removeFocusJS(WebElement element) {
        js.executeScript("arguments[0].blur();", element);
    }

    @Step("Check for vertical scrolling")
    public boolean isVerticalScrollJS() {

        return (Boolean) js.executeScript(
                "return document.documentElement.scrollHeight > document.documentElement.clientHeight;");
    }

    @Step("Check for horizontal scrolling")
    public boolean isHorizontalScrollJS() {

        return (Boolean) js.executeScript(
                "return document.documentElement.scrollWidth > document.documentElement.clientWidth;");
    }
}
