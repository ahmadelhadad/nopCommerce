package StepDefinitions;

import Pages.LoginPage;
import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginStepDefinition {

    WebDriver driver = hooks.driver;
    LoginPage LP = new LoginPage(driver);
    @Given("user navigate to login pageL")
    public void user_navigates_Login_page() throws InterruptedException {
       LP.UserNavigateToLoginPage();
    }
    @When("^user enter \"(.*)\" and \"(.*)\" and press login button$")
    public void valid_data(String email, String password)
    {
        LP.LoginSteps(email,password);

    }
    @Then("user could login successfully and go to main page")
    public void success_login()
    {
        String expectedResult ="https://demo.nopcommerce.com/";
        String actualResult = driver.getCurrentUrl();

        // First assertion
        Assert.assertTrue(actualResult.contains(expectedResult));

        // Second assertion
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isEnabled());
    }
}
