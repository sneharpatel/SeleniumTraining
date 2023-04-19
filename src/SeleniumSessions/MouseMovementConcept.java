package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.sql.Driver;

public class MouseMovementConcept {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://spicejet.com/"); // website has been changed
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("About Us"))).build().perform(); //

        Thread.sleep(2000); // hard wait of 2s
        driver.findElement(By.linkText("Fleet")).click();

        // how you handle multiple hierarchy base mouse movement?

    }
}
