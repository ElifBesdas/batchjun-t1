package day06_assertions;

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

public class C04_BestBuyAssertion {
    // 1) go to "https://www.bestbuy.com  and create different methods for tests
    // 2) test that url equals to "https://www.bestbuy.com/"   (Url Test)
    // 3) test that title does not contains "Rest"          (Title Test)
    // 4) Test that logo is displayed                       (Logo Test)
    // 5) Test that french option is visible                (FrancaisLinkTest)

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void tearDown(){

        driver.close();

    }

    @Test
    public void urlTest(){

        // 1) go to "https://www.bestbuy.com/"  and create different methods for tests

        driver.get("https://www.bestbuy.com");
        // 2) test that url equals to "https://bestbuy.com/"   (Url Test)
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);


    }

    @Test
    public void titleTest(){
        // 3) test that title does not contains "Rest"          (Title Test)

        String expectedTitleWord = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitleWord));


    }


    @Test
    public void logoTest(){
        // 4) Test that logo is displayed                       (Logo Test)
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }


    @Test
    public void frenchLinkTest(){
        // 5) Test that french option is visible                (FrancaisLinkTest)

        WebElement frenchOptionButtonWebElement = driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(frenchOptionButtonWebElement.isDisplayed());

    }
}
