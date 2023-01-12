package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CompareListPage {
    WebDriver driver = hooks.driver;
    public CompareListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement CompareListItemB(){
        return driver.findElement(By.xpath(
"/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/button[2]"));
    }
    public WebElement CompareListIcon(){
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a"));
    }
    public WebElement ItemAddedLink(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/a"));
    }
    public WebElement SuccessMSG(){
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }

}
