package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    public static AbstractPage getAbstractPage() {
        return new AbstractPage();
    }

    protected By getByXpath(String locator) {
        return By.xpath(locator);
    }

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    protected void submitToElement(WebDriver driver, String locator) {
        getElement(driver, locator).submit();
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String value) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(value);
    }

    protected String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText().trim();
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    protected void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    private WebDriverWait explicitWait;
    private final long longTimeout = GlobalConstants.LONG_TIMEOUT;
}
