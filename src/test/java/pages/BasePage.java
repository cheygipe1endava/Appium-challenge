package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private AppiumDriver<MobileElement> appiumDriver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver,this);
        wait = new WebDriverWait(appiumDriver, Long.parseLong("15"));
    }

    public void clickAndSendData(By by, String data)
    {
        WebElement element = appiumDriver.findElement(by);
        element.click();
        element.sendKeys(data);
    }

    public void waitAndClick(By by)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        appiumDriver.findElement(by).click();
    }

    public boolean lowerCaseValidations(By by, String text)
    {
        boolean verifyStatus = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String verificationText = appiumDriver.findElement(by).getText().toLowerCase();
        if(verificationText.contains(text))
        {
            verifyStatus = true;
        }
        return verifyStatus;
    }
}
