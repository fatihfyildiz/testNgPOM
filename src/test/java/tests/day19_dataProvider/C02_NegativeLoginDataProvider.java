package tests.day19_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegativeLoginDataProvider {
    @DataProvider
    public static Object[][] kullaniciDataProvider() {

        Object[][] kullaniciBilgileri= {{"abc@gmail.com","12345"},
                                        {"gfre@gmail.com","12445"},
                                        {"abcde@gmail.com","5hfgt"},
                                        {"xyz@gmail.com","98765"},
                                        {"qxw@gmail.com","98mn00"},
                                        {"qwerfv@gmail.com","852019"},
                                        {"Brabra@gmail.com","mnbvc9"},
                                        {"abc@gmail.com","12345"},
                                        {"abc@gmail.com","12345"},
                                        {"zvyt@gmail.com","05ft97"}};

        return kullaniciBilgileri;
    }

    // Negatif login testi icin verilen 10 adet kullanici ad ive sifre deneyip
    // girip yapilamadigini test edin

    @Test (dataProvider = "kullaniciDataProvider")
    public void negatifCokluTest(String email, String password){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin
        MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
        myCoursedemyPage.loginLink.click();

        // verilen listeden kullanici adi ve password
        myCoursedemyPage.emailBox.sendKeys(email);
        myCoursedemyPage.passwordBox.sendKeys(password);

        ReusableMethods.waitFor(1);
        myCoursedemyPage.cookies.click();
        ReusableMethods.waitFor(1);

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linkinin gorunur oldugunu test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }

}
