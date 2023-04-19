package SeleniumSessions;
//import

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {
    public static void main(String[] args){

        // 1. FF browser
        // gecko driver
        //System.setProperty("webdriver.chrome.driver","/Users/sneha/drivers");
        WebDriver driver = new ChromeDriver();
        System.out.println("Hello");

    }
}
