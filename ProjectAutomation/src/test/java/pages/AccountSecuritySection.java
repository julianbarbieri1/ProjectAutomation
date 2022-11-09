package pages;

import controlSelenium.Button;
import controlSelenium.CheckBox;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class AccountSecuritySection {

    public Button deleteButton = new Button(By.xpath("//a[text()='Delete Account']"),
            "[Delete Account] button in the Account and Security section");
    public TextBox deletePasswordTextBox = new TextBox(By.xpath("//input[@id='password-input']"),
            "[Confirm password] textbox in the Account and Security section");
    public CheckBox deleteCheckBoxAccount = new CheckBox(By.xpath("//input [@id='check-account']"),
            "[Check account] checkbox in the Account and Security section");
    public CheckBox deleteCheckBoxData = new CheckBox(By.xpath("//input [@id='check-data']"),
            "[Check data] checkbox in the Account and Security section");
    public Button deleteConfirmButton = new Button(By.xpath("//button[text()='Confirm']"),
            "[Confirm] button in the Account and Security section");
    public Label incorrectPasswordDelete = new Label(By.xpath("//p[@class='text-alert text-sml warn text-[13px] text-warn-red']"),
            "[Password is incorrect] label in the Account and Security section");

}
