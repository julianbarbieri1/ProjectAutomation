package factoryBrowser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class Cloud implements IBrowser{
    @Override
    public WebDriver create() {
        WebDriver driver;
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptionsMap = new HashMap<String, String>();
        bstackOptionsMap.put("userName", "julianbarbieri_iTOY3c");
        bstackOptionsMap.put("accessKey", "KNN9LxypbpRWezJadQ3Z");
        bstackOptionsMap.put("os", "Windows");
        bstackOptionsMap.put("osVersion", "11");
        bstackOptionsMap.put("browserName", "Chrome");
        bstackOptionsMap.put("browserVersion", "latest");
        capabilities.setCapability("bstack:options", bstackOptionsMap);
        try {
            driver = new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), capabilities);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
