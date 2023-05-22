package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BrokenLinksTest {
    private static Object HttpURLConnection;

    public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //driver.get("https://freecrm.com/"); //enter url
//        driver.get("https://freecrm.com/"); //enter url
//        driver.findElement(By.name("username")).sendKeys("uname");
//        driver.findElement(By.name("password")).sendKeys("pwd123");
//        driver.findElement(By.xpath("//")).click(); // click login button
//        Thread.sleep(3000);
       // driver.switchTo().frame("mainpanel"); // if frame is available
        driver.get("https://makemysushi.com/404?"); //enter url

        // links --> //a href<http://www.google.com>
        // images --> //img href<http:www.test.com>

        // 1. get the list of all links and images for.e.g 500
        List<WebElement> linklist = driver.findElements(By.tagName("a"));
        linklist.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Print size of links and images---->" + linklist.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>();

        // 2. Iterate over linklist: exclude all the links and images - don't have any href attribute

        for(int i=0; i< linklist.size(); i++){
            System.out.println(linklist.get(i).getAttribute("href"));
            if(linklist.get(i).getAttribute("href") != null && linklist.get(i).getAttribute("href").contains("javascript")){
                activeLinks.add(linklist.get(i));
            }
        }

        // get size of active links
        System.out.println("Size of active links and images ---->" +activeLinks.size());

        // 3. check the href url, with httpConnection API
        // connect, ger response message, disconnect, print response message

        // 200 - ok
        // 400 - bad request
        // 404 - not found
        // 500 - internal error

        for(int j=0; j< activeLinks.size(); j++){
            URL url = new URL(null, "https://redmine.xxx.cz/time_entries.xml", new sun.net.www.protocol.https.Handler());
            HttpURLConnection connection =  (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") +"------>" +response);
        }
    }
}
