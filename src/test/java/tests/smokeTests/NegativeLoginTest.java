package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NegativeLoginTest {

    MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
    // burada yaptik bunu boylellikle Before Class ve Test'lerden de ulasilabiliniyor artik

    @BeforeClass
    public void setUp(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin
        myCoursedemyPage.loginLink.click();
    }

    // uc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin

    @Test
    public void yanlisKullaniciTesti(){
        // 1- yanlis kullanici adi, gecerli password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myInvalidEmail"));
        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myValidPassword"));

        /* Alfabetik olarak calisan ilk test olan asagidaki yanlisEmailVeSifreTest() icinde cookies halletsek yeterli...

        ReusableMethods.bekle(2);
        myCoursedemyPage.cookies.click();
        ReusableMethods.bekle(2);
         */

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linkinin gorunur oldugunu test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

        ReusableMethods.waitFor(1);
    }

    @Test
    public void yanlisPasswordTesti(){
        // 2- gecerli kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myValidEmail"));
        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myInvalidPassword"));

        /*
        ReusableMethods.bekle(2);
        myCoursedemyPage.cookies.click();
        ReusableMethods.bekle(2);
         */

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linkinin gorunur oldugunu test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }

    @Test
    public void yanlisEmailVeSifreTest(){
        // 3- yanlis kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myInvalidEmail"));
        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myInvalidPassword"));

        ReusableMethods.waitFor(2);
        myCoursedemyPage.cookies.click();
        ReusableMethods.waitFor(2);

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }


    @AfterClass
    public void teardown(){
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
}
