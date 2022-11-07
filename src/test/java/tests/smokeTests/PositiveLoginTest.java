package tests.smokeTests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

    @Test
    public void positiveLoginTest(){

        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty(""));

        // login linkine basin
        // Kullanici email'i olarak gecerli (valid) bir email girin
        // Kullanici sifresi olarak valid bir sifre girin
        // Login butonuna basarak login olun
        // Basarili olarak giris yapilabildigini test edin

    }


}
