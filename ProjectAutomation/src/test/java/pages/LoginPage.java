package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPage {

    public TextBox emailTextBox = new TextBox(By.id("emailOrPhone"),
            "[Email] textbox in login page");

    public TextBox passTextBox = new TextBox(By.id("password"),
            "[Password] textbox in login page");

    public Button signInButton = new Button(By.xpath("//button[@class='button__3eXSs ']"),
            "[Sign in] button in login page");


    public Label logoImg = new Label(By.xpath("//div[@class='logo__1DB5Q']"),
            "[Logo] image in login page");
}
