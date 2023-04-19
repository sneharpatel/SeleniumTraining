package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaitConcept {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver(); // launch web-driver
        driver.get("http://www.half.ebay.com"); // go to the url

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        // Thread.sleep(2000); hard wait : code execution will be stopped until 2 seconds, even page and element load before 2s

        // dynamic waits: if web page and web element load with in 4-5 seconds then rest of the time is ignored and
        // code execution will continue
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40)); // web page load timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // web element load timeout


    }
}
