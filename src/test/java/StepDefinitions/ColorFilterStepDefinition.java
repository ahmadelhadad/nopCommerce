package StepDefinitions;

import Pages.ColorFilterPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class ColorFilterStepDefinition {
    WebDriver driver = hooks.driver;
    LoginPage LP = new LoginPage(driver);
    ColorFilterPage CF = new ColorFilterPage(driver);
    Random rr = new Random();
    int SColor = rr.nextInt(2);
    @Given("^user navigate to login pageCF \"(.*)\" and \"(.*)\"$")
    public void UserNavigateToLoginPageCF(String email, String Password) {
        LP.UserNavigateToLoginPage();
        LP.LoginSteps(email,Password);
    }
    @And("user navigate to Category Apparel and Shoes")
    public void navigateToCat(){
        CF.Apparel().click();
        CF.Shoes().click();
    }
    @When("user choose color randomly")
    public void ColorChooser(){
        CF.SelectedColor(Integer.toString(SColor)).click();
    }
    @Then("items appear")
    public void SuccessFilter(){
        if(SColor==0){
            Assert.assertTrue(CF.Shoes1().isDisplayed());
            Assert.assertTrue(CF.Shoes2().isDisplayed());
            Assert.assertTrue(CF.Shoes3().isDisplayed());
        } else if (SColor==1) {
            Assert.assertTrue(CF.Shoes1().isDisplayed());
        }else if (SColor==2) {
            Assert.assertTrue(CF.Shoes1().isDisplayed());
        }
    }
}
