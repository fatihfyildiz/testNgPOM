package tests.day16_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ConfigReaderKullanimi {


    @Test
    public void method1(){
        // Go to the Amazon web page
        // Create a test method
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // search for Nutella
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonSearchWord")+ Keys.ENTER);

        // test whether the search results contains the searched word Nutella
        String expectedWord= ConfigReader.getProperty("amazonSearchWord");
        String actualSearchResult= amazonPage.searchResultElement.getText();

        Assert.assertTrue(actualSearchResult.contains(expectedWord));

        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }


}
