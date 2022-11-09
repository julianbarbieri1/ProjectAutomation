package pages;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class RegisterPage {
    public TextBox nicknameTextBox = new TextBox(By.id("name"),
            "[Nickname (optional)] textbox in the register page");

    public TextBox emailTextBox = new TextBox(By.xpath("//input[@placeholder='Email']"),
            "[Email] textbox in the register page");

    public TextBox passTextBox = new TextBox(By.id("password"),
            "[Password] textbox in the register page");

    public Button signUpButton = new Button(By.xpath("//button[@class='button__3eXSs ']"),
            "[Sign Up] button in the register page");
}
