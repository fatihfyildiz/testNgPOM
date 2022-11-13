package tests.day19_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_AmazonSearchTest extends TestBaseCross {

    @Test
    public void test01(){
        // Amazon anasayfasina gidin
        driver.get(ConfigReader.getProperty("amazonUrl"));

        // Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edin
        String actualSonucYazisi=
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        String expectedKelime= "Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        ReusableMethods.waitFor(5);

    }

}
