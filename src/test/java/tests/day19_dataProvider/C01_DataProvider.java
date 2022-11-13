package tests.day19_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_DataProvider {


    @DataProvider
    public static Object[][] AranacakKelimeProvider() {

        Object [][] aranacaklar= {{"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"TV"}};

        return aranacaklar;
    }

    @Test (dataProvider = "AranacakKelimeProvider")
    public void aramaTesti(String aranacakKelime){
        // Amazon anasayfaya gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella, Java, Apple, Samsung, TV icin arama yapin
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.searchBox.sendKeys(aranacakKelime + Keys.ENTER);

        // Arama sonuclarinin aranan kelimyi icerdigini test edin
        String actualResultWriting= amazonPage.searchResultElement.getText();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(actualResultWriting.contains(aranacakKelime));

    }

}
