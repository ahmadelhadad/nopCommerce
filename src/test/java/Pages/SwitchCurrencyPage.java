package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SwitchCurrencyPage {
    WebDriver driver = hooks.driver;
    public SwitchCurrencyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement DropList(){
        return driver.findElement(By.id("customerCurrency"));
    }
    public WebElement CurrencyEuroPOM(){
        return driver.findElement(By.cssSelector("#customerCurrency > option:nth-child(2)"));
    }
    public WebElement ItemCurrencyPOM(){
        return driver.findElement(
        By.className("price"));
    }


}
