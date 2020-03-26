package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavouritesPage extends BasePage
{
    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;
    private String menu = "Navigate up";
    private By adTitle = By.id("com.ebay.kijiji.ca:id/ad_title");
    private By noAdsAddedText = By.id("com.ebay.kijiji.ca:id/noAdsTitle");

    public FavouritesPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public boolean verifyFavouritesPostAdded(String productText)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adTitle));
        return lowerCaseValidations(adTitle, productText);
    }

    public void clickFavouritesPostAdded()
    {
        appiumDriver.findElement(adTitle).click();
    }

    public void openMenu()
    {
        appiumDriver.findElementByAccessibilityId(menu).click();
    }

    public boolean noAdsAddedAsFavourites()
    {
        boolean verifyNoAdsAddedAsFavouritesState = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(noAdsAddedText));
        if (appiumDriver.findElement(noAdsAddedText).getText().equals("You do not have any favourites"))
        {
            verifyNoAdsAddedAsFavouritesState = true;
        }
        return verifyNoAdsAddedAsFavouritesState;
    }
}
