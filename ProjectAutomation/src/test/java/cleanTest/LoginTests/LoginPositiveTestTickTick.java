package cleanTest.LoginTests;


import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginPositiveTestTickTick extends TestBaseTickTick {
    @ParameterizedTest
    @CsvSource(
            {
                    "123juli@123juli.com,123juli",
                    "julian@gmail.com,julian",
            }
    )
    @DisplayName("verify Login Successfully")
    @Description("Test login")
    @Owner("Julian")
    @Link("www.jira.com/0001")
    @Issue("www.jira.com/bug001")
    @Lead("Test")
    @Epic("Login")
    @Feature("Authentication")
    @Story("Story login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginSuccessfully(String user, String pass) throws InterruptedException {

        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.emailTextBox.setText(user);
        loginPage.passTextBox.setText(pass);
        loginPage.signInButton.click();


        homePageNavbar.logoUser.waitClickable();
        homePageNavbar.logoUser.click();

        //verifico si el boton del logout existe
        Assertions.assertTrue(homePageNavbar.logOut.isControlDisplayed(),
                "ERROR login was not successfully");

        /*
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR login was not successfully");
*/

    }


}
