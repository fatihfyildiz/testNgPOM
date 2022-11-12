package tests.day18_testNGReports_ParallelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ReusableMethodsWindowsHandle {
    // Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro

    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkini tiklayin
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();

        /*
        Link tiklandiginda 2nci sayfa TAB olarak acilacak
        bizim de Driver'i bu 2nci sayfaya gecirmemiz gerekiyor...
         */
        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");
        // boylellikle, yukarida basligi yazili olan target sayfaya gectik

        // Acilan sayfadaki en bastaki yazinin gorunur oldugunu
        WebElement baslikElementi= Driver.getDriver().findElement(By.tagName("h1"));
        Assert.assertTrue(baslikElementi.isDisplayed());

        // ve yazinin Elemental Selenium oldugunu test edin
        String expectedYazi="Elemental Selenium";
        String actualYazi= baslikElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        Driver.closeDriver();
    }

}
