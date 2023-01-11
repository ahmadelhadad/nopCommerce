package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver = hooks.driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement SearchPOM(){
        return driver.findElement(By.id("small-searchterms"));
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

    public WebElement SearchButtonPOM(){
        return driver.findElement(By.cssSelector("#small-search-box-form > button"));
    }
    public void SearchSteps(String text){
        SearchPOM().sendKeys(text);
        SearchButtonPOM().click();
    }
}
