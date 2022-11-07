package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyCoursedemyPage {

    MyCoursedemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//a[text()='Log in']")
    public WebElement loginLink;

    @FindBy (xpath = "//input[@id='login-email']")
    public WebElement emailBox;

    @FindBy (xpath = "//input[@id='login-password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//button[text()='Login']")
    public WebElement loginButton;
}
