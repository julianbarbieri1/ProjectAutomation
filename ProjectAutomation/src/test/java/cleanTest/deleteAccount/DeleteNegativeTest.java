package cleanTest.deleteAccount;

import cleanTest.TestBaseTickTick;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteNegativeTest extends TestBaseTickTick {

    String name = "Julian";
    String user = getAlphaNumericString(6) + "@gmail.com";
    String password = getAlphaNumericString(6);

    String invalidPassword = getAlphaNumericString(7);

    @Test
    public void verifyDeleteAccountInvalidPasswordTest() throws InterruptedException {

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
        homePageLeftSide.skipButton.click();

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
        accountSecuritySection.deletePasswordTextBox.addText(invalidPassword);
        //check checkboxes
        accountSecuritySection.deleteCheckBoxAccount.check();
        accountSecuritySection.deleteCheckBoxData.check();
        //click ok button
        accountSecuritySection.deleteConfirmButton.click();
        accountSecuritySection.incorrectPassword.waitVisibility();

        Assertions.assertTrue(accountSecuritySection.incorrectPassword.isControlDisplayed(),
                "ERROR, se pudo eliminar la cuenta con una contraseña distinta");


    }
}