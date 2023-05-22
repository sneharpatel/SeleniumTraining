package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicWebTableHandle {
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
        driver.findElement(By.xpath("//input[@type='submit']")).click(); // click login button
        Thread.sleep(3000);

        driver.switchTo().frame("mainpanel");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click(); // click on contacts link

        // find xpath pattern to select contact name from table - row-column
        // @[id='vContactsForm']/table/tbody/tr[4]/tr[2]/a
        // @[id='vContactsForm']/table/tbody/tr[5]/tr[2]/a
        // @[id='vContactsForm']/table/tbody/tr[6]/tr[2]/a
        // @[id='vContactsForm']/table/tbody/tr[7]/tr[2]/a

        String before_xpath = "//@[id='vContactsForm']/table/tbody/tr[";
        String after_xpath = "]/tr[2]/a";

        // Method-1:
        for(int i=4; i<=7; i++){
            String name = driver.findElement(By.xpath(before_xpath+ i + after_xpath)).getText();
            System.out.println(name); // this will print all contact names from table
            if(name.contains("test2 test2")){ // i=6
                driver.findElement(By.xpath("//*[id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
            }
        }
        // Method-2:
        // //a[contains(text(),'test2 test2')]/parent::td/preceding-sibling::td//input[name='contact_id']
        driver.findElement(By.xpath("//a[contains(text(),'test2 test2')]/parent::td/preceding-sibling::td//input[name='contact_id']")).click();
    }
}


/* Method-1:
• Iterate row and column and get the cell value.
• Using for loop
• Get total rows and iterate table
• Put if(string matches) then select the respective checkbox
• Lengthy method

Method – 2:
• Using custom XPath
• Using parent and preceding-sibling tags
• No need to write for loop
• No full iteration of table
• Single line statement
• More dynamic
• Efficient and fast

Ref: https://www.youtube.com/watch?v=Ue2DmBICOkE&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT&index=19&ab_channel=NaveenAutomationLabs
 */