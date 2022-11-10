package cleanTest.register;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class RegisterPositiveTestTickTick extends TestBaseTickTick {

    String name = "Julian";
    String user = getAlphaNumericString(6)+"@gmail.com";
    String password = getAlphaNumericString(6);
    String pass64 = getAlphaNumericString(64);

    @Test
    @Order(1)
    @DisplayName("Verify if the user can register succesfully with valid data.")
    @Description("This test will verify if the user can register succesfully with valid email, nickname and password.")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-378")
    @Epic("Register")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Register")
    @Feature("Authentication")
    public void verifyRegisterTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, the user could not be registered");

    }

    @Test
    @Order(2)
    @DisplayName("Verify if the user can register succesfully with the [Nickname] field empty.")
    @Description("This test will verify if the user can register succesfully with the [Nickname] field empty.")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-378")
    @Epic("Register")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Register")
    @Feature("Authentication")
    public void verifyRegisterEmptyNameTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, the user could not be registered");

    }

    @Test
    @Order(3)
    @DisplayName("Verify if the user can register succesfully with a long password")
    @Description("This test will verify if the user can register succesfully with a password with 64 characters.")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-378")
    @Epic("Register")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Register")
    @Feature("Authentication")
    public void verifyRegisterPass64Test() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass64);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, the user could not be registered");

    }

}
