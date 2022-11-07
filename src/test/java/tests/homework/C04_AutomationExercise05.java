package tests.homework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise04Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_AutomationExercise05 {

    @Test
    public void AutomationExercise05(){

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();

        String expectedUrl="https://automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"You are not in the correct homepage");

        // 4. Click on 'Signup / Login' button
        AutomationExercise04Page automationExercisePage= new AutomationExercise04Page();
        ReusableMethods.bekle(1);

        automationExercisePage.signUpLinki.click();

        // 5. Verify 'New User Signup!' is visible
        softAssert.assertTrue(automationExercisePage.newUserSignUp.isDisplayed());

        // 6. Enter name and already registered email address
        automationExercisePage.name.sendKeys("aurora");
        automationExercisePage.emailSignUp.sendKeys("aurora@gmail.com");

        // 7. Click 'Signup' button
        automationExercisePage.signUpButton.click();

        // 8. Verify error 'Email Address already exist!' is visible
        softAssert.assertTrue(automationExercisePage.emailAdreadyExist.isDisplayed());

        softAssert.assertAll();

        ReusableMethods.bekle(1);

        Driver.closeDriver();

    }
}
