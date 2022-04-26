package pageobjects;

import org.openqa.selenium.By;

import static constants.LambdaTestXpathConstants.visibleText;
import static utils.DynamicXpathUtil.getXpath;

public class SimpleFormDemoPage extends BasePage{
    By txtUserMessage=By.id("user-message");
    By btnGetCheckedValue=By.id("showInput");

    public SimpleFormDemoPage clickOnGetCheckedValue(){
        click(btnGetCheckedValue,"clicked on Get Checked Value button");
        return this;
    }
    public SimpleFormDemoPage enterUserMessage(String message){
        enterText(txtUserMessage,message,"entered text into get checked value ");
        return this;
    }
    public boolean isDisplayed(String message){
        return isDisplayed(getXpath(visibleText,message),"Status of element ");
    }
    @Override
    public boolean isPageLoaded() {
        return waitForElement(txtUserMessage);
    }
}
