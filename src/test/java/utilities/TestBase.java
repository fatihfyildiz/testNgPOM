package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

    public void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void takePhoto(String photoName){
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File photoDossier= new File("target/screenShots/"+photoName+".jpeg");
        File tempDossier= takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(tempDossier,photoDossier);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
