package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
    static WebDriver driver;
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();

        FileInputStream ip = new FileInputStream("/Users/sneha/IdeaProjects/SeleniumTraining/src/SeleniumSessions/config.properties");
        prop.load(ip);

        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));

        String url = prop.getProperty("url");
        System.out.println(url);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if(browserName.equals("FireFox")){
            driver = new FirefoxDriver();
        } else if(browserName.equals("IE")){
            driver = new InternetExplorerDriver();
        } else if(browserName.equals("Safari")){
            driver = new SafariDriver();
        }

        driver.get(url);

        driver.findElement(By.id(prop.getProperty("firstName_id"))).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.id(prop.getProperty("lastName_id"))).sendKeys(prop.getProperty("lastName"));

    }
}
