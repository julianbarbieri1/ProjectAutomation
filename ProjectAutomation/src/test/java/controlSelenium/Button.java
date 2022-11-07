package controlSelenium;

import org.openqa.selenium.By;

public class Button extends Control{
    public Button(By locator) {
        super(locator);
    }
    public String getAttribute(String value) {
        this.findControl();
        return this.control.getAttribute(value);
    }
    public Button(By locator, String controlName) {
        super(locator, controlName);
    }
}
