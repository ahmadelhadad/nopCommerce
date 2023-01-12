package StepDefinitions;

import Pages.CompareListPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CompareListStepDefinition {
    WebDriver driver = hooks.driver;
    LoginPage LP = new LoginPage(driver);
    Actions action = new Actions(driver);
    CompareListPage CL = new CompareListPage(driver);
    String ActualResult;
    String ExpectedResult;
    @Given("user navigate to Login pageCL")
    public void UserNavigateToLoginPageCL(){LP.UserNavigateToLoginPage();}

    @And("^user Login with \"(.*)\" and \"(.*)\" to site$")
    public void UserLoginCL(String email, String password){LP.LoginSteps(email,password);}

    @When("user click on add to CompareList button")
    public void UserClickOnCompareListButton() throws InterruptedException {
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(500);
        CL.CompareListItemB().click();
    }
    @And("Success message will appear and user click on CompareList icon")
    public void SuccessMsg() throws InterruptedException {
        action.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(500);
        ActualResult = CL.SuccessMSG().getText();
        ExpectedResult = "The product has been added to your product comparison";
        Assert.assertTrue("Error on success MSG",ActualResult.contains(ExpectedResult));
        CL.CompareListIcon().click();
    }
    @Then("item exist in CompareList page")
    public void ItemExistINCLPage(){
        ActualResult = CL.ItemAddedLink().getText();
        ExpectedResult = "Build your own computer";
        Assert.assertTrue("Wrong Item or not Exist",ActualResult.contains(ExpectedResult));
    }
}
