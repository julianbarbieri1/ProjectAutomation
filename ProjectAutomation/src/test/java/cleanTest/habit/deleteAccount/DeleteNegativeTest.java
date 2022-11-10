package cleanTest.habit.deleteAccount;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DeleteNegativeTest extends TestBaseTickTick {

    String name = "Julian";
    String user = getAlphaNumericString(6) + "@gmail.com";
    String password = getAlphaNumericString(6);

    String invalidPassword = getAlphaNumericString(7);

    @Test
    @DisplayName("Verify if a user can NOT delete his account with an invalid password")
    @Description("This test will verify if a user can NOT delete his account with an invalid password")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-379")
    @Epic("Delete account")
    @Severity(SeverityLevel.NORMAL)
    @Tag("DeleteAccount")
    @Feature("Authentication")
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
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, could not register the user");

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
        accountSecuritySection.deletePasswordTextBox.addText(invalidPassword);
        //check checkboxes
        accountSecuritySection.deleteCheckBoxAccount.check();
        accountSecuritySection.deleteCheckBoxData.check();
        //click ok button
        accountSecuritySection.deleteConfirmButton.click();
        accountSecuritySection.incorrectPasswordDelete.waitVisibility();

        Assertions.assertTrue(accountSecuritySection.incorrectPasswordDelete.isControlDisplayed(),
                "ERROR, account could be deleted with a different password");


    }
}