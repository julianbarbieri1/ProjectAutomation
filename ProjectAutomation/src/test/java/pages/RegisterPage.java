package pages;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class RegisterPage {
    public TextBox nicknameTextBox = new TextBox(By.id("name"));

    public TextBox emailTextBox = new TextBox(By.xpath("//input[@placeholder='Email']"));

    public TextBox passTextBox = new TextBox(By.id("password"));

    public Button signUpButton = new Button(By.xpath("//button[@class='button__3eXSs ']"));
}
