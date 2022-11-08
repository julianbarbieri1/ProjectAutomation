package cleanTest.registerTests;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class RegisterPositiveTestTickTick extends TestBaseTickTick {

    String name = "Julian";
    String user = getAlphaNumericString(6)+"@gmail.com";
    String password = getAlphaNumericString(6);
    String pass64 = getAlphaNumericString(64);


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
    public void verifyRegisterTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pudo registrar el usuario");

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
    public void verifyRegisterEmptyNameTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pudo registrar el usuario");

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
    public void verifyRegisterPass64Test() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass64);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pudo registrar el usuario");

    }

}
