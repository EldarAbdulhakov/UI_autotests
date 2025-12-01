package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void testEnterTextToAlert() {
        final String alertFieldText = "Vincent van Gogh";

        String inputBoxText = new AlertPage(getDriver())
                .clickInputAlert()
                .switchToInputBoxFrame()
                .clickInputBoxButton()
                .switchToAlert()
                .enterTextToAlertAndAccept(alertFieldText)
                .getInputBox();

        Assert.assertEquals(inputBoxText, "Hello %s! How are you today?".formatted(alertFieldText));
    }
}
