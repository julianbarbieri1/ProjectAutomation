package cleanTest.deleteAccount;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePageNavbar;

public class DeleteAccountValidTest extends TestBaseTickTick {


    String name = "Julian";
    String user = getAlphaNumericString(6) + "@gmail.com";
    String password = getAlphaNumericString(6);

    @Test
    @DisplayName("Verify if a user can delete his account with valid data")
    @Description("This test will verify if a user can delete his account with the logged account password and checking both checkboxes")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-379")
    @Epic("Delete account")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyDeleteAccountTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.signUpButton.waitVisibility();
        //set name
        registerPage.nicknameTextBox.addText(name);
        //set email
        registerPage.emailTextBox.addText(user);
        //set password
        registerPage.passTextBox.addText(password);
        //click sign up button
        registerPage.signUpButton.click();

        //verificacion si el logo user esta desplegado

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pude registrar el usuario");

        //GO TO SETTINGS Account security
        homePageNavbar.skipButton.click();

        //click on logo button
        homePageNavbar.logoUser.click();
        //click settings button
        homePageNavbar.settingsButton.click();
        //WAIT CON EL LABEL "Settings"
        settingsPageLeftSide.accountSecurity.waitVisibility();
        //click account security button
        settingsPageLeftSide.accountSecurity.click();

        //DELETE ACCOUNT
        //click delete button
        accountSecuritySection.deleteButton.click();
        //set password
        accountSecuritySection.deletePasswordTextBox.addText(password);
        //check checkboxes
        accountSecuritySection.deleteCheckBoxAccount.check();
        accountSecuritySection.deleteCheckBoxData.check();
        //click ok button
        accountSecuritySection.deleteConfirmButton.click();


        //INICIO SESION
        //click sign in button
        mainPage.signInButton.click();
        //set email
        loginPage.emailTextBox.addText(user);
        //set password
        loginPage.passTextBox.addText(password);
        //click sign in button
        loginPage.signInButton.click();

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pudo eliminar la cuenta");


    }
}