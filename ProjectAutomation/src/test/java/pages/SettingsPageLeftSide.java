package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SettingsPageLeftSide {

    public Button doneButton = new Button(By.xpath("//button[text()='Done']"));
    public Button accountSecurity = new Button(By.xpath("//span[text()='Account and Security']"));
    public Label settingsLabel = new Label(By.xpath("//h5[@class='line-left text-[28px] font-medium leading-[40px]']"));

    public Button changePassButton = new Button(By.xpath("//a[text()='Change Password']"));

    public TextBox currentPassTextbox = new TextBox(By.xpath("//div[@style='display: block;']//input[@placeholder='Current Password']"));

    public TextBox newPassTextbox = new TextBox(By.xpath("//div[@style='display: block;']//input[@placeholder='New password']"));

    public Button saveButton = new Button(By.xpath("//div[@class='btns leading-none']//button[text()='Save']"));

}
