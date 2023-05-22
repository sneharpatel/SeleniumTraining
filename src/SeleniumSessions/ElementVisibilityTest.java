package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElementVisibilityTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://freecrm.com/register/"); //enter url

        // 1. isDisplayed() method -- applicable for all the elements
        boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
        System.out.println(b1); // true

        // 2. isEnabled() method - check whether element is enabled or disabled
        boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b2); // false

        //select I Agree so submit button will be enabled

        driver.findElement(By.name("agreeTerms")).click();
        boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
        System.out.println(b3); // true

        // 3. isSelected method() - only applicable for checkbox, dropdown, radiobutton
        boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println(b3); // true

        // de-select the checkbox first
        driver.findElement(By.name("agreeTerms")).click();
        boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println(b5); // false
    }

}
