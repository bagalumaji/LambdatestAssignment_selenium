package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.DragDropRangeSlidersDemoPage;
import pageobjects.SeleniumPlaygroundPage;
import utils.WaitForSeconds;

import static org.testng.Assert.assertTrue;

public class TestScenario2 extends BaseTest{
    @Test(dataProvider = "name")
    public void testScenario2(String br,String v,String p) {
        SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage();
        assertTrue(seleniumPlaygroundPage.isPageLoaded());
        DragDropRangeSlidersDemoPage dragDropRangeSlidersDemoPage = seleniumPlaygroundPage.clickOnDragAndDropSliders();
        assertTrue(dragDropRangeSlidersDemoPage.isPageLoaded());
        String textOfSlider15 = dragDropRangeSlidersDemoPage.moveSliderTo95(96, 0).getTextOfSlider15();
        System.out.println("textOfSlider15 = " + textOfSlider15);
        Assert.assertEquals(textOfSlider15,"95");
        Status = "passed";
        WaitForSeconds.waitForSecond();
        System.out.println("TestScenario2Finished");
    }
    @DataProvider(name = "name",parallel = true)
    public  Object[][] name() {
        return new Object[][]{
                {"Chrome" , "88.0" ,"Windows 10"},
        };
    }
}
