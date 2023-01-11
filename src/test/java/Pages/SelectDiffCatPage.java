package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectDiffCatPage {
    WebDriver driver = hooks.driver;
    public SelectDiffCatPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement MCategories(String SelectedMainCat){
      return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[" + SelectedMainCat + "]/a"));
    }
    public WebElement SCategories(String SelectedSubCat, String SelectedMainCat){
    return driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(" + SelectedMainCat + ") > ul > li:nth-child(" + SelectedSubCat + ") > a"));
    }
    public WebElement Header(){
        return driver.findElement(By.cssSelector(
"body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-title > h1"));
    }

}
