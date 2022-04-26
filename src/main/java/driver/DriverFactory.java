package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private DriverFactory() {
    }

    public static RemoteWebDriver getDriver(Method m, String browser, String version, String platform) throws MalformedURLException {

        String username = System.getenv("LT_USERNAME") == null ? "bagalumaji" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "Mj5hjUTSNA5XIoE53VWjq8F2uUnM7EfbI1OZWA8gchh4M9wtXk" : System.getenv("LT_ACCESS_KEY");

        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", platform);
        caps.setCapability("browserName", browser);
        caps.setCapability("version", version);
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "Umaji Bagal-1");
        caps.setCapability("name", m.getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("network", true);
        caps.setCapability("visual", true);
        caps.setCapability("video", true);
        caps.setCapability("console", true);

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

}
