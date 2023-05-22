package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// javaScript pop up - alert
public class AlertPopUpHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mail.rediff.com/cgi-bin/login.cgi"); // enter url

        driver.findElement(By.name("proceed")).click(); //click to go button on webpage w/o entering username and pw
        // alert/pop up will come --> switch from main webpage to pop up alert
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String text = alert.getText();
        if(text.equals("Please enter a valid user name")){
            System.out.println("Correct alert message");
        }else {
            System.out.println("In-correct alert message");
        }
        alert.accept(); // click ok button on pop up
        //alert.dismiss(); // click cancel button on pop up
    }
}
