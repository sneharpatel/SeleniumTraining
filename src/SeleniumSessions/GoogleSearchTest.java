package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://google.com/"); //enter url
        Thread.sleep(2000);
       driver.findElement(By.name("q")).sendKeys("Testing");
//       List<WebElement> list = driver.findElements(By.className("aajZCb"));
        // search testing and from ul, it will show multiple 'li' select first once and then search for descendant i.e 3rd div
        // and select class for that div
       List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='lnnVSe']"));
       System.out.println("Total no.s of suggestion in search box =====> " + list.size()); // size = 10, it might be change later as its dynamic in nature

        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("testing library")){
                list.get(i).click();
                break;
            }
        }
    }
}

/* Descendant:
- We can get all descendants of an element with Selenium webdriver.
First, we need to identify the parent element with help of any of
the locators like id, class, name, xpath or css.
Then we have to identify the descendants with the findElements(By.xpath()) method.

- We can find the descendants from the parent element,
by localizing it with the parent and then passing ( .//*) as a parameter to the findElements(By.xpath())

*/

