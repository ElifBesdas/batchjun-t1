package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {

    //Create the required structure and complete the following task.
    // a. Go to the given web page.
    //      https://the-internet.herokuapp.com/checkboxes
    // b. Locate the checkbox1 and checkbox2 elements.
    // c. Click the checkbox if Checkbox1 is not selected
    // D. Click the checkbox if Checkbox2 is not selected

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // a. Go to the given web page.
        //      https://the-internet.herokuapp.com/checkboxes

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // b. Locate the checkbox1 and checkbox2 elements.

        WebElement firstCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement secondCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // c. Click the checkbox if Checkbox1 is not selected
        if (!firstCheckBox.isSelected()){
            firstCheckBox.click();
        }

        // D. Click the checkbox if Checkbox2 is not selected
        if (!secondCheckBox.isSelected()){
            secondCheckBox.click();
        }


    }

}
