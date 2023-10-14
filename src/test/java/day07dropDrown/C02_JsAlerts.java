package day07dropDrown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {

    // go to "https://the-internet.herokuapp.com/javascript_alerts"
    // in 3 test methods, test a kind of JS
    // use js methods

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //// go to "https://the-internet.herokuapp.com/javascript_alerts"
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click(); // will click first js  button

        // Test that the text of JS is "I am a JS Alert"

        String expectedText = "I am a JS Alert";
        String actualText = driver.switchTo().alert().getText(); // gets the text of js PopUp window

        Assert.assertEquals(expectedText,actualText);

        driver.switchTo().alert().accept(); // presses okey button

        // test that the result message is "You successfully clicked an alert"

        String expectedMessage = "You successfully clicked an alert";

        WebElement resultTextMessageWebElement = driver.findElement(By.id("result"));
        String actualMessage = resultTextMessageWebElement.getText();

        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @Test
    public void test02(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // let's click second alert

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        //test that JS message is "I am a JS Confirm"

        String expectedJsMessage = "I am a JS Confirm";

        String actualJsMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedJsMessage,actualJsMessage);

        // test that when you accept the JsAlert the result text is "You clicked: Ok"
        String expectedResultText = "You clicked: Ok";

        WebElement resultTextMessageWebElement = driver.findElement(By.id("result"));
        String actualResultText = resultTextMessageWebElement.getText();

        Assert.assertEquals(expectedResultText,actualResultText);

    }

    @Test
    public void test03() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // let's click on third one
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Lets go!!!");

        Thread.sleep(3000);

        driver.switchTo().alert().accept();

        // test that result text is "You entered: Lets go!!!"
        String expectedResultText = "You entered: Lets go!!!";

        WebElement resultTextMessageWebElement = driver.findElement(By.id("result"));
        String actualRestText = resultTextMessageWebElement.getText();

        Assert.assertEquals(expectedResultText,actualRestText);
        Thread.sleep(3000);


    }


}
