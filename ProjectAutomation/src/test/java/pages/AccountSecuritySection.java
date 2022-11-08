package pages;

import controlSelenium.Button;
import controlSelenium.CheckBox;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class AccountSecuritySection {

    public Button deleteButton = new Button(By.xpath("//a[text()='Delete Account']"));
    public TextBox deletePasswordTextBox = new TextBox(By.xpath("//input[@id='password-input']"));
    public CheckBox deleteCheckBoxAccount = new CheckBox(By.xpath("//input [@id='check-account']"));
    public CheckBox deleteCheckBoxData = new CheckBox(By.xpath("//input [@id='check-data']"));

    public Button deleteConfirmButton = new Button(By.xpath("//button[text()='Confirm']"));

    public Label incorrectPassword = new Label(By.xpath("//p[@class='text-alert text-sml warn text-[13px] text-warn-red']"), "");




}
