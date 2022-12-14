package tests.day18_testNGReports_ParallelTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_ReusableMethodsElementList {

    @Test
    public void test01(){

    // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    // arama kutusunun yanindaki dropdown menuyu locate edin
        // Pages altindaki AmazonPage'de WebWlement dropdownMenu diye locate ettik

    // dropdown menudeki tum options listesini olusturup
        AmazonPage amazonPage= new AmazonPage();
        Select select= new Select(amazonPage.dropdownMenu);
        List<WebElement> optionsElementList= select.getOptions();

    // menude Electronics basligi oldugunu test edin
        // optionsElementList WebElement'lerden olustugu icin "Electronic" seklideki String'in listede olup olmadigini
        // test etmek icin oncelikle String'lerden olusan bir listeye ihtiyac vardir
        // iste bunu da Reusable Methods altinda yapmistik...

        List<String> optionsStringList= ReusableMethods.getElementsText(optionsElementList);

        Assert.assertTrue(optionsStringList.contains(ConfigReader.getProperty("dropdownArananOption")));

        Driver.getDriver().close();

    }
}
