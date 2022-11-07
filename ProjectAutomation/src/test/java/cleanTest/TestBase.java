package cleanTest;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import pages.MainPage;
import singletonSession.Session;
import utils.GetProperties;

public class TestBase {

    public LoginPage loginPage = new LoginPage();
    public MainPage mainPage = new MainPage();
    public HomePage homePage = new HomePage();
    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        attach();
        Session.getInstance().closeBrowser();
    }

    @Attachment(value = "screenshot",type = "image/png")
    public static byte[] attach(){
        // tomar captura de pantalla - adjuntarlo en el reporte
        return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }

}
