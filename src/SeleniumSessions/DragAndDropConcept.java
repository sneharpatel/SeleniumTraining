package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("http://jqueryui.com/droppable"); //working url

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        driver.switchTo().frame(0); // switch to frame if it is present

        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.id("draggable")))
                .moveToElement(driver.findElement(By.id("droppable")))
                .release()
                .build()
                .perform();
        System.out.println("test passed");
        driver.quit();
    }
}
