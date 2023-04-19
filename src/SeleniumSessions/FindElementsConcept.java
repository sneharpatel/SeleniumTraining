package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsConcept {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("http://facebook.com");

        //1. get the total count of links on the page
        // 2. get the text of each link on the page

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        // size of LinkList
        System.out.println(linkList.size());

        // 2. print each link text

        for(int i=0; i< linkList.size(); i++){
            String linkText = linkList.get(i).getText();
            System.out.println(linkText);
        }
    }
}
