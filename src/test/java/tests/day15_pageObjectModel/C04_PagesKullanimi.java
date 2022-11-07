package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_PagesKullanimi {

    // Go to the Amazon web page
    // Create 3 test method
    // search for Nutella, Java and Bicycle in the each method
    // test whether the search results contains the searched words

    AmazonPage amazonPage= new AmazonPage();

    @Test (dependsOnMethods = "bicycleTest")
    public void nutellaTest(){
        amazonPage.searchBox.clear();
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.searchBox.sendKeys("Nutella" + Keys.ENTER);
        String actualResult= amazonPage.searchResultElement.getText();
        String expectedWord= "Nutella";
        Assert.assertTrue(actualResult.contains(expectedWord));

        ReusableMethods.bekle(3);
        Driver.closeDriver(); // due to the alphabetic order, nutellaTest works at the end, thus we close driver here
    }

    @Test (dependsOnMethods = "bicycleTest", groups = "smoke")
    public void javaTest(){
        amazonPage.searchBox.clear();
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.searchBox.sendKeys("Java" + Keys.ENTER);
        String actualResult= amazonPage.searchResultElement.getText();
        String expectedWord= "Java";
        Assert.assertTrue(actualResult.contains(expectedWord));
    }

    @Test (groups = "smoke")
    public void bicycleTest(){
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.searchBox.sendKeys("bicycle" + Keys.ENTER);
        String actualResult= amazonPage.searchResultElement.getText();
        String expectedWord= "bicycle";
        Assert.assertTrue(actualResult.contains(expectedWord));
    }





}
