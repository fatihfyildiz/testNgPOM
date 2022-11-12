package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class EndToEndTest {

    /*
    E2E (end To End) testi; uctan uca bir islevin tum asamalarini gerceklestirerek
    islevin calistigini test etmek demektir

    Bir uygulamada bircok e2e testi olabilir
     */

    @Test
    public void e2eKursOlusturmaTesti(){
        // Mycoursedemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // gecerli kullanici adi ve sifre girerek sisteme login olun
        MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();

        /* 1st and slow choice:....

        myCoursedemyPage.loginLink.click();
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myValidEmail"));
        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myValidPassword"));
        myCoursedemyPage.cookies.click();
        myCoursedemyPage.loginButton.click();
         */

        myCoursedemyPage.loginMethod();

        // Instructor linkini tiklayin
        myCoursedemyPage.instructorLink.click();

        // course manager linkine tiklayin
        myCoursedemyPage.courseManagerLink.click();

        // add new course linkine tiklayin
        myCoursedemyPage.addNewCourseLink.click();

        //course title bilgisi giriniz
        myCoursedemyPage.courseTitleBox.sendKeys(ConfigReader.getProperty("myCourseTitle"));

        // category menusunu tiklayiniz
        myCoursedemyPage.categoryMenu.click();

        // ilgili kurst kategorisini seciniz
        myCoursedemyPage.categoryChoosing.click();

        // next butonuna basalim
        myCoursedemyPage.ilkNextButton.click();

        // tekrar nextbutonuna basalim
        myCoursedemyPage.ilkNextButton.click();

        // price kutusun fiyati yazdiralim
        ReusableMethods.waitFor(1);

        myCoursedemyPage.coursePrice.sendKeys(ConfigReader.getProperty("myCoursePrice"));

        // indirimi yapalim
        myCoursedemyPage.discountBox.sendKeys(ConfigReader.getProperty("myDiscount"));

        // tekrar nextbutonuna basalim
        myCoursedemyPage.ilkNextButton.click();

        // tekrar nextbutonuna basalim
        myCoursedemyPage.ilkNextButton.click();

        // meta keywords kutusuna java kursu yazdiralim
        myCoursedemyPage.metaKeywords.sendKeys(ConfigReader.getProperty("myMetaKeywords"));

        // tekrar nextbutonuna basalim
        myCoursedemyPage.ilkNextButton.click();

        // submut ediniz
        myCoursedemyPage.submitButton.click();

        // yeni kursun olusturuldugunu test edin
        Assert.assertTrue(myCoursedemyPage.backToCourseList.isEnabled());
    }

}
