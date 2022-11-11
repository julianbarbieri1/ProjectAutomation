package cleanTest;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;
import singletonSession.Session;
import utils.GetProperties;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
@ExtendWith(TestResultExtension.class)
public class TestBaseTickTick {

    public ThemeSection themeSection = new ThemeSection();
    public TaskSection taskSection = new TaskSection();
    public HabitSection habitSection = new HabitSection();
    public RegisterPage registerPage = new RegisterPage();
    public LoginPage loginPage = new LoginPage();
    public MainPage mainPage = new MainPage();
    public HomePageNavbar homePageNavbar = new HomePageNavbar();

    public ChangePasswordSection changePasswordSection = new ChangePasswordSection();
    public SettingsPageLeftSide settingsPageLeftSide = new SettingsPageLeftSide();

    public AccountSecuritySection accountSecuritySection = new AccountSecuritySection();
    public HomePageLeftSide homePageLeftSide = new HomePageLeftSide();
    public static String getAlphaNumericString(int n)
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
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", GetProperties.getInstance().getBrowser())
                        .put("URL", GetProperties.getInstance().getHost())
                        .put("User", GetProperties.getInstance().getUser())
                        .put("Pwd", GetProperties.getInstance().getPwd())
                        .build(), System.getProperty("user.dir")
                        + "/build/allure-results/");
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }


}
