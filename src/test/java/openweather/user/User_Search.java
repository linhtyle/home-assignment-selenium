package openweather.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePageObject;
import pageObject.UserPageGeneratorManager;

public class User_Search extends BaseTest {

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appURL) {
        log.info("Pre-condition - Step 01: Open browser " + "and navigate to " + appURL + "");
        driver = getBrowserDriver(browserName);
        homePage = UserPageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void search() {
        log.info("Search - Step 01: Verify search box is displayed");
        Assert.assertTrue(homePage.isSearchTextBoxDisplayed());

        log.info("Search - Step 02: Input to the search box with 'Ho Chi Minh city' keyword");
        homePage.enterToSearchTextBox("Ho Chi Minh city");

        log.info("Search - Step 03: Verify 'Thanh pho Ho Chi Minh, VN' is displayed");
        Assert.assertEquals(homePage.getExpectedResultDisplayed(), "Thanh pho Ho Chi Minh, VN");
    }

    @AfterClass(alwaysRun = true)
    public void cleanBrowser() {
        log.info("Post-condition - Close browser");
        cleanDriverInstance();
    }

    WebDriver driver;
    HomePageObject homePage;
}