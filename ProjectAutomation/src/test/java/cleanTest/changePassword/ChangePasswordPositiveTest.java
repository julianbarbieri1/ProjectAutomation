package cleanTest.changePassword;

import cleanTest.TestBaseTickTick;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangePasswordPositiveTest extends TestBaseTickTick {

    String name = "Julian";
    String pass1 = getAlphaNumericString(7);
    String pass2 = getAlphaNumericString(6);
    String user = getAlphaNumericString(6)+"@gmail.com";


    @Test
    public void verifyChangePasswordTest() throws InterruptedException {


        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass1);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pude registrar el usuario");

        //GO TO SETTINGS
        //Thread.sleep(2000);
        homePageNavbar.skipButton.click();
        //Thread.sleep(2000);
        homePageNavbar.logoUser.click();
        //Thread.sleep(2000);
        homePageNavbar.settingsButton.click();

        //CHANGE PASSWORD

        settingsPageLeftSide.accountSecurity.click();
        settingsPageLeftSide.changePassButton.click();
        settingsPageLeftSide.currentPassTextbox.addText(pass1);
        settingsPageLeftSide.newPassTextbox.addText(pass2);
        settingsPageLeftSide.saveButton.click();
        settingsPageLeftSide.doneButton.click();

        //Verfico haciendo logout e iniciando con la nueva contraseña
        homePageNavbar.logoUser.waitClickable();
        homePageNavbar.logoUser.click();
        homePageNavbar.logOut.click();

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pude cerrar sesion");

        mainPage.signInButton.click();

        loginPage.emailTextBox.addText(user);
        loginPage.passTextBox.addText(pass2);
        loginPage.signInButton.click();

        homePageNavbar.logoUser.waitClickable();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pude iniciar sesion");


    }

}
