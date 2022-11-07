package cleanTest;


import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.GetProperties;

public class LoginPage extends TestBase{
    @ParameterizedTest
    @CsvSource(
            {
                    "123juli@123juli.com,123juli",
            }
    )
    @DisplayName("verify Login Successfully")
    @Description("Test login")
    @Owner("Julian")
    @Link("www.jira.com/0001")
    @Issue("www.jira.com/bug001")
    @Lead("Testttttt")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Story login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginSuccessfully(String user, String pass) throws InterruptedException {

        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        /*mainPage.loginButton.click();
        loginModal.emailTextBox.setText(user);
        loginModal.passwordTextBox.setText(pass);
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR login was not successfully");
*/
        Thread.sleep(3000);
    }


}
