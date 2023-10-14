package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

    //Create the required structure and complete the following task.
    // a. Go to the given web page.
    //      https://facebook.com
    // b. Accept cookies
    // c. Click the Create an account button
    // D. Locate the radio button elements and choose the one that suits you

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // a. Go to the given web page.
        //      https://facebook.com
        driver.get("https://facebook.com");


        // b. Accept cookies
        // there wasn't any cookie

        // c. Click the Create an account button
        WebElement createAccountButtonWebElement = driver.findElement(By
                .xpath("//a[@data-testid='open-registration-form-button']"));

        createAccountButtonWebElement.click();

        // D. Locate the radio button elements and choose the one that suits you
        WebElement manRadioButton = driver.findElement(By.xpath("//input[@value='2']"));
        Thread.sleep(3000);
        manRadioButton.click();




    }


}
