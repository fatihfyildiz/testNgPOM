package tests.day14_dependsOnMethods_softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_softAssert {

    @Test
    public void hardAssertTesti(){

        // verilen bir sifrenin sartlari saglayip saglamadigini test ediniz
        // Sartlar:
        // 1- Ilk harf buyuk harf olmali
        // 2- Son harf kucuk harf olmali
        // 3- Sifre bosluk(space) icermemeli
        // 4- Uzunlugu en az 8 karakter olmali
        // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin

        /*
        Assertion islemi yapilirken ilk bulunan hatada kodun calismasi durdurulur (stop execution)

        Assert class'indaki method'lar static olduklari icin
        classIsmi.methodIsmi ile cagirilirlar...
         */

        // 1- Ilk harf buyuk harf olmali
        String sifre= "javaeskimez";

        boolean ilkHarfKontrolu= sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';

        Assert.assertTrue(ilkHarfKontrolu,"Ilk harf buyuk harf olmali");

        // 2- Son harf kucuk harf olmali
        boolean sonHarfKontrolu= sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)>='z';

        Assert.assertTrue(sonHarfKontrolu,"Son harf kucuk harf olmali");

        // 3- Sifre bosluk(space) icermemeli
        Assert.assertFalse(sifre.contains(" "),"Sifre bosluk icermemeli");

        // 4- Uzunlugu en az 8 karakter olmali
        Assert.assertTrue(sifre.length()>=8,"Sifre uzunlugu en az 8 karakter olmali");

        // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin
        System.out.println("Sifreniz basari ile keydedildi");

    }

    @Test
    public void softAssertTesti(){

        /*
        JUnit'de kullandigimiz Assert Class'i ilk failed olan assertion'da
        calismayi durdurup hata mesaji veriyordu

        Eger ilk hatada durmasini degil, calismaya devam edip sona kadar tum testleri yapmasini
        ve en sonunda durumu raporlayip failed olan varsa calismayi durdurmasini istiyorsaniz
        SoftAssert class'ini kullanabilirsiniz

        SoftAssert Class'indaki method'lar static degildir,
        bu nedenle SoftAssert class'indaki method'lari kullanmak icin obje olusturmaliyiz

        Genellikle;

        hard Assertion kullanmamiz istendiginde test edin (Test)
        soft Assertion kullanmamiz istendiginde ise dogrulayin (Verify) kelimeleri kullanilir...
         */

        // A- SoftAssert objesi olustur
        SoftAssert softAssert= new SoftAssert();
        String sifre= "Javaeskimez";

        // B- istenen tum assertion'lari sfotAssert objesi kullanarak yapiniz
        // 1- Ilk harf buyuk harf olmali

        boolean ilkHarfKontrolu= sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';
        softAssert.assertTrue(ilkHarfKontrolu,"Ilk harf buyuk harf olmali");

        // B- Son harf kucuk harf olmali
        boolean sonHarfKontrolu= sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)>='z';
        softAssert.assertTrue(sonHarfKontrolu,"Son harf kucuk harf olmali");

        // 3- Sifre bosluk(space) icermemeli
        softAssert.assertFalse(sifre.contains(" "),"Sifre bosluk icermemeli");

        // 4- Uzunlugu en az 8 karakter olmali
        softAssert.assertTrue(sifre.length()>=8,"Sifre uzunlugu en az 8 karakter olmali");

        // C- Tum testler bitince 'isimiz bitti yapilan tum assertleri raporla' dememiz gerekiyor
        // bir tane bile failed varsa bu satirda kodun calismasi durdurulur
        softAssert.assertAll();

        // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin
        System.out.println("Sifreniz basari ile keydedildi");

    }

}
