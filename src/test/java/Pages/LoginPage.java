package Pages;
import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver = hooks.driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement emailPOM(){
        return driver.findElement(By.xpath("//*[@id=\"Email\"]"));
    }

    public WebElement passwordPOM(){
        return driver.findElement(By.xpath("//*[@id=\"Password\"]"));
    }

    public WebElement loginButtonPOM(){
        return driver.findElement(By.cssSelector(
    "body > div.master-wrapper-page > div.master-wrapper-content " +
    "> div > div > div > div.page-body > div.customer-blocks > " +
    "div.returning-wrapper.fieldset > form > div.buttons > button"));
    }
    public void LoginSteps(String email , String Password){
        emailPOM().sendKeys(email);
        passwordPOM().sendKeys(Password);
        loginButtonPOM().click();
    }
    public void UserNavigateToLoginPage()
    {
        driver.navigate().to("https://demo.nopcommerce.com/login");
    }

}
