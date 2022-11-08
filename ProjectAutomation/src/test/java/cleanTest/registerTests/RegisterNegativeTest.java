package cleanTest.registerTests;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class RegisterNegativeTest extends TestBaseTickTick {

    String name = "Julian";
    String user = getAlphaNumericString(6)+"@gmail.com";
    String password = getAlphaNumericString(6);
    String shortPass = getAlphaNumericString(3);
    String longPass = getAlphaNumericString(65);


    @Test
    @Order(1)
    @DisplayName("Verify register")
    @Description("this test case is to verify the register using valid credentials with any role")
    @Owner("Julian")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyRegisterEmptyEmailTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, se pudo registrar el usuario sin ingresar un mail");

    }


    @Test
    @Order(2)
    @DisplayName("Verify register")
    @Description("this test case is to verify the register using valid credentials with any role")
    @Owner("Julian")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyRegisterEmptyPasswordTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.signUpButton.click();

        //verificacion

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, se pudo registrar el usuario sin ingresar una contraseña");

    }

    @Test
    @Order(3)
    @DisplayName("Verify register")
    @Description("this test case is to verify the register using valid credentials with any role")
    @Owner("Julian")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyRegisterShortPasswordTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.passTextBox.addText(shortPass);
        registerPage.emailTextBox.addText(user);
        registerPage.signUpButton.click();

        //verificacion

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(),
                "ERROR, se pudo registrar el usuario con una contraseña muy corta");

    }

    @Test
    @Order(3)
    @DisplayName("Verify register")
    @Description("this test case is to verify the register using valid credentials with any role")
    @Owner("Julian")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyRegisterLongPasswordTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.passTextBox.addText(longPass);
        registerPage.emailTextBox.addText(user);
        registerPage.signUpButton.click();

        //verificacion

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(),
                "ERROR, se pudo registrar el usuario con una contraseña muy larga");

    }
}
