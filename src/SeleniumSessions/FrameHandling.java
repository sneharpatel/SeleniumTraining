package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FrameHandling {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://freecrm.com/"); //enter url

        driver.findElement(By.name("username")).sendKeys("uname");
        driver.findElement(By.name("password")).sendKeys("pwd123");
        driver.findElement(By.xpath("//")).click(); // click login button
        Thread.sleep(3000);

        // Frame is not allowed by w3c standard. it is gone(deprecated) from new apps
        //when frame contains on web-page, it will give "NoSuchElementException: on such element: Unable to locate element"
        // so we have to switch to frame from webpage : it accepts two types of arguments: integer, string or webElement
        // to check frame : go to that element --> right click --> this frame option --> click on view page source
        driver.switchTo().frame("mainpanel");

        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();


    }
}
