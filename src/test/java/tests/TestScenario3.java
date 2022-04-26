package tests;

import com.github.javafaker.Faker;
import constants.LambdaTestConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.InputFormSubmitPage;
import pageobjects.SeleniumPlaygroundPage;

import static org.testng.Assert.assertTrue;

public class TestScenario3 extends  BaseTest{


    @Test(dataProvider = "name")
    public void testScenario3(String br,String v,String p) throws InterruptedException {
        Faker faker = new Faker();
        SeleniumPlaygroundPage seleniumPlaygroundPage = new SeleniumPlaygroundPage();
        assertTrue(seleniumPlaygroundPage.isPageLoaded());
        InputFormSubmitPage inputFormSubmitPage = seleniumPlaygroundPage.clickOnInputFormSubmit();
        assertTrue(inputFormSubmitPage.isPageLoaded());

        boolean displayedMessage = inputFormSubmitPage
                .clickOnSubmitButton()
                .enterName(faker.name().firstName())
                .enterEmail(faker.internet().emailAddress())
                .enterPassword(faker.internet().password())
                .enterCompany("Sayajiraje Bagal")
                .enterWebSite(faker.internet().url())
                .selectCountryByVisibleText(LambdaTestConstants.UNITED_STATES)
                .enterCity(faker.address().cityName())
                .enterAddress1(faker.address().streetAddress())
                .enterAddress2(faker.address().secondaryAddress())
                .enterState(faker.address().state())
                .enterZipCode(faker.address().zipCode())
                .clickOnSubmitButton()
                .isDisplayedMessage();
        assertTrue(displayedMessage);
        Status = "passed";
        Thread.sleep(150);

        System.out.println("testScenario3Finished");


    }
    @DataProvider(name = "name",parallel = true)
    public  Object[][] name() {
        return new Object[][]{
                {"Chrome" , "88.0" ,"Windows 10"},
                {"MicrosoftEdge" , "87.0" , "macOS Sierra"},
                {"Firefox" ,"82.0" , "Windows 7"},
                {"Internet Explorer" , "11.0" , "Windows 10"}
        };
    }


}
