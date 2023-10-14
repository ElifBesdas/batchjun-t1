package day05_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfterAnnotations {

    // to visit three different websites, create 3 methods
    // for each method please create a driver
    // 1- amazon.com
    // 2- facebook.com
    // 3- visit youtube.com
    // for each one print the title of the page and close the driver

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        System.out.println("Before annotation is being executed");
    }

    @After
    public void tearDown(){

        driver.close();
        System.out.println("After annotation is being executed");
    }


    @Test
    public void test01(){
        // 1- amazon.com
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println("Amazon title test");

    }

    @Test
    public void test02(){
        // 2- facebook.com
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        System.out.println("facebook title test");
    }

    @Test
    public void test03(){
        // 3- visit youtube.com
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        System.out.println("youtube title test");
    }

}
