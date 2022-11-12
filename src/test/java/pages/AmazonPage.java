package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    // if we will use amazon too much,
    // we can create various amazon pages such as;  AmazonIntroductionPage, AmazonElectronicsPage, etc.

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    // let's locate search box in amazon
    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox; // searchBox = aramaKutusu

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement searchResultElement; // searchResultElement = aramaSonucElement

    @FindBy (xpath = "//select[@title='Search in']")
    public WebElement dropdownMenu;

}
