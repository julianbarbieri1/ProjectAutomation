package cleanTest.theme;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class ThemeTest extends TestBaseTickTick {


    String user = getAlphaNumericString(6)+"@gmail.com";
    String password = getAlphaNumericString(6);

    @Test
    @DisplayName("Verify if user can change the theme")
    @Description("Verify if user can change the theme in the settings section")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-384")
    @Epic("Theme")
    @Severity(SeverityLevel.MINOR)
    @Tag("Theme")
    @Feature("Authentication")
    public void verifyChangeThemeTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitPresence();
        homePageNavbar.logoUser.waitClickable();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, the user could not be registered");

        //GO TO SETTINGS
        homePageNavbar.skipButton.click();
        homePageNavbar.logoUser.click();
        homePageNavbar.settingsButton.click();

        //CHANGE THEME
        settingsPageLeftSide.themeButton.waitClickable();
        settingsPageLeftSide.themeButton.click();

        themeSection.darkTheme.waitClickable();
        themeSection.darkTheme.click();

        //verifico
        String backgroundColor = themeSection.darkTheme.getAttribute("style");
        Assertions.assertEquals("background-color: rgb(33, 33, 33);", backgroundColor, "ERROR: The theme was not edited to 'Gray Theme'" );
    }
}
