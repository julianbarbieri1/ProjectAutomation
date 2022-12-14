package cleanTest.changePassword;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import utils.GetProperties;

public class ChangePasswordNegativeTest extends TestBaseTickTick {

    String name = "Julian";
    String pass1 = getAlphaNumericString(8);
    String shortPass =getAlphaNumericString(3);
    String longPass =getAlphaNumericString(70);
    String user = getAlphaNumericString(6)+"@gmail.com";


    @Test
    @Order(1)
    @DisplayName("Verify if a user can NOT change his password with a short one")
    @Description("This test will verify if a user can change his password using his password and a new one with 5 or less characters")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-380")
    @Epic("Change password")
    @Severity(SeverityLevel.NORMAL)
    @Tag("ChangePassword")
    @Feature("Authentication")
    public void verifyChangeShortPasswordTest() throws InterruptedException {

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
        homePageNavbar.skipButton.waitClickable();
        homePageNavbar.skipButton.click();
        homePageNavbar.logoUser.click();
        homePageNavbar.settingsButton.click();

        //CHANGE PASSWORD

        settingsPageLeftSide.accountSecurity.waitClickable();
        settingsPageLeftSide.accountSecurity.click();
        changePasswordSection.changePassButton.click();
        changePasswordSection.currentPassTextbox.addText(pass1);
        changePasswordSection.newPassTextbox.addText(shortPass);
        changePasswordSection.saveButton.click();

        Assertions.assertTrue(changePasswordSection.incorrectPasswordChange.isControlDisplayed(),
                "ERROR, user could change to a short password");

    }


    @Order(2)
    @Test
    @DisplayName("Verify if a user can NOT change his password with a long one")
    @Description("This test will verify if a user can change his password using his password and a new one with 65 or more characters")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-380")
    @Epic("Change password")
    @Severity(SeverityLevel.NORMAL)
    @Tag("ChangePassword")
    @Feature("Authentication")
    public void verifyChangeLongPasswordTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass1);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, ERROR, could not register the user");

        //GO TO SETTINGS
        //settingsPageLeftSide.accountSecurity.waitClickable();
        homePageNavbar.skipButton.click();
        homePageNavbar.logoUser.click();
        homePageNavbar.settingsButton.click();

        //CHANGE PASSWORD

        settingsPageLeftSide.accountSecurity.waitClickable();
        settingsPageLeftSide.accountSecurity.click();
        changePasswordSection.changePassButton.click();
        changePasswordSection.currentPassTextbox.addText(pass1);
        changePasswordSection.newPassTextbox.addText(longPass);
        changePasswordSection.saveButton.click();

        Assertions.assertTrue(changePasswordSection.incorrectPasswordChange.isControlDisplayed(),
                "ERROR, user could change to a long password");

    }

    @Test
    @Order(3)
    @DisplayName("Verify if a user can NOT change his password with an empty field")
    @Description("This test will verify if a user can NOT change his password without entering any character in the [New Password] textbox")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-380")
    @Epic("Change password")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Authentication")
    @Tag("ChangePassword")
    public void verifyChangeEmptyPasswordTest() throws InterruptedException {

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

        settingsPageLeftSide.accountSecurity.waitClickable();
        settingsPageLeftSide.accountSecurity.click();
        changePasswordSection.changePassButton.click();
        changePasswordSection.currentPassTextbox.addText(pass1);

        Assertions.assertTrue(changePasswordSection.saveDisabledButton.isControlDisplayed(),
                "ERROR, user could change to a password without having entered a new one");

    }

}
