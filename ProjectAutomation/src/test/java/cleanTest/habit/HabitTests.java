package cleanTest.habit;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class HabitTests extends TestBaseTickTick {

    String name = "Julian";
    String user = getAlphaNumericString(6)+"@gmail.com";
    String password = getAlphaNumericString(6);
    String habit = getAlphaNumericString(6);

    @Test
    @Order(1)
    @DisplayName("Verifiy if a user can create an habit ")
    @Description("This test will verifiy if a user can create an habit with valid data")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-381")
    @Epic("Habit")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Habit")
    @Feature("Authentication")
    public void verifyCreateHabit(){

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pude registrar el usuario");

        //go to habits
        homePageNavbar.skipButton.click();
        homePageNavbar.habitButton.click();

        //create habit
        habitSection.addHabit.waitClickable();
        habitSection.addHabit.click();
        habitSection.addHabitTextBox.addText(habit);
        habitSection.saveButton.click();

        Assertions.assertTrue(habitSection.habitSearch(habit).isControlDisplayed(), "ERROR, no se pudo crear el habito");
    }

    @Test
    @Order(2)
    @DisplayName("Verifiy if a user can NOT create a habit without entering any character ")
    @Description("This test will verifiy if a user can NOT create a habit without entering any character in the [Daily Check-In] textbox")
    @Owner("Julian Barbieri")
    @Issue("https://nybblegroup.atlassian.net/browse/NAQA-399")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-381")
    @Epic("Habit")
    @Severity(SeverityLevel.NORMAL)
    @Tag("Habit")
    @Feature("Authentication")
    public void verifyCreateHabitEmptyName(){

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion

        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, no se pude registrar el usuario");

        //go to habits
        homePageNavbar.skipButton.click();
        homePageNavbar.habitButton.click();
        int amountHabitsBefore = habitSection.habits.findControls()-1;

        //create habit
        habitSection.addHabit.waitClickable();
        habitSection.addHabit.click();
        habitSection.saveButton.click();
        int amountHabitsAfter = habitSection.habits.findControls()-1;

        Assertions.assertEquals(amountHabitsBefore,amountHabitsAfter,"ERROR, the habit was created");


    }

    @Test
    @Order(3)
    @DisplayName("Verifiy if a user can delete a habit ")
    @Description("This test will verifiy if a user can delete habit")
    @Owner("Julian Barbieri")
    @Link("https://nybblegroup.atlassian.net/browse/NAQA-381")
    @Epic("Habit")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Authentication")
    @Tag("Habit")
    public void verifyDeleteHabit() throws InterruptedException {

        //CREATE NEW ACCOUNT
        mainPage.signUpForFreeButton.click();

        registerPage.nicknameTextBox.addText(name);
        registerPage.emailTextBox.addText(user);
        registerPage.passTextBox.addText(password);
        registerPage.signUpButton.click();

        //verificacion
        homePageNavbar.logoUser.waitVisibility();
        Assertions.assertTrue(homePageNavbar.logoUser.isControlDisplayed(), "ERROR, could not register the user");

        //go to habits
        homePageNavbar.skipButton.click();
        homePageNavbar.habitButton.click();

        //create habit
        habitSection.addHabit.waitClickable();
        habitSection.addHabit.click();
        habitSection.addHabitTextBox.addText(habit);
        habitSection.saveButton.click();

        Assertions.assertTrue(habitSection.habitSearch(habit).isControlDisplayed(), "ERROR, habit could not be created");


        //delete habit

        habitSection.habitSearch(habit).rightClick();
        habitSection.deleteHabitButton.waitClickable();
        habitSection.deleteHabitButton.click();

        habitSection.deleteHabitConfirmationButton.waitClickable();
        habitSection.deleteHabitConfirmationButton.click();

        Assertions.assertFalse(habitSection.habitSearch(habit).isControlDisplayed(),"ERROR, habit was not deleted");

    }

}
