package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CompleteOrderPage {
    WebDriver driver = hooks.driver;
    public CompleteOrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement ItemAddToCart(){return driver.findElement(By.xpath(
"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]"));}

    public WebElement AddToCartPP(){return driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-4\"]"));}

    public WebElement ShoppingCartIcon(){return driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));}

    public WebElement termsButton(){return driver.findElement(By.xpath("//*[@id=\"termsofservice\"]"));}

    public WebElement checkoutButton(){return driver.findElement(By.xpath("//*[@id=\"checkout\"]"));}

    public WebElement firstname(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]"));}
    public WebElement lastname(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_LastName\"]"));}

    public WebElement email(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Email\"]"));}

    public WebElement Country(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));}

    public WebElement city(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]"));}
    public WebElement Address1(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]"));}
    public WebElement postalCode(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]"));}

    public WebElement phone(){return driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]"));}
    public WebElement BillingContinue(){return driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));}

    public WebElement shippingMethodContinue(){return driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));}

    public WebElement paymentMethodContinue(){return driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));}

    public WebElement paymentInfoContinue(){return driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));}

    public WebElement ConfirmOrder(){return driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));}
    public WebElement SuccessMSG(){return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong"));}
}
