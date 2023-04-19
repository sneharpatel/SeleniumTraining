package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CustomXpath {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        driver.get("http://www.half.ebay.com");
        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // relative xpath: start with "//" and it contains only child element
        // adv: 1. syntax is simple, 2. generic, 3. reliable

        // Absolute xpath: are not recommended : it starts with '/'
        // dis adv: 1. performance issue,
        // 2. not reliable
        // 3. can be changed in any time in future

        // driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("Java");
       // driver.findElement(By.xpath("//input[@class='']")).sendKeys("Java"); //@name,
        driver.findElement(By.xpath("//input[contains(@class,'ui-autocomplete-input')]")).sendKeys("Java");

        // dynamic ids input :  how to handle dynamic id?
        // for e.g: id = test_123 --> By.id("test_123")

        // starts-with
        // id = test_456
        // id = test_789 --> it will ignore dynamic part
//        driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("test");
//        driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("test");

        // ends-with
        // id = 1234_test_t
        // id = 5678_test_t
        // id = 9876_test_t
        //driver.findElement(By.xpath("//input[ends-with(@id,'_test_t')]")).sendKeys("test");

        //for links: custom xpath
        // all the links are represented by <a> html tag

        driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click();

        /* Custom Xpath:
        Xpath=//input[@type='text']
        Xpath=//label[@id='message23']
        Xpath=//input[@value='RESET']
        Xpath=//*[@class='barone']
        Xpath=//a[@href='http://demo.guru99.com/']
        Xpath=//img[@src='//guru99.com/images/home/java.png']
        Xpath=//*[contains(text(),'here')]
        Xpath=//*[contains(@href,'guru99.com')]*/




    }
}
