package controlSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Control {
    protected By locator;
    protected WebElement control;
    protected String controlName; // reflection
    public Control (By locator){
        this.locator=locator;
    }
    @Step("{0}")
    public void step(String action){}


    public Control (By locator, String controlName){
        this.locator=locator;
        this.controlName=controlName;
    }
    protected void findControl(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }
    public Integer findControls(){
        return Session.getInstance().getBrowser().findElements(this.locator).size()-1;
    }

    /**
     *
     */
    public void click(){
        this.findControl();
        control.click();
        this.step("Click on "+controlName);
    }
    public void rightClick(){
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.contextClick(this.control).perform();
        this.step("Right click on "+controlName);
    }
    public void checkSlectable(By element, WebDriver driver) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    public boolean isControlDisplayed(){
        try {
            this.findControl();
            this.step("Check the "+controlName+" is displayed: True");
            return control.isDisplayed();
        }catch (Exception e){
            this.step("Check the "+controlName+" is displayed: false");
            return false;
        }
    }

    public String getText() {

        this.findControl();
        this.step("Get Text from " + controlName + ", the value is: " + control.getText());
        return control.getText();
    }


    public void waitVisibility(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public void waitPresence(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(this.locator));
    }
    public void waitClickable()
    {
        // todo --> factory para instanciar el wait una sola vez
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }
    public void waitControl(By locator, int timeOut) throws InterruptedException {
        Label test = new Label(this.locator); //subject
        int i = 0;
        do {
            Thread.sleep(1000);
            i++;
            this.control.click(); //refresh
        } while (!test.isControlDisplayed() || i <= timeOut);
    }

    public void waitTextToBePresent(String value)
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(this.locator, value));
    }

    public void waitInvisvilityofElement()
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.locator));
    }

}
