package pageobjects;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.stream.Stream;

import static utils.WaitForSeconds.waitForSecond;
import static utils.WaitForSeconds.waitForTwoSeconds;

public class DragDropRangeSlidersDemoPage extends BasePage{
    By textRangeSliders = By.xpath("//*[text()='Range Sliders']");
    By inputSlider15 = By.xpath("//div[@id='slider3']//input");
    By outputSlider15 = By.xpath("//div[@id='slider3']//output");

    public DragDropRangeSlidersDemoPage moveSliderTo95(int x,int y){
        Actions actions = new Actions(DriverManager.getDriver());
        waitForTwoSeconds();
        actions.dragAndDropBy(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(inputSlider15)),x,y).build().perform();
        waitForSecond();
        System.out.println("slider move to ");
        String text = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(outputSlider15)).getText();
        System.out.println("text = " + text);
        return this;
    }

    public String getTextOfSlider15(){
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(outputSlider15)).getText();
    }
    @Override
    public boolean isPageLoaded() {
        return waitForElement(textRangeSliders);
    }
}
