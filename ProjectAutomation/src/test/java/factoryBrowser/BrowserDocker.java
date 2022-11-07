package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserDocker implements IBrowser{
    @Override
    public WebDriver create() {
        WebDriver driver;
        ChromeOptions capabilities = new ChromeOptions();
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.112:4444/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }return driver;
    }
}
