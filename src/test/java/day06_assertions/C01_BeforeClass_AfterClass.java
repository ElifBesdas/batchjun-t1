package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {

    // create 3 different test methods
    // 1) go to amazon.com, test that you are in right address  (visit)
    // 2) search for nutella in amazon.com, and test that result has "nutella" keyword (continue and searc for nutella)
    // 3) test that number of results is higher than 50 ( go on and check the number)

    // @BeforeClass or @Before ????

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
    public void test01(){
        // 1) go to amazon.com, test that you are in right address  (visit)
        driver.get("https://www.amazon.com");
        // we will test it by using the title of the page
        String expectedTitleWord = "Amazon";
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);

        if (actualTitle.contains(expectedTitleWord)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }


    }


    @Test
    public void test02(){
        // 2) search for nutella in amazon.com, and test that result has "nutella" keyword (continue and searc for nutella)

        //search for nutella in amazon.com
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));

        amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

        //test that result has "nutella" keyword
        WebElement resultWebElement = driver.findElement(By
                .xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));

        String expectedResultWord = "ANutella";
        String actualResultText = resultWebElement.getText();
        System.out.println(actualResultText);

        if (actualResultText.contains(expectedResultWord)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }



    }

    //3) test that number of results is higher than 50 ( go on and check the number)

    @Test
    public void test03(){

        WebElement resultWebElement = driver.findElement(By
                .xpath("//div[@class='sg-col-14-of-20 sg-col-18-of-24 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']"));
        String actualResultText = resultWebElement.getText();   // 1-48 of 865 results for "Nutella"

        String[] resultArray =  actualResultText.split(" ");

        //System.out.println(resultArray[2]); // 865
        String resultNumber = resultArray[2]; // 865

        int resultNumberInt = Integer.parseInt(resultNumber); // 865

        if (resultNumberInt>50){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
    }
}
