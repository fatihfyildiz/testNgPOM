package tests.day15_pageObjectModel;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C06_AutomationExercise2 {


    // Mail		:	aurora@gmail.com
    // Password	:	aurora

    @Test
    public void test01(){
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        SoftAssert softAssert= new SoftAssert();

        /*
        String expectedUrl= "automationexercise.com";
        String actualUrl= Driver.getDriver().getCurrentUrl();
         */

        String expectedTitle="Automation Exercise";
        String actualTitle= Driver.getDriver().getTitle();

        softAssert.assertEquals(actualTitle,expectedTitle,"You are not in the correct page");

        // 4. Click on 'Signup / Login' button
        AutomationExercisePage automationExercisePage= new AutomationExercisePage();
        automationExercisePage.signUpLink.click();
        ReusableMethods.bekle(1);

        // 5. Verify 'Login to your account' is visible

        softAssert.assertTrue(automationExercisePage.loginAccountElement.isDisplayed());

        // 6. Enter correct email address and password
        automationExercisePage.emailBox.sendKeys("aurora@gmail.com");
        automationExercisePage.passwordBox.sendKeys("aurora");

        // 7. Click 'login' button
        automationExercisePage.loginButton.click();

        // 8. Verify that 'Logged in as username' is visible
        softAssert.assertTrue(automationExercisePage.loggedInAs.isDisplayed());

        // 9. Click 'Delete Account' button
        automationExercisePage.deleteAccountButton.click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        softAssert.assertTrue(automationExercisePage.accountDeleted.isDisplayed());

        softAssert.assertAll();
        ReusableMethods.bekle(1);
        Driver.closeDriver();
    }
}
