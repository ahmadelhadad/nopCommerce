package StepDefinitions;

import Pages.CompleteOrderPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CompleteOrderStepDefinition {
    WebDriver driver = hooks.driver;
    LoginPage LP = new LoginPage(driver);
    Actions action = new Actions(driver);
    CompleteOrderPage CO = new CompleteOrderPage(driver);

    @Given("^user login with \"(.*)\" and \"(.*)\"$")
    public void Login(String email, String password) throws InterruptedException {
        LP.UserNavigateToLoginPage();
        Thread.sleep(1000);
        LP.LoginSteps(email,password);
    }
    @When("user add item to cart and click on shoppingCart icon")
    public void AddItem() throws InterruptedException {
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        CO.ItemAddToCart().click();
        Thread.sleep(1000);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        CO.AddToCartPP().click();
        action.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/span")).click();
        CO.ShoppingCartIcon().click();
        Thread.sleep(1000);
    }
    @And("click on Checkout button")
    public void Checkout(){
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        CO.termsButton().click();
        CO.checkoutButton().click();
    }
    @And("^user add Checkout valid data \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" and click continue button$")
    public void CheckoutValidData(String firstname, String lastname, String email,String country, String city, String Address1, String postalCode, String phone) throws InterruptedException {
        CO.firstname().clear();
        CO.firstname().sendKeys(firstname);
        CO.lastname().clear();
        CO.lastname().sendKeys(lastname);
        CO.email().clear();
        CO.email().sendKeys(email);
        CO.Country().sendKeys(country);
        CO.city().sendKeys(city);
        CO.Address1().sendKeys(Address1);
        CO.postalCode().sendKeys(postalCode);
        CO.phone().sendKeys(phone);
        CO.BillingContinue().click();
        Thread.sleep(500);
    }
    @And("continue shipping method")
    public void ContinueShippingMethod() throws InterruptedException {
        CO.shippingMethodContinue().click();
        Thread.sleep(500);
    }
    @And("continue payment method")
    public void ContinuePaymentMethod() throws InterruptedException {
        CO.paymentMethodContinue().click();
        Thread.sleep(500);
    }
    @And("continue payment information")
    public void ContinuePaymentInfo() throws InterruptedException {
        CO.paymentInfoContinue().click();
        Thread.sleep(500);
    }
    @And("user confirm order")
    public void ConfirmOrder() throws InterruptedException {
        CO.ConfirmOrder().click();
        Thread.sleep(500);
    }
    @Then("success Message appear")
    public void SuccessMSG(){
        String ActualResult = CO.SuccessMSG().getText();
        String ExpectedResult = "Your order has been successfully processed!";
        Assert.assertTrue("Order Failed",ActualResult.contains(ExpectedResult));
    }

}
