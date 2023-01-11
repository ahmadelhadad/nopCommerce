package StepDefinitions;

import Pages.LoginPage;
import Pages.ShoppingCartPage;
import Pages.WishlistPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WishlistStepDefinition {
    WebDriver driver = hooks.driver;
    LoginPage LP = new LoginPage(driver);
    WishlistPage WL = new WishlistPage(driver);
    Actions action = new Actions(driver);
    boolean exist;
    int qty=0;
    @Given("user navigate to Login pageW")
    public void user_navigates_Login_pageW()
    {
        LP.UserNavigateToLoginPage();
    }
    @And ("^user Login to site with \"(.*)\" and \"(.*)\"$")
    public void loginW(String email, String password){
        LP.LoginSteps(email,password);
    }
    @When("user click on add to wishlist button and be redirected to the product page")
    public void clickOnWishlistHP(){
    action.sendKeys(Keys.PAGE_DOWN).build().perform();
        WL.WishlistHP().click();
    }
    @And("user click on add to wishlist button")
    public void clickOnWishlistP() throws InterruptedException {
        Thread.sleep(500);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        WL.addToWishlistP().click();
    }
    @Then("Flash message should appear")
    public void FlashMessage() throws InterruptedException {
        Thread.sleep(500);
        action.sendKeys(Keys.PAGE_UP).build().perform();
        String ActualResult = WL.FlashMsg().getText();
        String ExpectedResult = "The product has been added to your wishlist";
        Assert.assertTrue("Wrong Flash MSG",ActualResult.contains(ExpectedResult));
    }
    @And("the added product exists in Wishlist")
    public void ProductExist() throws InterruptedException {
        Thread.sleep(500);
        //CloseFlashMSG
        driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/span")).click();
        //ClickOnShoppingCartLabel
        WL.navigateToWishlist();
        Thread.sleep(1000);
        System.out.println(qty+"A1");
        qty = Integer.parseInt(WL.Qty().getAttribute("value"));
        System.out.println(qty+"A2");
        if(qty>0){exist=true;}
        Assert.assertTrue("Item Is not In Cart",exist);
    }
}
