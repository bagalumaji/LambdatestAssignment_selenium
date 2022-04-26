package pageobjects;

import constants.LambdaTestConstants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitForSeconds;

import java.time.Duration;

public abstract class BasePage {
    public abstract boolean isPageLoaded();
    protected WebDriverWait webDriverWait;
    protected BasePage(){
        webDriverWait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(LambdaTestConstants.EXPLICIT_WAIT_TIME));
    }
    public boolean waitForElement(By locator){
       return isDisplayed(locator,"waiting for element");
    }
    protected void click(By locator,String logger){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        System.out.println(logger);

    }
    protected boolean isDisplayed(By locator,String logger){
        boolean status;
        try {
            status = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
            System.out.println(logger + " " + status);
        }catch (TimeoutException e){
            return false;
        }
        return status;
    }
    public String  getCurrentUrl(){
        WaitForSeconds.waitForTwoSeconds();
        return DriverManager.getDriver().getCurrentUrl();
    }
    public void enterText(By locator,String value,String logger){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(value);
        System.out.println(logger+" "+value);
    }
}
