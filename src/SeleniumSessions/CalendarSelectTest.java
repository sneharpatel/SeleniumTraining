package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CalendarSelectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies

        // Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://freecrm.com/"); //enter url
        driver.findElement(By.name("username")).sendKeys("uname");
        driver.findElement(By.name("password")).sendKeys("pwd123");
        driver.findElement(By.xpath("//")).click(); // click login button
        Thread.sleep(3000);

        driver.switchTo().frame("mainpanel"); // if there is frame then otherwise skip this step

        String date = "18-September-2017";
        String dateArr[] = date.split("-"); // date will split by - {18, September, 2017}
        String day = dateArr[0]; // day i.e 18 will store in this variable
        String month = dateArr[1]; // month i.e September will store in this variable
        String year = dateArr[2]; // year i.e 2017 will store in this variable

        Select select = new Select(driver.findElement(By.name("slctMonth")));
        select.selectByVisibleText(month);
        Select select1 = new Select(driver.findElement(By.name("slctYear")));
        select1.selectByVisibleText(year);

        // find xpath pattern to select day from table - row-column
        // @[id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
        // @[id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
        // @[id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]

        String beforeXpath = "@[id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
        String afterXpath = "]/td[";
        final int totalWeekDays = 7;
        //2-1 2-2 2-3 2-4 2-5 2-6
        //3-1 3-2 3-3 3-4 3-5 3-6 and so on
        boolean flag = false;
        String dayValue = null;
        for(int rowNum=2; rowNum<=7; rowNum++){
            for(int colNum=1; colNum<=totalWeekDays; colNum++){
                try {
                    dayValue = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).getText();
                }catch(NoSuchElementException e){
                    System.out.println("Please enter a correct day value");
                    flag = false;
                    break;
                }
                System.out.println(dayValue);
                if(dayValue.equals(day)){
                    driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
                    flag = true;
                    break;
                }
            }
            if(flag){
            break;
            }
        }
    }

}

// interview question: how to handle calendar using selenium?

// 1. With the help of dynamic webTableXpath concept
// 2. Iterate the entire calendar grid by row and column
// 3. Match the value and select the day
// 4. Handle NoSuchElementException in case of 31st day