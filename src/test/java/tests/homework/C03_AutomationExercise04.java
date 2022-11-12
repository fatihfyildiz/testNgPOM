package tests.homework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercise03Page;
import pages.AutomationExercise04Page;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_AutomationExercise04 {

    @Test
    public void AutomationExercise04(){

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();

        String expectedUrl="https://automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"homepage'de degilsiniz");

        // 4. Click on 'Signup / Login' button
        AutomationExercise04Page automationExercisePage=new AutomationExercise04Page();

        ReusableMethods.waitFor(1);

        automationExercisePage.signUpLinki.click();

        // 5. Verify 'Login to your account' is visible
        softAssert.assertTrue(automationExercisePage.loginAccountElementi.isDisplayed());

        // 6. Enter correct email address and password
        automationExercisePage.emailKutusu.sendKeys("aurora@gmail.com");
        automationExercisePage.passwordKutusu.sendKeys("aurora");

        // 7. Click 'login' button
        automationExercisePage.loginButonu.click();

        // 8. Verify that 'Logged in as username' is visible
        softAssert.assertTrue(automationExercisePage.loggedInAs.isDisplayed());

        // 9. Click 'Logout' button
        automationExercisePage.logoutButton.click();

        // 10. Verify that user is navigated to login page
        String expectedUrl2= "https://automationexercise.com/login";
        String actualUrl2= Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl2,expectedUrl2,"You are not in login page");

        softAssert.assertAll();

        ReusableMethods.waitFor(1);

        Driver.closeDriver();
    }

}
