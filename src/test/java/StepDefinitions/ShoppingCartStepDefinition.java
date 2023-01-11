package StepDefinitions;

import Pages.LoginPage;
import Pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartStepDefinition {
    WebDriver driver = hooks.driver;
    LoginPage LP = new LoginPage(driver);
    ShoppingCartPage SC = new ShoppingCartPage(driver);
    Actions action = new Actions(driver);
    boolean exist;
    int qty=0;
    @Given("user navigate to Login pageSCa")
    public void user_navigates_Login_pageSCa()
    {
        LP.UserNavigateToLoginPage();
    }
    @And ("^user Login with \"(.*)\" and \"(.*)\"$")
    public void login(String email, String password){
        LP.LoginSteps(email,password);
    }
    @When("user click on add to cart button and be redirected to the product page")
    public void clickOnAddToCartHP(){
    action.sendKeys(Keys.PAGE_DOWN).build().perform();
    SC.addToCartHP().click();
//    String ActualResult = driver.getCurrentUrl();
//    String ExpectedResult = "https://demo.nopcommerce.com/apple-macbook-pro-13-inch";
//        Assert.assertTrue("Wrong URL",ActualResult.contains(ExpectedResult));
    }
    @And("user click on add to cart button")
    public void clickOnAddToCartP() throws InterruptedException {
        Thread.sleep(500);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        SC.addToCartP().click();
    }
    @Then("Flash msg Should appear")
    public void FlashMsg() throws InterruptedException {
        Thread.sleep(500);
        action.sendKeys(Keys.PAGE_UP).build().perform();
        String ActualResult = SC.FlashMsg().getText();
        String ExpectedResult = "The product has been added to your shopping cart";
        Assert.assertTrue("Wrong Flash MSG",ActualResult.contains(ExpectedResult));
    }
    @And("the added product exists in shopping cart")
    public void ProductExist() throws InterruptedException {
        Thread.sleep(500);
        //CloseFlashMSG
        driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/span")).click();
        //ClickOnShoppingCartLabel
        SC.navigateToShoppingCart();
        Thread.sleep(1000);
        System.out.println(qty+"A1");
        qty = Integer.parseInt(SC.Qty().getAttribute("value"));
        System.out.println(qty+"A2");
        if(qty>0){exist=true;}
        Assert.assertTrue("Item Is not In Cart",exist);
    }
}
