package pageObject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchTextBoxDisplayed() {
        waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
        return isElementDisplayed(driver, HomePageUI.SEARCH_TEXTBOX);
    }

    public void enterToSearchTextBox(String searchValue) {
        waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, searchValue);
        submitToElement(driver, HomePageUI.SEARCH_TEXTBOX);
    }

    public String getExpectedResultDisplayed() {
        waitForElementVisible(driver, HomePageUI.TEXT_RESULT);
        return getElementText(driver, HomePageUI.TEXT_RESULT);
    }
}