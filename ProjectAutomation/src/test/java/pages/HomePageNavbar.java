package pages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class HomePageNavbar {

    public Button habitButton = new Button(By.xpath("//div[@class='mb-[20px]']//a[@href='#q/all/habit']"));
    public Button logOut = new Button(By.xpath("//ul[@class='dropdown-menu-menu dropdown-menu-menu-root dropdown-menu-menu-vertical']//li[last()]"));
    public Button logoUser = new Button(By.xpath("//div[@class='relative h-full w-full cursor-pointer']"));
    public Button settingsButton = new Button(By.xpath("//span[text()='Settings']"));
    public Button skipButton = new Button(By.xpath("//span[text()='Skip']"));


}
