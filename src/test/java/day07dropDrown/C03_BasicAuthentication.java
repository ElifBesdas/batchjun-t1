package day07dropDrown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        //1) visit  "https://the-internet.herokuapp.com/basic_auth"
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //2) apply the rule to pass authentication
        //Html command: https://username:password@URL
        //Username: admin
        //password: admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");


        Thread.sleep(1000);

        // test that you are in // p tag's value should be "Congratulations! You must have the proper credentials."

        String expectedMessage ="Congratulations! You must have the proper credentials.";
        WebElement messageWebElement = driver.findElement(By.tagName("p"));
        String actualMessage = messageWebElement.getText();

        Assert.assertEquals(expectedMessage,actualMessage);








    }
}
