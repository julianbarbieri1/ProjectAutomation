package cleanTest.login;


import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.GetProperties;

public class LoginPositiveTestTickTick extends TestBaseTickTick {

    @Test
    @DisplayName("verify Login Successfully")
    @Description("This test will verify if a user can login with a valid email and a valid password.")
    @Owner("Julian")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-377")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginSuccessfully() throws InterruptedException {

        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.emailTextBox.setText(GetProperties.getInstance().getUser());
        loginPage.passTextBox.setText(GetProperties.getInstance().getPwd());
        loginPage.signInButton.click();

        homePageNavbar.logoUser.waitClickable();
        homePageNavbar.logoUser.click();

        //verifico si el boton del logout existe
        Assertions.assertTrue(homePageNavbar.logOut.isControlDisplayed(),
                "ERROR login was not successfully");


    }


}
