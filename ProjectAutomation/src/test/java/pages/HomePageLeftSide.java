package pages;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class HomePageLeftSide {

    public Button addListButton = new Button(By.xpath("//p[text()='Lists']/following-sibling::button//*[contains(@class,'icon-list-add')]"),
            "[ + (Add list)] button in the home page left side");


}
