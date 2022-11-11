package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SettingsPageLeftSide {

    public Button doneButton = new Button(By.xpath("//button[text()='Done']"),
            "[Done] button in the settings page");
    public Button accountSecurity = new Button(By.xpath("//span[text()='Account and Security']"),
            "[Account and Security] button in the settings page");

    public Button themeButton = new Button(By.xpath("//a[@href='#settings/theme']"),
            "[Theme] button in the settings page");

}
