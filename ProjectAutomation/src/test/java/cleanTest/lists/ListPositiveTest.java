package cleanTest.lists;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class ListPositiveTest extends TestBaseTickTick {


    String user = getAlphaNumericString(6)+"@gmail.com";
    String pass = getAlphaNumericString(6);
    String listName = getAlphaNumericString(5);

    @Test
    @Order(1)
    @DisplayName("Verify if the user can create a new list succesfully with a valid name")
    @Description("This test will verify if the user can create a new list succesfully with valid data")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-383")
    @Epic("Lists")
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Feature("Authentication")
    public void verifyCreatListTest(){


        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pudo registrar el usuario");

        //CREATE LIST
        homePageNavbar.skipButton.click();
        homePageNavbar.tasksButton.click();
        homePageLeftSide.addListButton.click();

        taskSection.listNameTextBox.waitPresence();
        taskSection.listNameTextBox.addText(listName);
        taskSection.saveListButton.click();

        taskSection.saveListButton.waitInvisvilityofElement();

        taskSection.listSearch(listName).waitPresence();

        //verifico

        Assertions.assertTrue(taskSection.listSearch(listName).isControlDisplayed(), "ERROR, no se pudo crear la lista");

    }

    @Test
    @Order(2)
    @DisplayName("Verify if the user can create a new list with a different type")
    @Description("This test will verify if the user can create a new list succesfully with a different type than the default")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-383")
    @Epic("Lists")
    @Severity(SeverityLevel.MINOR)
    @Tag("List")
    @Feature("Authentication")
    public void verifyCreatListNoteTest() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pudo registrar el usuario");

        //CREATE LIST
        homePageNavbar.skipButton.click();
        homePageNavbar.tasksButton.click();
        homePageLeftSide.addListButton.click();

        taskSection.listNameTextBox.waitPresence();
        taskSection.listNameTextBox.addText(listName);
        taskSection.typeComboBoxButton.click();
        taskSection.itemNoteType.waitClickable();
        taskSection.itemNoteType.click();
        taskSection.saveListButton.click();
        taskSection.okPopUp.waitClickable();
        //Thread.sleep(3000);
        taskSection.okPopUp.click();
        taskSection.saveListButton.waitInvisvilityofElement();

        taskSection.listSearch(listName).waitPresence();

        //verifico

        Assertions.assertTrue(taskSection.listSearch(listName).isControlDisplayed(), "ERROR, no se pudo crear la lista");

    }
    @Test
    @Order(3)
    @DisplayName("Verify if the user can delete a list")
    @Description("This test will verify if the user can delete a list")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-383")
    @Epic("Lists")
    @Severity(SeverityLevel.NORMAL)
    @Tag("List")
    @Feature("Authentication")
    public void verifyDeleteListTest(){


        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(pass);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, the user could not be registered");

        //CREATE LIST
        homePageNavbar.skipButton.click();
        homePageNavbar.tasksButton.click();
        homePageLeftSide.addListButton.click();

        taskSection.listNameTextBox.waitPresence();
        taskSection.listNameTextBox.addText(listName);
        taskSection.saveListButton.click();

        taskSection.saveListButton.waitInvisvilityofElement();

        taskSection.listSearch(listName).waitPresence();

        //verifico

        Assertions.assertTrue(taskSection.listSearch(listName).isControlDisplayed(), "ERROR, list could not be created");

        //DELETE

        taskSection.listSearch(listName).rightClick();
        taskSection.deleteListButton.waitClickable();
        taskSection.deleteListButton.click();

        taskSection.confirmationDeleteButton.waitClickable();
        taskSection.confirmationDeleteButton.click();
        taskSection.confirmationDeleteButton.waitInvisvilityofElement();
        taskSection.listSearch(listName).waitInvisvilityofElement();

        //verifico

        Assertions.assertFalse(taskSection.listSearch(listName).isControlDisplayed(),"ERROR, could not delete the list");
    }

}
