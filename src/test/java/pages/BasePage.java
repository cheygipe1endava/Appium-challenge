package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private AppiumDriver appiumDriver;

    public BasePage(AppiumDriver appiumDriver)
    {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver,this);
    }

    public void clickAndSendData(By by, String data){
        WebElement element = appiumDriver.findElement(by);
        element.click();
        element.sendKeys(data);
    }
}
