package pages;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.Data;
import java.util.List;

public class HomePage extends BasePage{

    private AppiumDriver appiumDriver;
    private WebDriverWait wait;
    private List<List<String>> credentialsData;
    private By searchBar = By.id("com.ebay.kijiji.ca:id/home_search_container");
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
    private By userProfilePhoto = By.id("com.ebay.kijiji.ca:id/user_profile_image_view_image");
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

    public void clickMenuIcon()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuIcon));
        appiumDriver.findElement(menuIcon).click();
    }

    public void clickSignInButtonFromMenu()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuDropLeft));
        appiumDriver.findElement(signInButtonMenu).click();
    }

    public void clickSignInOptionButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInOptionButton));
        appiumDriver.findElement(signInOptionButton).click();
    }

    public void inputEmailAndPassword()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputBox));
        clickAndSendData(emailInputBox, credentialsData.get(0).get(1));
        clickAndSendData(passwordInputBox, credentialsData.get(1).get(1));
    }

    public void clickSignInButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));
        appiumDriver.findElement(signInButton).click();
    }

    public void clickUserLoggedInContainer()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userLoggedInContainer));
        appiumDriver.findElement(userLoggedInContainer).click();
    }

    public void clickAccountSettingsIcon()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfilePhoto));
        appiumDriver.findElement(settingsIcon).click();
    }

    public void clickLogOutButton()
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        appiumDriver.findElement(logOutButton).click();
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
        if(appiumDriver.findElement(welcomeTextContainer).getText().toLowerCase().equals("welcome"))
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
