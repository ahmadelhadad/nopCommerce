package StepDefinitions;

import Pages.LoginPage;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchStepDefinition {
    WebDriver driver = hooks.driver;
    SearchPage SP = new SearchPage(driver);
    LoginPage LP = new LoginPage(driver);
    @Given("user navigate to login pages")
    public void user_navigates_Login_pageS()
    {
        LP.UserNavigateToLoginPage();
    }
    @When("^user enter \"(.*)\" and \"(.*)\" and press login buttonS$")
    public void valid_dataS(String email, String password)
    {
        LP.LoginSteps(email, password);
    }
    @And("user navigate to Home page")
    public void user_navigates_Login_page()
    {
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @When("^user type search data and click search button \"(.*)\"$")
    public void user_type_search_data(String text){
        SP.SearchSteps(text);
    }
    @Then("user redirected to search page")
    public void user_redirected(){
        String ExpectedResult = "https://demo.nopcommerce.com/search";
        String ActualResult = driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }
    @And("user search items appear")
    public void user_search_items_appear(){
        Assert.assertTrue(driver.findElement(By.xpath(
        "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")
        ).isDisplayed());

    }
}
