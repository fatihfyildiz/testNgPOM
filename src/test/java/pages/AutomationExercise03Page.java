package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercise03Page {

    public AutomationExercise03Page () {
        PageFactory.initElements(Driver.getDriver(), this);
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

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedinAs;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy (xpath = "//*[text()='Account Deleted!']")
    public WebElement accountDeletedlocation;

}
