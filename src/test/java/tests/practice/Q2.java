package tests.practice;

import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseClass;

public class Q2 extends TestBaseClass {

        /*
    - Birbirine bagimli testler olusturun.
    - beforeClass olusturup setUp ayarlarini yapin.
    - Birbirine bagimli testlr olusturarak ;
        =>ilk once facebook'a gidin
        =>sonra facebook'a bagimli olarak google'a gidin
        =>daha sonra google'a bagimli olarak amazon'a gidin
    -driver'i kapatin.
     */

    @Test
    public void test1(){
        driver.get("https://www.facebook.com");
    }

    @Test (dependsOnMethods = "test1")
    public void test2(){
        driver.get("https://www.google.com");
    }

    @Test (dependsOnMethods = "test2")
    public void test3(){
        driver.get("https://www.amazon.com");
    }


}
