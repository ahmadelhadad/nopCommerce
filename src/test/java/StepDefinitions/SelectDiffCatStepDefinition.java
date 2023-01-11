package StepDefinitions;

import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SelectDiffCatPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectDiffCatStepDefinition {
    WebDriver driver = hooks.driver;
    ArrayList<String> MainCategories = new ArrayList<String>();
    SelectDiffCatPage SP = new SelectDiffCatPage(driver);
    LoginPage LP = new LoginPage(driver);
    Random rr = new Random();
    int SMCategory = rr.nextInt(7);
    int SelectedSubCat = rr.nextInt(3);

    boolean hasSub;
    @Given("^user navigate to login pageSD \"(.*)\" and \"(.*)\"$")
    public void UserNavigateToLoginPageSD(String email, String Password) {
        LP.UserNavigateToLoginPage();
        LP.LoginSteps(email,Password);
    }
    @When("User hover on one of the categories")
    public void userHover(){
        if(SMCategory==0){SMCategory+=1;}
        Actions action = new Actions(hooks.driver);
        action.moveToElement(SP.MCategories(Integer.toString(SMCategory))).perform();
    }
    @And("user select one of the subCategories to View")
    public void selectSCat() throws InterruptedException {

        if(SMCategory<4) {
            if(SelectedSubCat==0){SelectedSubCat+=1;}
            hasSub = true;
            Actions action = new Actions(hooks.driver);
            action.moveToElement(SP.SCategories(Integer.toString(SelectedSubCat), Integer.toString(SMCategory))).perform();
            SP.SCategories(Integer.toString(SelectedSubCat), Integer.toString(SMCategory)).click();
        }
        else {
            hasSub = false;
            SP.MCategories(Integer.toString(SMCategory)).click();
        }
    }
    @Then("Page title must be same as the selected category")
    public void SuccessSelection(){
        String ActualResult = SP.Header().getText();
        String ExpectedResult;
        if(!hasSub) {
            ExpectedResult = SP.MCategories(Integer.toString(SMCategory)).getText();
            Assert.assertTrue(ActualResult.contains(ExpectedResult));
        }else {
            ExpectedResult = SP.SCategories(Integer.toString(SelectedSubCat), Integer.toString(SMCategory)).getText();
            Assert.assertTrue(ActualResult.contains(ExpectedResult));
        }
    }
}
