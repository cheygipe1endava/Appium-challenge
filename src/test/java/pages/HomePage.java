package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;
    private By menuIcon = By.id("com.ebay.kijiji.ca:id/home_search_icon");
    private By welcomeTextContainer = By.id("com.ebay.kijiji.ca:id/welcome_text");
    private By signInButtonMenu = By.id("com.ebay.kijiji.ca:id/signInButtonInDrawer");
    private By userProfileEmail = By.id("com.ebay.kijiji.ca:id/user_profile_email");
    private By userLoggedInContainer = By.id("com.ebay.kijiji.ca:id/userProfileContainer");
    private By homePageIcon = By.xpath("//android.widget.RelativeLayout/android.widget.TextView[@text='Home']");
    private By carsAndVehiclesIcon = By.xpath("//android.widget.LinearLayout/android.widget.TextView[@text='Cars & Vehicles']");

    public HomePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public void clickMenuIcon() {
        waitAndClick(menuIcon);
    }

    public void clickSignInButtonFromMenu() {
        waitAndClick(signInButtonMenu);
    }

    public void clickUserLoggedInContainer() {
        waitAndClick(userLoggedInContainer);
    }

    public void clickHomePageOption()
    {
        waitAndClick(homePageIcon);
    }

    public void clickCarsAndVehiclesIcon()
    {
        waitAndClick(carsAndVehiclesIcon);
    }

    public boolean logInSession(String email) {
        boolean verifyLogInSession = false;
        clickMenuIcon();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileEmail));
        if (appiumDriver.findElement(userProfileEmail).getText().equals(email)) {
            verifyLogInSession = true;
        }
        return verifyLogInSession;
    }

    public boolean logOutSession()
    {
        clickMenuIcon();
        return lowerCaseValidations(welcomeTextContainer, "welcome");
    }

}
