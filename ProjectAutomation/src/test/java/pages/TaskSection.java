package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class TaskSection {

    public Button saveDisabledButton = new Button(By.xpath("//button[text()='Save' and @disabled]"),
            "[Save] disable button in the task section");
    public Button okPopUp = new Button(By.xpath("//button[text()='I Know']"),
            "[I Know] button in the task section");
    public Button itemNoteType = new Button(By.xpath("//span[text()='Note List']"),
            "[Note List] item button in the task section");
    public Button typeComboBoxButton = new Button(By.xpath("//div[text()='Task List']"),
            "[Type] combobox in the task section");
    public TextBox listNameTextBox = new TextBox(By.id("edit-project-name"),
            "[Name] textbox in the task section");
    public Button saveListButton = new Button(By.xpath("//button[text()='Save']"),
            "[Save] button in the task section");
    public Button confirmationDeleteButton = new Button(By.xpath("//button[text()='Delete']"),
            "[Delete] confirmation button in the task section");
    public Button deleteListButton = new Button(By.xpath("//a[text()='Delete']"),
            "[Delete] button in the task section");
    public Button listSearch(String listName){
        return new Button(By.xpath("//p[@class='text-s font-normal flex-auto truncate leading-[20px] text-grey' and text()='" + listName + "']"),
                "["+ listName +"] list button in the task section");
    }

}
