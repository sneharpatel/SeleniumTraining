package SeleniumSessions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotConcept {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.get("https://google.com/");

        // take a screenshot and store in a file format
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //now copy the screenshot to desire location using copyFile // method
       //FileUtils.copyFile(src,new File("/Users/sneha/IdeaProjects/SeleniumTraining/src/SeleniumSessions/google.png"));
    }
}
