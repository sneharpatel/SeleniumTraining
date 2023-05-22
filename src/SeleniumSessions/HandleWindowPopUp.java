package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

// window pop up - it has url & it can be maximized
public class HandleWindowPopUp {
    public static void main(String[] args) throws InterruptedException {

        // 1. alert - JavaScript pop up - Alert API switchTo().alert() (accept, dismiss methods)
        // 2. File upload pop up - Browse, uploadFile, attach button - ( type=file, sendKeys(path) )
        // 3. Browser pop up - Advertisement pop up (WindowHandler API - getWindowHandles() method )

        WebDriver driver  = new ChromeDriver();
        driver.get("http://www.popuptest.com/goodpopups.html");
        driver.findElement(By.xpath("")).click();
        Thread.sleep(2000);

        Set<String> handler = driver.getWindowHandles(); // getWindowHandles method will give unique id of windows
        Iterator it = handler.iterator();

        String parentWindowId = (String) it.next();
        System.out.println("Parent window ID : " + parentWindowId);

        String childWindowId = (String) it.next();
        System.out.println("Child window ID : " + childWindowId);

        driver.switchTo().window(childWindowId);

        Thread.sleep(2000);

        System.out.println("Get child window pop up title  : " + driver.getTitle()); // get the title and close the window

        driver.close(); // just close the child pop up window (specific window) after visiting child window, quit() method close all the window

        driver.switchTo().window(parentWindowId);

        Thread.sleep(2000);

        System.out.println("Get parent window pop up title : " + driver.getTitle());

    }
}

/* getWindowHandles method will give set object of unique ids. and ids in the form of string
(property of set is, it does not store values based on index, so that is why we are using iterator here.)
which can not generate by any code or other method
* we have to generate unique ids dynamically at run time by using getWindowsHandles() method
 it is in set form. it doesn't maintain orders */

// interview question: how to handle multiple child window pop?
// https://www.youtube.com/watch?v=PUanHXTSlR8&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=10&ab_channel=NaveenAutomationLabs