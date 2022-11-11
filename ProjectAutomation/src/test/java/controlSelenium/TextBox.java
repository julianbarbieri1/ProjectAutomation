package controlSelenium;

import org.openqa.selenium.By;

public class TextBox extends Control{

    public void addText(String value){
        this.findControl();
        this.step("Set on control: "+controlName+" the value: ["+value+"]");
        this.control.sendKeys(value);
    }

    public String getAttribute(String value) {
        this.findControl();
        return this.control.getAttribute(value);
    }

    public TextBox(By locator, String controlName) {
        super(locator, controlName);
    }

    public void setText(String value){

        this.findControl();
        this.step("Set on control: "+controlName+" the value: ["+value+"]");
        this.control.clear();
        this.control.sendKeys(value);

    }
}
