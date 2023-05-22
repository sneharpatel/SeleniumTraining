package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;



public class JavaScriptExecutorConcept {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies
        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.freecrm.com");
        WebElement loginBtn = driver.findElement(By.className("mdi-chart-bar"));
        flash(loginBtn,driver); // highlight the element
        drawBorder(loginBtn,driver); // draw border

        // take a screenshot:
        // take a screenshot and save as a file format

        // click an element by JS executor
        clickElementByJS(loginBtn,driver);

        // Refresh the page:
        // 1. by refresh() method
        driver.navigate().refresh();

        // 2. By using JS executor
        refreshBrowserByJS(driver);

        // getTitle by JS executor
        System.out.println(getTitleByJS(driver));
        // getInner text of html page
        System.out.println(getPageInnerText(driver));

        // scroll page down
        //System.out.println(scrollPageDown(driver));

        WebElement forgotPwdLink = driver.findElement(By.xpath("//a[contains(text(),'Restaurant CRM')]"));
        System.out.println(forgotPwdLink.getText());
        System.out.println(scrollIntoView(forgotPwdLink,driver));
    }

    public static void flash(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String bgColor = element.getCssValue("backgroundColor");
        for(int i=0; i<10; i++){
            changeColor("rgb(0,200,0)", element,driver); // 1
            changeColor(bgColor,element,driver);
        }
    }

    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try{
           Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }

    public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);

    }

    public static void generateAlert(WebElement element, WebDriver driver){

    }

    public static void clickElementByJS(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", element);
    }

    public static void refreshBrowserByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");
    }

    public static String getTitleByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
       String title =  js.executeScript("return document.title;").toString();
       return title;

    }

    public static String getPageInnerText(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public static boolean scrollPageDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        return true;
    }

    public static boolean scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return true;
    }
}

//https://www.youtube.com/watch?v=Dpx1Q62QpFU&ab_channel=NaveenAutomationLabs
