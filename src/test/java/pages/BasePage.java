package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private AppiumDriver appiumDriver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver appiumDriver)
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
}
