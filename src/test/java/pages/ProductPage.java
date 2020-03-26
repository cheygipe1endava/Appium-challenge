package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class ProductPage extends BasePage
{
    private AppiumDriver<MobileElement> appiumDriver;
    private String goBackArrow = "Navigate up";
    private By adTitle = By.id("com.ebay.kijiji.ca:id/adTitle");
    private By heartIcon = By.id("com.ebay.kijiji.ca:id/action_favorite");

    public ProductPage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public boolean postPageVerification(String productText)
    {
        return lowerCaseValidations(adTitle, productText);
    }

    public void clickHeartIcon()
    {
        waitAndClick(heartIcon);
    }

    public void goBackToHomePage()
    {
        appiumDriver.findElementByAccessibilityId(goBackArrow).click();
    }
}
