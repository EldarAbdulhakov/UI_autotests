package tests;

import org.testng.annotations.Test;
import page.AlertPage;

public class AlertTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        new AlertPage(getDriver())
                .clickInputAlert()
                .clickDemonstrateInputBoxButton();

        Thread.sleep(2000);
    }
}
