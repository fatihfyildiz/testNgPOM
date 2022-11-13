package tests.day19_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_NegativeLoginTesti extends TestBaseCross {

    @Test
    public void negativeTest(){
        // mycoursedemy ana sayfaya gidin
        driver.get(ConfigReader.getProperty("myUrl"));

        // login linkine tiklayin
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        // email ve sifre icin geceersiz degerler girin
        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(ConfigReader.getProperty("myInvalidEmail"));

        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(ConfigReader.getProperty("myInvalidPassword"));

        ReusableMethods.waitFor(2);
        driver.findElement(By.xpath("//a[@onclick='cookieAccept();']")).click();
        ReusableMethods.waitFor(2);

        // sonra login butonuna basin
        WebElement loginButonu= driver.findElement(By.xpath("//button[text()='Login']"));
        loginButonu.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed());
        ReusableMethods.waitFor(2);
    }

}
