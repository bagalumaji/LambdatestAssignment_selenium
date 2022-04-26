package pageobjects;

import org.openqa.selenium.By;

public class SeleniumPlaygroundPage extends BasePage {
    By seleniumPlayground = By.xpath("//*[normalize-space()='Selenium Playground']");
    By linkSimpleDemo = By.linkText("Simple Form Demo");
    By linkDragAndDropSliders = By.linkText("Drag & Drop Sliders");
    By linkInputFormSubmit = By.linkText("Input Form Submit");

    public InputFormSubmitPage clickOnInputFormSubmit(){
        click(linkInputFormSubmit,"clicked on Input Form Submit link");
        return new InputFormSubmitPage();
    }

    public DragDropRangeSlidersDemoPage clickOnDragAndDropSliders() {
        click(linkDragAndDropSliders, "clicked on drag & drop sliders");
        return new DragDropRangeSlidersDemoPage();
    }

    @Override
    public boolean isPageLoaded() {
        return waitForElement(seleniumPlayground);
    }

    public SimpleFormDemoPage clickOnSimpleFormDemo() {
        click(linkSimpleDemo, "clicked on Simple Form Demo");
        return new SimpleFormDemoPage();
    }
}
