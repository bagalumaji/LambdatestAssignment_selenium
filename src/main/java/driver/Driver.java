package driver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Objects;

public  final class Driver {
    private Driver(){}

    public static void initDriver(Method m,String browser, String version, String platform)  {
        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(m,browser,version,platform));

            } catch (MalformedURLException e) {
                throw new RuntimeException("Please check the capabilities of browser");
            }
            System.out.println("Loading Url");
            DriverManager.getDriver().get("https://www.lambdatest.com/selenium-playground/");
        }
    }
    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}