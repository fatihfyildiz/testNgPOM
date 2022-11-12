package tests.homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise04Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_AutomationExercise06 {

    @Test
    public void AutomationExercise06(){ // also go to Pages and see the AutomationExercise04Page

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

        // 3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();

        String expectedUrl="https://automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"You are not in the correct homepage");

        // 4. Click on 'Contact Us' button
        AutomationExercise04Page automationExercisePage= new AutomationExercise04Page();
        ReusableMethods.waitFor(1);

        automationExercisePage.contactUs.click();

        // 5. Verify 'GET IN TOUCH' is visible
        softAssert.assertTrue(automationExercisePage.getInTouch.isDisplayed());

        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

        // 6. Enter name, email, subject and message
        Faker faker= new Faker();

        automationExercisePage.getInTouchName.sendKeys(faker.name().fullName());
        automationExercisePage.getInTouchEmail.sendKeys(faker.internet().emailAddress());
        automationExercisePage.subject.sendKeys("Hej!");
        automationExercisePage.message.sendKeys("Hur mår du?");

        ReusableMethods.waitFor(1);

        // 7. Upload file
        automationExercisePage.chooseFileButton.click();
        String uploadFilePath= "C:\\Users\\ffyil\\Downloads\\logo.png";
        automationExercisePage.chooseFileButton.sendKeys(uploadFilePath);



        // 8. Click 'Submit' button

        // 9. Click OK button

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible

        // 11. Click 'Home' button and verify that landed to home page successfully

        softAssert.assertAll();

        ReusableMethods.waitFor(1);

        Driver.closeDriver();

    }
}
