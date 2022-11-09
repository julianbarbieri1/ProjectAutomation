package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class HabitSection {

    public Button addHabit = new Button(By.xpath("//span[@class='inline-block w-[18px] h-[18px] mr-[8px] cursor-pointer']//div[@class='relative bgIconWrapper_aJONI']"),
            "[Add habit] button in the habit section");

    public TextBox addHabitTextBox = new TextBox(By.xpath("//input[@placeholder='Daily Check-in']"),
            "[Habit Name (Daily Check-in)] textbox in the habit section");

    public Button habits = new Button(By.xpath("//div[@class='habitList_CDoEN antiscroll-wrap flex-auto flex flex-col']/div"),
            "[Habits] list in the habit section");
    public Button saveButton = new Button(By.xpath("//button[text()='Save']"),
            "[Save] button in the habit section");

    public Button deleteHabitButton = new Button(By.xpath("//span[text()='Delete']"),
            "[Delete] button in the habit section");

    public Button deleteHabitConfirmationButton = new Button(By.xpath("//Button[text()='Delete']"),
            "[Delete (confirmation)] button in the habit section");

    public Label habitSearch(String name){
        Label habitName= new Label(By.xpath("//div[@class='habit_3UL4d flex items-center relative py-[8px] px-[20px] cursor-pointer h-full']//p[text()='"+name+"']"),
                "["+name+"] habit name label in the habit section");
        return habitName;
    }


}
