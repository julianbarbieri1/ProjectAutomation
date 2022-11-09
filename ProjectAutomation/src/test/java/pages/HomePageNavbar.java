package pages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class HomePageNavbar {

    public Button habitButton = new Button(By.xpath("//div[@class='mb-[20px]']//a[@href='#q/all/habit']"),
            "[Habit] logo button in the home page nav bar");
    public Button logOut = new Button(By.xpath("//ul[@class='dropdown-menu-menu dropdown-menu-menu-root dropdown-menu-menu-vertical']//li[last()]"),
            "[Logout] button in the home page nav bar");
    public Button logoUser = new Button(By.xpath("//div[@class='relative h-full w-full cursor-pointer']"),
            "[User] logo button in the home page nav bar");
    public Button settingsButton = new Button(By.xpath("//span[text()='Settings']"),
            "[Settings] button in the home page nav bar");
    public Button skipButton = new Button(By.xpath("//span[text()='Skip']"),
            "[Skip] button in the home page");
    public Button tasksButton = new Button(By.xpath("//a[@href='#p/inbox/tasks']"),
            "[Tasks] logo button in the home page nav bar");

}
