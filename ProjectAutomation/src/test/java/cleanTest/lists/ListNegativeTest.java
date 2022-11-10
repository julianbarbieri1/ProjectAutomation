package cleanTest.lists;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class ListNegativeTest extends TestBaseTickTick {

    String user = getAlphaNumericString(6)+"@gmail.com";
    String pass = getAlphaNumericString(6);

    @Test
    @DisplayName("Verify if the user can NOT create a new list with an empty name")
    @Description("This test will verify if the user can NOT create a new list with an empty name")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-383")
    @Epic("Lists")
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Feature("Authentication")
    public void verifyCreateListEmptyTest(){

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, could not register the user");

        //CREATE LIST
        homePageNavbar.skipButton.click();
        homePageNavbar.tasksButton.click();
        homePageLeftSide.addListButton.click();
        taskSection.listNameTextBox.waitPresence();
        taskSection.saveListButton.click();

        //verifico

        Assertions.assertTrue(taskSection.saveDisabledButton.isControlDisplayed(),
                "ERROR, the list could be created without entering a name");

    }

}
