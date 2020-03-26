package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage
{
    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;
    private By adTitle = By.id("com.ebay.kijiji.ca:id/adTitle");

    public ProductPage(AppiumDriver<MobileElement> appiumDriver)
    {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public boolean postPageVerification(String productText)
    {
        return lowerCaseValidations(adTitle, productText);
    }
}
