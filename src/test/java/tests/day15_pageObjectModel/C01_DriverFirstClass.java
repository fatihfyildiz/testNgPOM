package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverFirstClass {

     /*
    POM'de 4 farkli dosyadan ihtiyacimiz olan bilgileri aliriz
    1-Driver class = driver
    2- pages packages = locate
    3- configuration.properties dosyasi = test datalari
    4- Reusable method class = ihtiyac duyabilecegimiz pratik method'lar

    Dah once kullandigimiz extends keywords ile inheritance sadece 1 class'a olabileceginden
    POM'de tercih edilmemistir

    JAva'da bir class'taki class uyelerini kullanmanin farkli yollari vardir

    1- extends ile inherit edip direkt kullanma
    2- class uyelerini static tanimlayip classAdi.uyeAdi seklidne kullanabiliriz
    3- istedigimiz class'dan obje olusturarak class uyelerini kullanabiliriz

    POM (Page Object Model) 2 yontemi de kullanir
     */

    @Test
    public void test01(){

        Driver.getDriver().get("https://www.amazon.com");
        /*
        Driver.getDriver().get("https://www.wisequarter.com");
        Driver.getDriver().get("https://www.youtube.com");

        boyle 3'unu arka arkaya yazinca 3 farkli driver ile 3 ekran aciyor
        cunku Utilies'deki WebDriver method'u her seferinde calisip bastan driver tanimlaniyor yaa...

        Driver Class'indaki getDriver() method'u icerisinde
        driver=new Chrome.Driver() satiri her calistiginda yeni bir driver olusturuyor
        yani, yeni bir browser acar

        Bizim istedigimiz ise bir test calismaya basladiginda
        driver'a 1 kere new ChromeDriver() ile deger atasin
        ama sonraki calismalarda bu satiri pass gecsin...
         */

        WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        Driver.getDriver().get("https://www.yotube.com");

        Driver.closeDriver();
    }

    @Test
    public void test02(){

        Driver.closeDriver();

    }

}
