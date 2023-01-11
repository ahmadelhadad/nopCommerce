package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DifferentTagsPage {
    WebDriver driver = hooks.driver;
    public DifferentTagsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement selectTag(){
        return driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > " +
        "div > div.side-2 > div.block.block-popular-tags > div.listbox > div.tags > ul > li:nth-child(2) > a"));
    }
    public WebElement header(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1"));
    }

}
