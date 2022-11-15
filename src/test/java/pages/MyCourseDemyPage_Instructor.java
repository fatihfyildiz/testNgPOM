package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyCourseDemyPage_Instructor {

    public MyCourseDemyPage_Instructor(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginLink;

    @FindBy (xpath = "//input[@id='login-email']")
    public WebElement emailBox;

    @FindBy (xpath = "//input[@id='login-password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement cookies;

    @FindBy (linkText = "Instructor")
    public WebElement instructorLink;

    @FindBy (linkText = "Course manager")
    public WebElement courseManagerLink;

    @FindBy (id = "select2-category_id-container")
    public WebElement categoriesLink;

    @FindBy (xpath = "(//*[text()='Web Design for Web Developers'])[2]")
    public WebElement categoryChoosing;

    @FindBy (id = "select2-status-container")
    public WebElement statusLink;

    @FindBy (xpath = "(//*[text()='Active'])[2]")
    public WebElement statusChoosing;



}
