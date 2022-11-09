package cleanTest.register;

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
    @DisplayName("Verify if the user can NOT register with an empty [Email] field")
    @Description("This test will verify if the user can NOT register with an empty [Email] field.")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-378")
    @Epic("Register")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Verify if the user can NOT register with an empty [Password] field.")
    @Description("This test will verify if the user can NOT register with an empty [Password] field.")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-378")
    @Epic("Register")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Verify if the user can NOT register with a short password.")
    @Description("This test will verify if the user can NOT register with a password length between 1 and 5 characters.")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-378")
    @Epic("Register")
    @Severity(SeverityLevel.NORMAL)
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
    @Order(4)
    @DisplayName("Verify if the user can NOT register with a long password.")
    @Description("This test will verify if the user can NOT register with a password with 65 or more characters")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-378")
    @Epic("Register")
    @Severity(SeverityLevel.NORMAL)
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
