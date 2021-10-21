package pageObject;

import org.openqa.selenium.WebDriver;

public class UserPageGeneratorManager {

	private UserPageGeneratorManager() {
		
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}