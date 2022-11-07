package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//button[@title='Allow essential and optional cookies']")
    public WebElement facebookCookies;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement facebookEmailBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement facebookPasswordBox;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement facebookPasswordConfirm;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement facebookLogin;

}
