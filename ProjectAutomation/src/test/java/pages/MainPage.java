package pages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button signInButton = new Button(By.xpath("//div[@class='navRow_236y3 container']//a[text()='Sign In']"),"[Sign in] button in the main page");
    public Button signUpForFreeButton= new Button(By.xpath("//div[@class='navRow_236y3 container']//a[@class='signupBtn_2APvt']"), "[Sign Up For Free] button in the main page");
}
