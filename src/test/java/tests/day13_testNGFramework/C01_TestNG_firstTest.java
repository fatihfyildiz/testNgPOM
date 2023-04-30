package tests.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestNG_firstTest extends TestBase {
    /*
    TestNG, test methodlarini isim (alfabetik) sirasina gore calistirir

    Eger siralamayi degistirmek isterseniz priority kullanabiliriz

    Priority yazan method'lar, priority'si kucuk olan once baslamak uzere kucukten buyuge dogru siralanir

    Eger priority belirtilmeyen method varsa priority = 0 kabul edilir ve once o calisir
    Eger negatif -eksi degerler kullanilirsa priority'de; yine matematiksel degere gore en kucuk olandan baslayarak calisir

    Eger ayni priority degerine sahip method'lar varsa bu sefer de, method'larin alfabetik harf sirasina gore calisir
     */


    @Test (priority = 10)
    public void firstTest(){

        driver.get("https://www.amazon.com");
    }

    @Test
    public void secondTest(){

        driver.get("https://www.youtube.com");
    }

    @Test (priority = 12)

    public void thirdTest(){

        driver.get("https://www.wisequarter.com");
    }

}
