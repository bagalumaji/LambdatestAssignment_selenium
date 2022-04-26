package driver;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

public final class DriverManager {
    private DriverManager(){}

    private static final ThreadLocal<RemoteWebDriver> THREAD_LOCAL = new ThreadLocal<>();

    public static RemoteWebDriver getDriver() {
        return THREAD_LOCAL.get();
    }

    static void setDriver(RemoteWebDriver driverref) {
        if(Objects.nonNull(driverref)) {
            THREAD_LOCAL.set(driverref);
        }
    }

    static void unload() {
        THREAD_LOCAL.remove();
    }

}
