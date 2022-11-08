package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q4 extends TestBase {

    SoftAssert softAssert= new SoftAssert();

    @Test
    public void saucedemoTest1(){

        // Navigate to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // Enter the username as standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter the password as secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        wait(2);

        // Click on login button
        driver.findElement(By.id("login-button")).click();

        // Test1 : Choose price low to high
        WebElement dropDown= driver.findElement(By.className("product_sort_container"));
        Select select= new Select(dropDown);
        select.selectByVisibleText("Price (low to high)");

        String expectedText= "PRICE (LOW TO HIGH)";
        String actualText= driver.findElement(By.className("active_option")).getText();

        softAssert.assertEquals(actualText,expectedText, "Active option has different text than the data");

        softAssert.assertAll();
    }

    @Test
    public void saucedemoTest2(){

        // Navigate to https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // Enter the username as standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter the password as secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        wait(2);

        // Click on login button
        driver.findElement(By.id("login-button")).click();

        WebElement dropDown= driver.findElement(By.className("product_sort_container"));
        Select select= new Select(dropDown);
        select.selectByVisibleText("Price (low to high)");

        // Test2 : Verify item prices are sorted from low to high with soft Assert

        List<WebElement> prices= driver.findElements(By.className("inventory_item_price"));

        ArrayList<Double> pricesDouble= new ArrayList<>();

        for (WebElement each: prices
             ) {
            // String priceStr= each.getText();
            // System.out.println(priceStr); ==> all prices come with $ signs thus we need to replace all of those $ signs

            String priceStr= each.getText().replaceAll("^\\D","");
            System.out.println(priceStr); //

            pricesDouble.add(Double.parseDouble(priceStr));
        }

        ArrayList<Double> controlList= new ArrayList<>(pricesDouble);

        Collections.sort(controlList);

        softAssert.assertEquals(controlList,pricesDouble, "Prices are not equal to the ones in the control list");

        softAssert.assertAll();

    }

}
