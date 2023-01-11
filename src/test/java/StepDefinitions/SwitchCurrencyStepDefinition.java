package StepDefinitions;

import Pages.LoginPage;
import Pages.SwitchCurrencyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class SwitchCurrencyStepDefinition {
    WebDriver driver = hooks.driver;
    SwitchCurrencyPage SC = new SwitchCurrencyPage(driver);
    LoginPage LP = new LoginPage(driver);

    @Given("user navigate to login PageSC")
    public void user_navigates_Login_page() throws InterruptedException {
        LP.UserNavigateToLoginPage();
    }
    @And("^user type \"(.*)\" and \"(.*)\" and press login button$")
    public void valid_dataSC(String email, String password)
    {
        LP.LoginSteps(email,password);

    }
    @When ("^user choose currency from the drop down list \"(.*)\"$")
    public void choose_currency(String Currency){
        if(Objects.equals(Currency, "Euro")) {
            SC.DropList().click();
            SC.CurrencyEuroPOM().click();
        }
    }
    @Then("items price will be converted to the new currency")
    public void prices_changed() throws InterruptedException {
        Thread.sleep(3000);
        String ExpectedResult, ActualResult;
        ActualResult = SC.ItemCurrencyPOM().getText();
        ExpectedResult = "€";
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }
}
