package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage {
    WebDriver driver = hooks.driver;
    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement emailPRPOM(){
        return driver.findElement(By.xpath("//*[@id=\"Email\"]"));
    }
    public WebElement flashPOM(){
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }
    public WebElement recoverButtonPOM(){
        return driver.findElement(By.name("send-email"));
    }
}
