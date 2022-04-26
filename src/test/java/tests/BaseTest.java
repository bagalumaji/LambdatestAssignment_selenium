package tests;


import driver.Driver;
import driver.DriverManager;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class BaseTest {

    protected BaseTest() {}
    protected String Status = "failed";

    @BeforeMethod(alwaysRun = true)
    public void setup(Method m, ITestContext ctx, Object[] params) {
        List<Object> testData = Arrays.asList(params);

        String platform=testData.get(2).toString();
        String browserName =  testData.get(0).toString();
        String version =testData.get(1).toString();
        Driver.initDriver(m,browserName,version,platform);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.getDriver().executeScript("lambda-status=" + Status);
        Driver.quitDriver();
    }
}