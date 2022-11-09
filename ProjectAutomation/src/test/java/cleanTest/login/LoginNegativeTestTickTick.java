package cleanTest.login;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LoginNegativeTestTickTick extends TestBaseTickTick {

    @Test
    @Order(1)
    @DisplayName("Verify if the user can NOT register with an empty [Password] field.")
    @Description("This test will verify if the user can NOT register with an empty [Password] field.")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-377")
    @Epic("Login")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLoginEmptyPass(){

        String user = "123juli@123juli.com";

        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.emailTextBox.setText(user);
        loginPage.signInButton.click();

        Assertions.assertFalse(homePageNavbar.logOut.isControlDisplayed(),
                "ERROR login was successfully");
    }

    @Test
    @Order(2)
    @DisplayName("Verify if a user can NOT login with an empty email field")
    @Description("This test will Verify if a user can NOT login with an empty password field")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-377")
    @Epic("Login")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLoginEmptyEmail(){

        String pass = "Julian";

        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.passTextBox.setText(pass);
        loginPage.signInButton.click();

        Assertions.assertFalse(homePageNavbar.logOut.isControlDisplayed(),
                "ERROR login was successfully");
    }

    @Test
    @Order(3)
    @DisplayName("Verify if a user can NOT login with both fields empty")
    @Description("This test will verify if a user can NOT login with an empty email field and empty password field")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-377")
    @Epic("Login")
    @Severity(SeverityLevel.NORMAL)
    public void verifyLoginEmptyFields(){
        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.signInButton.click();

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR login was successfully");

    }

}
