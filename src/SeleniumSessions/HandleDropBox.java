package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();
        driver.get("url"); // enter url

        // handle drop down
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByVisibleText("California");

    }
}
