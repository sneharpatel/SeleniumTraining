package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitConcept {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.get("http://www.facebook.com");
        clickOn(driver, driver.findElement(By.name("login")),20 );
    }

    // clickOn method will work only on click options for elements, for e.g for dropdown, this method won't work
    public static void clickOn(WebDriver driver, WebElement locator, long timeOutInSecond){
        new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecond)).ignoring(StaleElementReferenceException.class).
                until(ExpectedConditions.elementToBeClickable(locator));
        locator.click();
    }
}
