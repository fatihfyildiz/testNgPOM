package tests.day14_dependsOnMethods_softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseClass;

public class C01_DependsOnMethods extends TestBaseClass {

    // Uc test method olusturun
    // 1.testin ismi amazon testi olsun
    // amazon anasayfasina gidip amazon'a gittigimizi test edin
    // 2.testin ismi nutalla olsun ve
    // nutella icin arama yapip sonuclarin nutella icerdigini test edin
    // 3.testin ismi arama sonuc testi olsun
    // sonuc sayisinin  100'den buyuk oldugunu test edin

    /*
    dependsOnMethods = "BagliOlunanTestAdi"
    iki test method'unu birbirine baglar

    Bu sekilde bagli olunan test failed olursa,
    bagli olan test ignore edilir, hic calismaz
     */

    @Test (priority = 1)
    public void amazonTesti(){
        // 1.testin ismi amazon testi olsun
        // amazon anasayfasina gidip amazon'a gittigimizi test edin
        driver.get("https://www.amazon.com/");

        String expectedUrl= "amazon.com";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test (priority = 2,dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){
        // 2.testin ismi nutalla olsun ve
        // nutella icin arama yapip sonuclarin nutella icerdigini test edin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        WebElement resultsElement=
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedWord= "Nutella";
        String actualText= resultsElement.getText();

        Assert.assertTrue(actualText.contains(expectedWord));
    }

    @Test (priority = 5,dependsOnMethods = "nutellaTesti")
    public void aramaSonucTesti(){
        // 3.testin ismi arama sonuc testi olsun
        // Nutella icin sonuc sayisinin  100'den buyuk oldugunu test edin
        WebElement resultsElement=
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualText= resultsElement.getText(); // 1-48 of 114 results for "Nutella"
        System.out.println(resultsElement.getText()); //

        int indexOf= actualText.indexOf("of");
        int indexResults= actualText.indexOf("results");

        String resultsNumberStr= actualText.substring(indexOf+3,indexResults-1);
        Integer resultsNumberInt= Integer.parseInt(resultsNumberStr);
        Integer expectedMinResults= 100;

        Assert.assertTrue(resultsNumberInt>expectedMinResults);

    }

}
