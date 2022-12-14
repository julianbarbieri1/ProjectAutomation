package cleanTest.changePassword;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ChangePasswordPositiveTest extends TestBaseTickTick {

    String name = "Julian";
    String pass1 = getAlphaNumericString(7);
    String pass2 = getAlphaNumericString(6);
    String user = getAlphaNumericString(6)+"@gmail.com";


    @Test
    @DisplayName("Verify if a user can change his password with valid data")
    @Description("This test will verify if a user can change his password using his password and a new one between 6 and 64 characters")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-380")
    @Epic("Change password")
    @Severity(SeverityLevel.NORMAL)
    @Tag("ChangePassword")
    @Feature("Authentication")
    public void verifyChangePasswordTest() throws InterruptedException {


        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass1);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, could not register the user");

        //GO TO SETTINGS
        homePageNavbar.skipButton.click();
        homePageNavbar.logoUser.click();
        homePageNavbar.settingsButton.click();

        //CHANGE PASSWORD

        settingsPageLeftSide.accountSecurity.click();
        changePasswordSection.changePassButton.click();
        changePasswordSection.currentPassTextbox.addText(pass1);
        changePasswordSection.newPassTextbox.addText(pass2);
        changePasswordSection.saveButton.click();
        settingsPageLeftSide.doneButton.click();

        //Verfico haciendo logout e iniciando con la nueva contrase??a
        homePageNavbar.logoUser.waitClickable();
        homePageNavbar.logoUser.click();
        homePageNavbar.logOut.click();

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, could not close session");

        mainPage.signInButton.click();

        loginPage.emailTextBox.addText(user);
        loginPage.passTextBox.addText(pass2);
        loginPage.signInButton.click();

        homePageNavbar.logoUser.waitClickable();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, user could not login");


    }

}
