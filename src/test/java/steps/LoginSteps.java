package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import helper.HookHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class LoginSteps {

    private AppiumDriver appiumDriver;
    private HomePage homePage;

    public LoginSteps(HookHelper hookHelper)
    {
        appiumDriver = hookHelper.getAppiumDriver();
    }

    @Given("the user is in Kijiji's home page")
    public void theUserIsInKijijiSHomePage()
    {
        homePage = new HomePage(appiumDriver);
    }

    @And("the user clicks on menu icon")
    public void theUserClicksOnMenuIcon()
    {
        homePage.clickMenuIcon();
    }

    @When("the user clicks on sign in button and selects sign in option button")
    public void theUserClicksOnSignInButtonAndSelectsSignInOptionButton()
    {
        homePage.clickSignInButtonFromMenu();
        homePage.clickSignInOptionButton();
    }

    @And("types in its credentials for email and password and enters them clicking sign in button")
    public void typesInItsCredentialsForEmailAndPasswordAndEntersThemClickingSignInButton(DataTable fields)
    {
        homePage.processDataInsert(fields);
        homePage.inputEmailAndPassword();
        homePage.clickSignInButton();
    }

    @Then("the user should be signed in")
    public void theUserShouldBeSignedIn()
    {
        Assert.assertTrue("Successfully logged in", homePage.logInSession());
    }

    @And("the user logs out from session")
    public void theUserLogsOutFromSession()
    {
        homePage.logOutSteps();
        Assert.assertTrue("Successfully logged in", homePage.logOutSession());
    }
}