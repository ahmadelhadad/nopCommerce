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

public class RegisterStepDefinition {
    WebDriver driver = hooks.driver;
    RegisterPage RP = new RegisterPage(driver);
    @Given("user navigate to register page")
    public void user_navigates_register_page()
    {
        RP.registerPOM().click();
    }
    @When("user choose gender")
    public void user_choose_gender(){
    RP.genderPOM().click();
    }
    @And("^user enter firstName \"(.*)\"$")
    public void user_enter_firstName(String firstname){
        //RP.firstnamePOM().clear();
        RP.firstnamePOM().sendKeys(firstname);
    }
    @And("^user enter lastName \"(.*)\"$")
    public void user_enter_lastName(String lastname){
        //RP.lastnamePOM().clear();
        RP.lastnamePOM().sendKeys(lastname);
    }
    @And("^user enter date \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void user_enter_date(String day, String month, String year){
        RP.DateOfBirthDayPOM().sendKeys(day);
        RP.DateOfBirthMonthPOM().sendKeys(month);
        RP.DateOfBirthYearPOM().sendKeys(year);
    }
    @And("^user enter companyName \"(.*)\"$")
    public void user_enter_companyName(String companyName){
        RP.CompanyNamePOM().sendKeys(companyName);
    }
    @And("^user enter email \"(.*)\"$")
    public void user_enter_email(String email){
        RP.emailPOM().sendKeys(email);
    }
    @And("^user enter password \"(.*)\"$")
    public void user_enter_password(String password){
        RP.passwordPOM().sendKeys(password);
    }
    @And("^user enter confirmation password \"(.*)\"$")
    public void user_enter_C_password(String Cpassword){
        RP.passwordConfirmPOM().sendKeys(Cpassword);
    }
    @And("user press register button")
    public void register_button()
    {
        RP.RegisterButtonPOM().click();
    }
    @Then("user could register successfully")
    public void success_register()
    {
        String expectedResult ="Your registration completed";
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText();


        // First assertion
        Assert.assertTrue(actualResult.equals(expectedResult));

        // Second assertion
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")).isDisplayed());
    }
    @And("user go to register result page")
    public void register_page()
    {
      String  Expected = "https://demo.nopcommerce.com/registerresult";
      String Actual = driver.getCurrentUrl();
        Assert.assertTrue(Actual.contains(Expected));
    }
}
