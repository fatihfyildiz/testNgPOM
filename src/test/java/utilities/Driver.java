package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {



    static WebDriver driver;

    public static WebDriver getDriver(){

        // followings are set for chrome driver
        WebDriverManager.chromedriver().setup();

        if(driver==null) { // method ilk cagirildiginda driver degeri atanmamis oldugundan deger atar
                           // sonraki calismalarda ise zaten deger atanmis oldugundan alttaki 38nci satir calismaz
            driver= new ChromeDriver();
        }

        /*
        Or, alternatively... Followings are fore chrome, firefox, safari and edge

        if(driver==null) {// method ilk cagrildiginda driver degeri atanmamis oldugundan deger ata
                          // sonraki calistirmalarda degeri atanmis oldugundan 18.satir calismayacak

            String browser= ConfigReader.getProperty("browser");

            switch (browser){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
         */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver(){

        if (driver!=null){
            driver.close();
            driver=null;
        }

    }

}
