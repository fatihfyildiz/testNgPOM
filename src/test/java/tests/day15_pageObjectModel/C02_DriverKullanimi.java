package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DriverKullanimi {

    // bir Test method'u olusturun
    // 1- amazon sayfasina gidiniz ve basligin Amazon icerdigini dogrulayin
    // 2- Nutella icin arama yapin ve sonuclarin Nutella icerdigini dogrulayin
    // 3- Wisequarter sayfasina gidin url'nin wisequarter icerdigini dogrulayin

    @Test
    public void test01(){

        // 1- amazon sayfasina gidiniz ve basligin amazon icerdigini dogrulayin
        Driver.getDriver().get("https://www.amazon.com");

        String expectedWord= "Amazon";
        String actualTitle= Driver.getDriver().getTitle();

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedWord),"title does not contain amazon");

        // 2- Nutella icin arama yapin ve sonuclarin Nutella icerdigini dogrulayin
        WebElement searchBox= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        WebElement resultElement=
                Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String searchedWord= "Nutella";
        String actualResult= resultElement.getText();

        softAssert.assertTrue(actualResult.contains(searchedWord),"results do not contain Nutella");

        // 3- Wisequarter sayfasina gidin url'nin wisequarter icerdigini dogrulayin
        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedUrl= "wisequarter";
        String actualUrl= Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrl),"actual Url does not contain wisequarter");

        softAssert.assertAll(); // if we introduce SoftAssert object, we must write this at the end

        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

}
