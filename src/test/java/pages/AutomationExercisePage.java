package pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {

    public AutomationExercisePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLink;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginAccountElement;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//li//a[text()=' Logged in as ']")
    public WebElement loggedInAs;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//*[text()='Account Deleted!']")
    public WebElement accountDeleted;
}
