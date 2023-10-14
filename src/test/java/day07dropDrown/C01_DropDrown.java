package day07dropDrown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDrown {

    // go to the amazon.com
    // select "Books" from the dropdown menu near the searchbox
    // search for Java
    // test that title contains Java

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // go to the amazon.com
        driver.get("https://www.amazon.com");

        // to select an option from dropDown
        // 1) first we need to locate the dropDown
        WebElement amazonDropBoxWebELement = driver.findElement(By.id("searchDropdownBox"));

        // 2) by using this WebElement we need to create a select object
        Select select = new Select(amazonDropBoxWebELement);

        // 3) to select "Books", we have 3 ways
        //** we can use value to select "Books"
//        Thread.sleep(1000);
//            select.selectByValue("search-alias=stripbooks-intl-ship");
//        Thread.sleep(1000);
        //** we can also use index of the "Books"
//        Thread.sleep(3000);
//        select.selectByIndex(5);
//        Thread.sleep(4000);

        //** we can also use byVisibleText
        Thread.sleep(3000);
        select.selectByVisibleText("Books");
        Thread.sleep(3000);


        // search for Java
        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));

        amazonSearchBox.sendKeys("Java" + Keys.ENTER);

        // test that title contains Java

        String expectedTitleWord = "Java";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleWord));

        // test that you have selected "Books" from dropDown

        /*
        if the system can not find the WebElement, it throws "NoSuchElementException"
        but when we refresh ( change) the page, system may not be able to locate the webelement
        and it may throw "stale element reference: stale element not found" exception
        *** solution: Just we need to relocate the webelement
         */

        amazonDropBoxWebELement = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(amazonDropBoxWebELement);
        select.selectByVisibleText("Books");

        String expectedSelectedOption = "Books";
        String actualSelectedOption = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);


        // test that there are 28 options in dropDown

        List<WebElement> dropdownOptionsList =  select.getOptions();

        int expectedOptionsNumber = 28;
        int actualOptionsNumber = dropdownOptionsList.size();

        Assert.assertEquals(expectedOptionsNumber,actualOptionsNumber);







    }


}
