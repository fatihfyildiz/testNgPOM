package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PositiveLoginTest {

    @Test
    public void positiveLoginTest(){

        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin
        MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
        myCoursedemyPage.loginLink.click();

        // Kullanici email'i olarak gecerli (valid) bir email girin
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myValidEmail"));

        // Kullanici sifresi olarak valid bir sifre girin
        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myValidPassword"));

        myCoursedemyPage.cookies.click();
        ReusableMethods.bekle(2);

        // Login butonuna basarak login olun
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(myCoursedemyPage.myCoursesLink.isDisplayed());

        ReusableMethods.bekle(3);
        // Driver.closeDriver();
    }


}
