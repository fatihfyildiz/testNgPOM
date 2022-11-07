package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercise04Page {

    public AutomationExercise04Page (){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLinki;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginAccountElementi;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement emailKutusu;

    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//li//a[text()=' Logged in as ']")
    public WebElement loggedInAs;

    @FindBy (xpath = "//a[@href='/logout']")
    public WebElement logoutButton;

    // Followings are for AutomationExercise05
    @FindBy (xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignUp;

    @FindBy (xpath = "//input[@data-qa='signup-name']")
    public WebElement name;

    @FindBy (xpath = "//input[@data-qa='signup-email']")
    public WebElement emailSignUp;

    @FindBy (xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy (xpath = "//p[text()='Email Address already exist!']")
    public WebElement emailAdreadyExist;

    // Followings are for AutomationExercise06
    @FindBy (xpath = "//a[@href='/contact_us']")
    public WebElement contactUs;

    @FindBy (xpath = "(//h2[@class='title text-center'])[2]")
    public WebElement getInTouch;

    @FindBy (xpath = "//input[@name='name']")
    public WebElement getInTouchName;

    @FindBy (xpath = "//input[@data-qa='email']")
    public WebElement getInTouchEmail;

    @FindBy (xpath = "//input[@data-qa='subject']")
    public WebElement subject;

    @FindBy (id= "message")
    public WebElement message;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement chooseFileButton;


}
