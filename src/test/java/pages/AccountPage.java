package pages;

import java.time.Duration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class AccountPage extends BasePage
{
    private AppiumDriver<MobileElement> appiumDriver;
    private By settingsIcon = By.id("com.ebay.kijiji.ca:id/action_settings");
    private By logOutButton = By.id("com.ebay.kijiji.ca:id/logoutButton");

    public AccountPage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
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
}
