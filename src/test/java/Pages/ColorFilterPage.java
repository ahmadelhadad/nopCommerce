package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class ColorFilterPage {
    WebDriver driver = hooks.driver;
    public ColorFilterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement SelectedColor(String SColor){
        if(Objects.equals(SColor, "0")){SColor="14";}if(Objects.equals(SColor, "1")){SColor="15";}if(Objects.equals(SColor, "2")){SColor="16";}
        return driver.findElement(By.xpath("//*[@id=\"attribute-option-"+SColor+"\"]"));
    }
    public WebElement Apparel(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
    }
    public WebElement Shoes(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img"));
    }
    public WebElement Shoes1(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/a/img"));
    }
    public WebElement Shoes2(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[1]/a/img"));
    }
    public WebElement Shoes3(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img"));
    }

}
