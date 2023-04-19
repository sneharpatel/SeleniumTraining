package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Navigations {
    public static void main(String[] args) throws InterruptedException {

        //get() vs navigate().to()

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        driver.get("https://google.com/");
        driver.navigate().to("https://amazon.com");

        // difference between get() and navigate.to() method
        // get(): method is used to launch to url but
        // navigate().to(): used to move to some external url

        // back and forward buttons simulation
        driver.navigate().back(); // back navigation from amazon page to Google page
        Thread.sleep(2000); // wait for 2s
        driver.navigate().forward(); // forward navigation from Google page to Amazon
        Thread.sleep(2000);
        driver.navigate().back(); // navigate back to google from Amazon
        driver.navigate().refresh();


    }
}
