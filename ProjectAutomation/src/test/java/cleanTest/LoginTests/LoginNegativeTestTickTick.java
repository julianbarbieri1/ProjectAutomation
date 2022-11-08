package cleanTest.LoginTests;

import cleanTest.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LoginNegativeTestTickTick extends TestBaseTickTick {

    @Test
    @Order(1)
    @DisplayName("Verify login")
    @Description("this test case is to verify the login using valid credentials with any role")
    @Owner("Eynar")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyLoginEmptyPass(){

        String user = "123juli@123juli.com";

        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.emailTextBox.setText(user);
        loginPage.signInButton.click();

        Assertions.assertFalse(homePageNavbar.logOut.isControlDisplayed(),
                "ERROR login was successfully");
    }

    @Test
    @Order(2)
    @DisplayName("Verify login")
    @Description("this test case is to verify the login using valid credentials with any role")
    @Owner("Eynar")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyLoginEmptyEmail(){

        String pass = "Julian";

        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.passTextBox.setText(pass);
        loginPage.signInButton.click();

        Assertions.assertFalse(homePageNavbar.logOut.isControlDisplayed(),
                "ERROR login was successfully");
    }

    @Test
    @Order(3)
    @DisplayName("Verify login")
    @Description("this test case is to verify the login using valid credentials with any role")
    @Owner("Eynar")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyLoginEmptyFields(){
        mainPage.signInButton.waitClickable();
        mainPage.signInButton.click();

        loginPage.logoImg.waitPresence();
        loginPage.signInButton.click();

        Assertions.assertFalse(homePageNavbar.logoUser.isControlDisplayed(), "ERROR login was successfully");

    }

}
