package StepDefinitions;

import Pages.ColorFilterPage;
import Pages.DifferentTagsPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DifferentTagsStepDefinition {
    WebDriver driver = hooks.driver;
    LoginPage LP = new LoginPage(driver);
    ColorFilterPage CF = new ColorFilterPage(driver);
    DifferentTagsPage DT = new DifferentTagsPage(driver);
    @Given("^user navigate to login pageDT \"(.*)\" and \"(.*)\"$")
    public void UserNavigateToLoginPageDT(String email, String Password) {
        LP.UserNavigateToLoginPage();
        LP.LoginSteps(email,Password);
    }
    @And("navigate to category")
    public void navigate_to_category(){
        CF.Apparel().click();
    }
    @When("user select Tag")
    public void TagSelect() throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        DT.selectTag().click();
    }
    @Then("user should be redirected to the tag page and items with the same tag should be displayed")
        public void redirectToTagPage(){
         String ExpectedResult = "https://demo.nopcommerce.com/awesome";
         String ActualResult = driver.getCurrentUrl();

         String ExpectedResult2 = "Products tagged with 'awesome'";
        String ActualResult2 = DT.header().getText();

        Assert.assertTrue(ActualResult.contains(ExpectedResult));

        Assert.assertTrue(ActualResult2.contains(ExpectedResult2));
    }
}
