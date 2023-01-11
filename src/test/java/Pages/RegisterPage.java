package Pages;

import StepDefinitions.hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver = hooks.driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement registerPOM(){
        return driver.findElement(By.className("ico-register"));
    }
    public WebElement genderPOM(){
        return driver.findElement(By.xpath("//*[@id=\"gender\"]/span[1]/label"));
    }
    public WebElement firstnamePOM(){
        return driver.findElement(By.xpath("//*[@id=\"FirstName\"]"));
    }
    public WebElement lastnamePOM(){
        return driver.findElement(By.xpath("//*[@id=\"LastName\"]"));
    }
    public WebElement emailPOM(){
        return driver.findElement(By.xpath("//*[@id=\"Email\"]"));
    }
    public WebElement DateOfBirthDayPOM(){
        return driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement DateOfBirthMonthPOM(){
        return driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement DateOfBirthYearPOM(){
        return driver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement CompanyNamePOM(){
        return driver.findElement(By.xpath("//*[@id=\"Company\"]"));
    }
    public WebElement NewsLetterPOM(){
        return driver.findElement(By.xpath("//*[@id=\"Newsletter\"]"));
    }
    public WebElement passwordPOM(){
        return driver.findElement(By.xpath("//*[@id=\"Password\"]"));
    }
    public WebElement passwordConfirmPOM(){
        return driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]"));
    }

    public WebElement RegisterButtonPOM(){
        return driver.findElement(By.xpath("//*[@id=\"register-button\"]"));
    }

    public void RegisterSteps(String username , String lastname , String day , String month , String year , String email, String CompanyName, String password){
        genderPOM().click();



        emailPOM().sendKeys(email);


        NewsLetterPOM().click();

        passwordPOM().sendKeys(password);
        passwordConfirmPOM().sendKeys(password);

        RegisterButtonPOM().click();

    }

}
