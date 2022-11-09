package pages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class ThemeSection {

    public Button darkTheme = new Button(By.xpath("//div[@style='background-color: rgb(33, 33, 33);']"),
            "[Dark] option button in theme section");
}
