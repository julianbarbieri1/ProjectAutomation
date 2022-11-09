package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class ChangePasswordSection {

    public Label incorrectPasswordChange = new Label(By.xpath("//p[@class='error-msg text-alert text-sml text-warn-red text-[13px]']"),
            "[Delete Account] button in the Account and Security section");
    public Button changePassButton = new Button(By.xpath("//a[text()='Change Password']"),
            "[Change Password] button in the change password section");

    public TextBox currentPassTextbox = new TextBox(By.xpath("//div[@style='display: block;']//input[@placeholder='Current Password']"),
            "[Current Password] textbox in the change password section");

    public TextBox newPassTextbox = new TextBox(By.xpath("//div[@style='display: block;']//input[@placeholder='New password']"),
            "[New Password] textbox in the change password section");

    public Button saveButton = new Button(By.xpath("//div[@class='btns leading-none']//button[text()='Save']"),
            "[Save] button in the change password section");

    public Button saveDisabledButton = new Button(By.xpath("//button[text()='Save' and @disabled]"),
            "[Save] disable button in the change password section");

}
