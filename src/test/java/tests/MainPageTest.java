package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class MainPageTest extends BaseTest {

    @Test
    public void testHeaderPhone1() {
        String headerPhone = new HomePage(getDriver())
                .getHeaderPhone1();

        Assert.assertEquals(headerPhone, "+919711-111-558");
    }

    @Test
    public void testHeaderPhone2() {
        String headerPhone = new HomePage(getDriver())
                .getHeaderPhone2();

        Assert.assertEquals(headerPhone, "+919711-191-558");
    }

    @Test
    public void testHeaderPhone3() {
        String headerPhone = new HomePage(getDriver())
                .getHeaderPhone3();

        Assert.assertEquals(headerPhone, "+1 646-480-0603");
    }

    @Test
    public void testHeaderSkypeLinkAndText() {
        WebElement skypeLink = new HomePage(getDriver())
                .skypeLinkWebElement();

        Assert.assertEquals(skypeLink.getAttribute("href"), "skype:seleniumcoaching?chat");
        Assert.assertEquals(skypeLink.getText(), "seleniumcoaching");
    }

    @Test
    public void testHeaderEmail() {
        String email = new HomePage(getDriver())
                .getHeaderEmail();

        Assert.assertEquals(email, "trainer@way2automation.com");
    }

    @Test
    public void testHeaderFacebookLinkAndSvg() {
        HomePage homePage = new HomePage(getDriver());

        WebElement facebookLink = homePage.facebookLinkWebElement();
        WebElement facebookSvg = homePage.facebookSvg();

        Assert.assertEquals(facebookLink.getAttribute("href"), "https://www.facebook.com/way2automation");
        Assert.assertTrue(facebookSvg.isDisplayed());
    }

    @Test
    public void testHeaderLinkedinLinkAndSvg() {
        HomePage homePage = new HomePage(getDriver());

        WebElement linkedinLink = homePage.getLinkedinLinkWebElement();
        WebElement linkedinSvg = homePage.getLinkedinSvg();

        Assert.assertEquals(linkedinLink.getAttribute("href"), "https://in.linkedin.com/in/rahul-arora-0490b751");
        Assert.assertTrue(linkedinSvg.isDisplayed());
    }

    @Test
    public void testHeaderGoogleLinkAndSvg() {
        HomePage homePage = new HomePage(getDriver());

        WebElement googleLink = homePage.getGoogleLinkWebElement();
        WebElement googleSvg = homePage.getGoogleSvg();

        Assert.assertEquals(googleLink.getAttribute("href"), "https://plus.google.com/u/0/+RamanAhujatheseleniumguru");
        Assert.assertTrue(googleSvg.isDisplayed());
    }

    @Test
    public void testHeaderYoutubeLinkAndSvg() {
        HomePage homePage = new HomePage(getDriver());

        WebElement youtubeLink = homePage.getYoutubeLinkWebElement();
        WebElement youtubeSvg = homePage.getYoutubeSvg();

        Assert.assertEquals(youtubeLink.getAttribute("href"), "https://www.youtube.com/c/seleniumappiumtutorialtraining");
        Assert.assertTrue(youtubeSvg.isDisplayed());
    }

    @Test
    public void testFooterAddress() {
        String footerAddress = new HomePage(getDriver())
                .getFooterAddress();

        Assert.assertEquals(
                footerAddress,
                "CDR Complex, 3rd Floor, Naya Bans Market, Sector 15, Noida, Near sec-16 Metro Station");
    }

    @Test
    public void testFooterPhone1() {
        String footerPhone1 = new HomePage(getDriver())
                .getFooterPhone1();

        Assert.assertEquals(footerPhone1, "+91 97111-11-558");
    }

    @Test
    public void testFooterPhone2() {
        String footerPhone2 = new HomePage(getDriver())
                .getFooterPhone2();

        Assert.assertEquals(footerPhone2, "+91 97111-91-558");
    }

    @Test
    public void testFooterEmail1() {
        String footerEmail1 = new HomePage(getDriver())
                .getFooterEmail1();

        Assert.assertEquals(footerEmail1, "trainer@way2automation.com");
    }

    @Test
    public void testFooterEmail2() {
        String footerEmail2 = new HomePage(getDriver())
                .getFooterEmail2();

        Assert.assertEquals(footerEmail2, "seleniumcoaching@gmail.com");
    }

    @Test
    public void testDisplayMenuOnScrollDown() {
        Boolean menuDisplayed = new HomePage(getDriver())
                .pageDownScroll()
                .getDisplayedMenu();

        Assert.assertTrue(menuDisplayed);
    }

    @Test
    public void testNavigationToLifetimeMembership() {
        String title = new HomePage(getDriver())
                .moveToAllCourses()
                .clickLifetimeMembershipButton()
                .getTitle();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.way2automation.com/lifetime-membership-club/");
        Assert.assertEquals(title, "LIFETIME MEMBERSHIP CLUB");
    }
}
