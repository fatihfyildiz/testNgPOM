package tests;

import org.testng.annotations.Test;
import pages.MyCourseDemyPage_Instructor;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_19 {

    @Test
    public void US19test(){
        // go to the MyCourseDemy web page
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // With a valid username and password, login to the system
        MyCourseDemyPage_Instructor myCourseDemyPage_instructor= new MyCourseDemyPage_Instructor();
        myCourseDemyPage_instructor.loginLink.click();

        myCourseDemyPage_instructor.emailBox.sendKeys(ConfigReader.getProperty("FatihValidInstructorEmail2"));
        myCourseDemyPage_instructor.passwordBox.sendKeys(ConfigReader.getProperty("FatihValidInstructorPassword2"));

        ReusableMethods.waitFor(2);
        myCourseDemyPage_instructor.cookies.click();
        ReusableMethods.waitFor(2);
        myCourseDemyPage_instructor.loginButton.click();

        // Click to the Instructor link
        myCourseDemyPage_instructor.instructorLink.click();

        // Click to the Course Manager link
        myCourseDemyPage_instructor.courseManagerLink.click();

        // The functions of the Course manager page should work correctly ...................... ////
        // When the appropriate values are selected from the filter and the filter button is pressed,
        // the relevant course should appear in the list.
        myCourseDemyPage_instructor.categoriesLink.click();
        myCourseDemyPage_instructor.categoryChoosing.click();
        myCourseDemyPage_instructor.statusLink.click();
        myCourseDemyPage_instructor.statusChoosing.click();

    }

}
