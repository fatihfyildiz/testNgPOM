package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;

public class C03_PagesKullanimi {

    /*
       Pages class'lari bir websayfasinda locate etmek istedigimiz
       webElementleri locate edip, sonrasinda ihtiyacimiz oldukca kullanmak icin olusturulur
       pages class'larinda locate edilen webElement'lere erisebilmek icin
       test class'imizda ilgili page class'indan bir obje olustururuz
     */

    @Test
    public void test1(){
        // 1- go to the amazon page
        Driver.getDriver().get("https://www.amazon.com");

        AmazonPage amazonPage= new AmazonPage();

        // 2- search for Nutella
        amazonPage.searchBox.sendKeys("Nutella" + Keys.ENTER);

        // 3- and confirm that results contain Nutella
        String actualResult= amazonPage.searchResultElement.getText();
        String expectedWord= "Nutella";

        Assert.assertTrue(actualResult.contains(expectedWord));

        Driver.closeDriver();

    }

}
