package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class MyCoursedemyPage {

    public MyCoursedemyPage(){
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

    @FindBy (linkText = "My courses")
    public WebElement myCoursesLink;

    @FindBy(xpath = "//a[@onclick='cookieAccept();']")
    public WebElement cookies;

    @FindBy (linkText = "Instructor")
    public WebElement instructorLink;

    @FindBy (xpath = "//*[text()='Course manager']")
    public WebElement courseManagerLink;

    @FindBy (xpath = "//*[text()='Add new course']")
    public WebElement addNewCourseLink;

    @FindBy (xpath = "//*[@id='course_title']")
    public WebElement courseTitleBox;

    @FindBy (xpath = "(//*[text()='Select a category'])[2]")
    public WebElement categoryMenu;

    @FindBy (xpath = "(//*[text()='Web Design for Web Developers'])[2]")
    public WebElement categoryChoosing;

    @FindBy (xpath = "//*[@class='mdi mdi-arrow-right-bold']")
    public WebElement ilkNextButton;

    @FindBy (xpath = "//*[@placeholder='Enter course course price']")
    public WebElement coursePrice;
    //*[@placeholder='Enter course course price']

    @FindBy (xpath = "//*[@name='discounted_price']")
    public WebElement discountBox;

    @FindBy (xpath = "(//*[@placeholder='Write a keyword and then press enter button'])[2]")
    public WebElement metaKeywords;

    @FindBy (xpath = "//*[text()='Submit']")
    public WebElement submitButton;

    @FindBy (xpath = "//*[text()=' Back to course list']")
    public WebElement backToCourseList;

    public void loginMethod(){
        loginLink.click();
        emailBox.sendKeys(ConfigReader.getProperty("myValidEmail"));
        passwordBox.sendKeys(ConfigReader.getProperty("myValidPassword"));
        ReusableMethods.bekle(2);
        cookies.click();
        ReusableMethods.bekle(1);
        loginButton.click();
    }
}
