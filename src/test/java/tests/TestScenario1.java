package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.SeleniumPlaygroundPage;
import pageobjects.SimpleFormDemoPage;
import utils.WaitForSeconds;

import static constants.LambdaTestConstants.*;

public class TestScenario1 extends BaseTest{
    @Test(dataProvider = "name")
    public void testScenario1(String br,String v,String p) {
        SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage();
        Assert.assertTrue(seleniumPlaygroundPage.isPageLoaded());
        SimpleFormDemoPage simpleFormDemoPage = seleniumPlaygroundPage.clickOnSimpleFormDemo();
        String  currentUrl = simpleFormDemoPage.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        Assert.assertTrue(currentUrl.contains(SIMPLE_FORM_DEMO));

        boolean displayed = simpleFormDemoPage
                .enterUserMessage(WELCOME_TO_LAMBDA_TEST)
                .clickOnGetCheckedValue()
                .isDisplayed(WELCOME_TO_LAMBDA_TEST);

        Assert.assertTrue(displayed);
        Status = "passed";
        WaitForSeconds.waitForSecond();
        System.out.println("TestScenario1Finished");
    }

    @DataProvider(name = "name",parallel = true)
    public  Object[][] name() {
        return new Object[][]{
                {"Chrome" , "88.0" ,"Windows 10"},
        };
    }
}
