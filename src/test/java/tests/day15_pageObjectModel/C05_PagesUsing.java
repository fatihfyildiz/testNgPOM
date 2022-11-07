package tests.day15_pageObjectModel;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_PagesUsing {

    @Test
    public void test01(){
        // 1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");


        // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker= new Faker();
        FacebookPage facebookPage= new FacebookPage();

        facebookPage.facebookCookies.click();

        facebookPage.facebookEmailBox.sendKeys(faker.internet().emailAddress());
        facebookPage.facebookPasswordBox.sendKeys(faker.internet().password());
        facebookPage.facebookLogin.click();

        // 4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.facebookPasswordConfirm.isDisplayed());

        ReusableMethods.bekle(3);
    }
}
