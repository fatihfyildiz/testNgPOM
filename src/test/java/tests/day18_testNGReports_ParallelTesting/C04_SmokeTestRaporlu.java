package tests.day18_testNGReports_ParallelTesting;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C04_SmokeTestRaporlu extends TestBaseRapor {

    MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
    // burada yaptik bunu boylellikle Before Class ve Test'lerden de ulasilabiliniyor artik

    /*
    @BeforeMethod
    public void setUp(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        ReusableMethods.waitFor(3);

        // login linkine basin
        myCoursedemyPage.loginLink.click();
    }
     */

    @Test
    public void yanlisKullaniciTesti(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        ReusableMethods.waitFor(3);

        // login linkine basin
        myCoursedemyPage.loginLink.click();

        extentTest= extentReports.createTest("yanlis kullanici adi","yanlis kullanici adi ile giris yapilamadi");

        // 1- yanlis kullanici adi, gecerli password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myInvalidEmail"));
        extentTest.info("kullanici adi olarak yanlis email yazildi");

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myValidPassword"));
        extentTest.info("sifre olarak gecerli password yazildi");

        /* Alfabetik olarak calisan ilk test olan asagidaki yanlisEmailVeSifreTest() icinde cookies halletsek yeterli...

        ReusableMethods.waitfor(2);
        myCoursedemyPage.cookies.click();
        ReusableMethods.waitfor(2);
         */

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        extentTest.info("login butonu'na basildi");

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linkinin gorunur oldugunu test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

        extentTest.pass("giris yapilamadigi test edildi");

        ReusableMethods.waitFor(1);
    }

    @Test
    public void yanlisPasswordTesti(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        ReusableMethods.waitFor(3);

        // login linkine basin
        MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
        myCoursedemyPage.loginLink.click();

        extentTest= extentReports.createTest("yanlis password","yanlis passsword ile giris yapilamadi");

        // 2- gecerli kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myValidEmail"));
        extentTest.info("kullanici adi olarak gecerli email yazildi");

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myInvalidPassword"));
        extentTest.info("sifre olarak yanlis password yazildi");

        /*
        ReusableMethods.waitfor(2);
        myCoursedemyPage.cookies.click();
        ReusableMethods.waitfor(2);
         */

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        extentTest.info("login butonu'na basildi");

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linkinin gorunur oldugunu test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

        extentTest.pass("giris yapilamadigi test edildi");
    }

    @Test
    public void yanlisEmailVeSifreTest(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        ReusableMethods.waitFor(3);

        // login linkine basin
        MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
        myCoursedemyPage.loginLink.click();

        extentTest= extentReports.createTest("yanlis password ve yanlis kullanici adi","yanlis passsword ve kullanici adi ile giris yapilamadi");

        // 3- yanlis kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myInvalidEmail"));
        extentTest.info("kullanici adi olarak yanlis email yazildi");

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myInvalidPassword"));
        extentTest.info("sifre olarak yanlis password yazildi");

        ReusableMethods.waitFor(2);
        myCoursedemyPage.cookies.click();
        ReusableMethods.waitFor(2);

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        extentTest.info("login butonu'na basildi");

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

        extentTest.pass("giris yapilamadigi test edildi");

    }

}
