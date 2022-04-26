package utils;

import org.openqa.selenium.By;

public final class DynamicXpathUtil {
    private DynamicXpathUtil(){}

    public static By getXpath(String xpath,String value){
        return By.xpath(String.format(xpath,value));
    }
}
