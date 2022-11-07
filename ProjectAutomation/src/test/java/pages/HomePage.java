package pages;

import cleanTest.TestBase;
import controlSelenium.Button;
import org.openqa.selenium.By;

public class HomePage {
    public Button logoUser = new Button(By.xpath("//div[@class='relative h-full w-full cursor-pointer']"));
    public Button logOut = new Button(By.xpath("//ul[@class='dropdown-menu-menu dropdown-menu-menu-root dropdown-menu-menu-vertical']//li[last()]"));
}
