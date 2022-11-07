package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.util.List;

public class Q3 extends TestBaseClass {

    /*
    - go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    - Task 1 - Find Dropdown on Multi Selection
    - Task 2 - Find all Dropdown Elements
    - Task 3 - Printout Dropdown Elements' number
    - Task 4 - Choose all Dropdown elements and printout Dropdown elements' name on Multi Selection
    - Task 5 - Check until choice 5
    */

    @Test
    public void test01(){

        // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        // Task 1 - Find Dropdown on Multi Selection
        WebElement dropDown = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        dropDown.click();

        // Task 2 - Find all Dropdown Elements

        List<WebElement> choiceList= driver.findElements(By.className("ComboTreeItemChlid"));

        // Task 3 - Printout Dropdown Elements' number

        System.out.println("Dropdown'lardaki secenek sayisi " + choiceList.size());

        // Task 4 - Choose all Dropdown elements and printout Dropdown elements' name on Multi Selection

        for (int i = 0; i < choiceList.size(); i++) {

            String text= choiceList.get(i).getText();

            System.out.println("Text" + text);
        }

        System.out.println("====================================");

        // Task 5 - Check until choice 5

        /*
        for (int i = 0; i < choiceList.size(); i++) {

            String text= choiceList.get(i).getText();
            System.out.println("Text" + text);

            if (!text.isEmpty()){
                choiceList.get(i).click();
            }

            if (text.equals("choice 5")){
                break;
            }

        }
         */

        Select select= new Select(dropDown);

        for (int i = 0; i < choiceList.size(); i++) {

            select.selectByIndex(i);

            String text= choiceList.get(i).getText();

            if (!text.isEmpty()){
                choiceList.get(i).click();
            }

            if (text.equals("choice 5")){
                break;
            }

        }

    }

}
