package tests.practice;

import org.testng.annotations.Test;
import utilities.TestBase;

public class Q1 {

    /*
    > TestNG default olarak @Test methodlarini alfabetik siraya gore run eder,
    yukaridan asagiya dogru degil.
    > priority annotation testlre oncelik vermek icin kullanilir,
     kucuk olan numara daha once calisir.
    > ama arada birisine bagli olanlar (dependOnmethods = " ") var ise
      bagli oldugu method'tan hemen sonra onlar calisir, sonra yine oncelige (priority'e) gore devam eder
    > priority'ler esit ise : TestNG testlerinde , testler konsola alfabetik sira ile yazdirilir.
    > priority'de default degeri sifirdir.
    > enabled = false methodu : Testi gormezden gelmek icin @Test 'in yanina yazilir.
     */

    @Test (priority = 300)
    public void b(){

        System.out.println("b");
    }

    @Test (priority = -300)
    public void a(){

        System.out.println("a");
    }

    @Test (priority = 200)
    public void c(){

        System.out.println("c");
    }

    @Test (dependsOnMethods = "c")
    public void d(){

        System.out.println("d");
    }

    @Test (dependsOnMethods = "c")
    public void e(){

        System.out.println("e");
    }


}
