package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ContactUsPage;

public class JavascriptExecutorTest extends BaseTest {

    @Test
    public void testRemoveFocusAndPageScroll() {
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        Boolean isNameFieldFocus = contactUsPage
                .clickNameField()
                .removeFocusFromNameField()
                .isNameFieldFocus();

        Assert.assertFalse(isNameFieldFocus, "The focus should be removed from the name field.");
        Assert.assertTrue(contactUsPage.isPageScroll(), "The scroll must be present.");
    }
}
