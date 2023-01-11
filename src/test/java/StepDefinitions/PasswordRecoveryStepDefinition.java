package StepDefinitions;

import Pages.PasswordRecoveryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryStepDefinition {
    WebDriver driver = hooks.driver;
    PasswordRecoveryPage pw = new PasswordRecoveryPage(driver);
    @Given("user navigate to password recovery page")
    public void user_navigates_PasswordRecovery_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/passwordrecovery");
    }
    @When("^user enter his email \"(.*)\"$")
    public void enter_email(String email)
    {
        pw.emailPRPOM().sendKeys(email);
    }

    @And("click recover Button")
    public void click_recover(){
        pw.recoverButtonPOM().click();
    }
    @Then("success recover")
    public void success_recover(){
        String expectedResult ="Email with instructions has been sent to you.";
        String actualResult = pw.flashPOM().getText();

        // First assertion
        Assert.assertTrue(actualResult.contains(expectedResult));

        // Second assertion
    }

}
