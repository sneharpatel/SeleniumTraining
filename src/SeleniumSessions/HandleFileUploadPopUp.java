package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver(); // launch chrome
        driver.get("http://html.com/input-type-file/"); // enter url
        driver.findElement(By.xpath("")).sendKeys("path of file to be uploaded");
        //type attribute should be file in html file where we inspect elements

    }
}
