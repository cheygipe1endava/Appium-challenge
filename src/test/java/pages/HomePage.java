package pages;

import java.time.Duration;
import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private AppiumDriver appiumDriver;
    private WebDriverWait wait;
    private List<List<String>> credentialsData;
    private By menuIcon = By.id("com.ebay.kijiji.ca:id/home_search_icon");
    private By menuDropLeft = By.id("com.ebay.kijiji.ca:id/left_drawer");
    private By welcomeTextContainer = By.id("com.ebay.kijiji.ca:id/welcome_text");
    private By signInButtonMenu = By.id("com.ebay.kijiji.ca:id/signInButtonInDrawer");
    private By signInOptionButton = By.id("com.ebay.kijiji.ca:id/new_login_choice_sign_in");
    private By signInButton = By.id("com.ebay.kijiji.ca:id/new_login_fragment_continue");
    private By emailInputBox = By.id("com.ebay.kijiji.ca:id/new_login_fragment_email");
    private By passwordInputBox = By.id("com.ebay.kijiji.ca:id/new_login_fragment_password");
    private By userProfileEmail = By.id("com.ebay.kijiji.ca:id/user_profile_email");
    private By userLoggedInContainer = By.id("com.ebay.kijiji.ca:id/userProfileContainer");
    private By settingsIcon = By.id("com.ebay.kijiji.ca:id/action_settings");
    private By logOutButton = By.id("com.ebay.kijiji.ca:id/logoutButton");

    public HomePage(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public void processDataInsert(DataTable fields)
    {
        credentialsData = fields.cells();
    }

    public void scrollDown()
    {
        Dimension dimension = appiumDriver.manage().window().getSize();
        double scrollHeightStart = dimension.getHeight() * 0.5;
        double scrollHeightEnd = dimension.getHeight() * 0.2;
        int scrollStart = (int) scrollHeightStart;
        int scrollEnds = (int) scrollHeightEnd;


        new TouchAction(appiumDriver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(0,scrollEnds))
                .release().perform();
    }



    public void clickMenuIcon()
    {
        waitAndClick(menuIcon);
    }

    public void clickSignInButtonFromMenu()
    {
        waitAndClick(signInButtonMenu);
    }

    public void clickSignInOptionButton()
    {
        waitAndClick(signInOptionButton);
    }

    public void inputEmailAndPassword()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputBox));
        clickAndSendData(emailInputBox, credentialsData.get(0).get(1));
        clickAndSendData(passwordInputBox, credentialsData.get(1).get(1));
    }

    public void clickSignInButton()
    {
        waitAndClick(signInButton);
    }

    public void clickUserLoggedInContainer()
    {
        waitAndClick(userLoggedInContainer);
    }

    public void clickAccountSettingsIcon()
    {
        waitAndClick(settingsIcon);
    }

    public void clickLogOutButton()
    {
        scrollDown();
        waitAndClick(logOutButton);
    }

    public boolean logInSession()
    {
        boolean verifyLogInSession = false;
        String email = credentialsData.get(0).get(1);
        clickMenuIcon();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileEmail));
        if(appiumDriver.findElement(userProfileEmail).getText().equals(email))
        {
            verifyLogInSession = true;
        }
        return verifyLogInSession;
    }

    public boolean logOutSession()
    {
        boolean verifyLogOutSession = false;
        clickMenuIcon();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuDropLeft));
        String welcomeText = appiumDriver.findElement(welcomeTextContainer).getText().toLowerCase();
        if(welcomeText.contains("welcome"))
        {
            verifyLogOutSession = true;
        }
        return verifyLogOutSession;
    }

    public void logOutSteps()
    {
        clickUserLoggedInContainer();
        clickAccountSettingsIcon();
        clickLogOutButton();
    }
}
