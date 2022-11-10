package cleanTest.logout;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class LogoutTest extends TestBaseTickTick {

    String user = getAlphaNumericString(6)+"@gmail.com";
    String pass = getAlphaNumericString(6);

    @Test
    @DisplayName("Verify if a user can logout")
    @Description("This test will verify if a user can logout")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-382")
    @Epic("Logout")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Logout")
    @Feature("Authentication")
    public void verifyLogoutTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, the user could not be registered");

        //LOGOUT

        homePageNavbar.skipButton.click();
        homePageNavbar.logoUser.click();

        homePageNavbar.logOut.waitClickable();
        homePageNavbar.logOut.click();

        //verifico

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, can not close session");
    }

}
