package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class InputFormSubmitPage extends BasePage {
    By btnSubmit = By.xpath("//button[normalize-space()='Submit']");
    By txtName = By.id("name");
    By txtCompany = By.id("company");
    By txtWebSite = By.id("websitename");
    By txtEmail = By.name("email");
    By txtPassword = By.id("inputPassword4");
    By selectCountry = By.name("country");
    By txtCity = By.id("inputCity");
    By txtInputAddress1 = By.id("inputAddress1");
    By txtInputAddress2 = By.id("inputAddress2");
    By txtInputState = By.id("inputState");
    By txtZipcode = By.name("zip");
    By textThanksForContactingUs = By.xpath("//p[text()='Thanks for contacting us, we will get back to you shortly.']");

    public boolean isDisplayedMessage() {
        return isDisplayed(textThanksForContactingUs, "waiting for message to display");
    }

    public InputFormSubmitPage enterCompany(String cname) {
        enterText(txtCompany, cname, "entered company name ");
        return this;
    }

    public InputFormSubmitPage enterWebSite(String webSite) {
        enterText(txtWebSite, webSite, "entered web site ");
        return this;
    }

    public InputFormSubmitPage enterName(String name) {
        enterText(txtName, name, "entered name ");
        return this;
    }

    public InputFormSubmitPage enterEmail(String email) {
        enterText(txtEmail, email, "entered email ");
        return this;
    }

    public InputFormSubmitPage enterPassword(String password) {
        enterText(txtPassword, password, "entered password ");
        return this;
    }

    public InputFormSubmitPage selectCountryByVisibleText(String countryName) {
        new Select(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(selectCountry))).selectByVisibleText(countryName);
        return this;
    }

    public InputFormSubmitPage enterCity(String city) {
        enterText(txtCity, city, "entered city ");
        return this;
    }

    public InputFormSubmitPage enterAddress1(String address) {
        enterText(txtInputAddress1, address, "entered address1 ");
        return this;
    }

    public InputFormSubmitPage enterAddress2(String address) {
        enterText(txtInputAddress2, address, "entered address2 ");
        return this;
    }

    public InputFormSubmitPage enterState(String state) {
        enterText(txtInputState, state, "entered state ");
        return this;
    }

    public InputFormSubmitPage enterZipCode(String zipCode) {
        enterText(txtZipcode, zipCode, "entered zipcode ");
        return this;
    }


    @Override
    public boolean isPageLoaded() {
        return waitForElement(btnSubmit);
    }

    public InputFormSubmitPage clickOnSubmitButton() {
        click(btnSubmit, "clicked on submit button");
        return this;
    }
}
