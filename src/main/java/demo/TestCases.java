package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        // driver.close();
        // driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/ ");
        String url = driver.getCurrentUrl();
        if(url.contains("calendar")){
            System.out.println("The URL of the Calendar homepage contains \"calendar\".");
        }
        else{
            System.out.println("The URL of the Calendar homepage contains \"calendar\".");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        WebElement formatDropdown = driver.findElement(By.xpath("(//span[@jsname='V67aGc'])[5]"));
        formatDropdown.click();
        Thread.sleep(3000);

        // WebElement dayf = driver.findElement(By.xpath("(//span[text()='Day'])[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();",dayf);

        Thread.sleep(2000);
        WebElement month = driver.findElement(By.xpath("//ul[@class='VfPpkd-StrnGf-rymPhb DMZ54e']//li[3]/span[@jsname='K4r5Ff']"));
        Thread.sleep(3000);
        month.click();
        WebElement month1 = driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div/div[5]/div/div[1]/div[1]/div/button/span"));
        String month2 = month1.getText();
        
        if(month2.contains("Month")){
            System.out.println("The calendar is switched to Month view");
        }
        
        Thread.sleep(2000);
        WebElement day = driver.findElement(By.xpath("//*[@id=\"YPCqFe\"]/div/div/div/div[2]/div[5]/div[3]/div/div[7]"));
        js.executeScript("arguments[0].click();",day);
        Thread.sleep(3000);

        WebElement task = driver.findElement(By.xpath("//button[@class='nUt0vb zmrbhe']"));
        js.executeScript("arguments[0].click();",task);
        Thread.sleep(3000);

        WebElement title =driver.findElement(By.xpath("(//input[@class='VfPpkd-fmcmS-wGMbrd '])[2]"));
        title.sendKeys("Crio INTV Task Automation");
        Thread.sleep(3000);

        WebElement date = driver.findElement(By.xpath("(//button[@class='nUt0vb qx9Fae YkAcPc'])[3]"));
        js.executeScript("arguments[0].click();",date);
        Thread.sleep(3000);

        WebElement selectDate = driver.findElement(By.xpath("(//input[@class='VfPpkd-fmcmS-wGMbrd '])[9]"));
        Thread.sleep(3000);
        selectDate.sendKeys("23 Aug 2024");
        
        
         
        Thread.sleep(3000);
        WebElement description =driver.findElement(By.xpath("//textarea[@class='VfPpkd-fmcmS-wGMbrd TaTzUd']"));
        description.sendKeys("Crio INTV Calendar Task Automation");

        Thread.sleep(3000);
        WebElement saveButton =driver.findElement(By.xpath("//button[@jsname='x8hlje']"));
        saveButton.click();

        System.out.println("end Test case: testCase02");
    }
    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        WebElement task =driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
        task.click();
        Thread.sleep(3000);
        WebElement edit =driver.findElement(By.xpath("(//span[@class='VfPpkd-kBDsod meh4fc KU3dEf'])[3]"));
        edit.click();
        Thread.sleep(2000);
        WebElement description1 =driver.findElement(By.xpath("//textarea[@jsname='YPqjbf']"));
        description1.clear();
        Thread.sleep(1000);
        description1.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(3000);
        WebElement saveButton =driver.findElement(By.xpath("//button[@jsname='x8hlje']"));
        saveButton.click();
        Thread.sleep(1000);
        WebElement update = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
        if(update.isDisplayed()){
            System.out.println("'Task Updated' message is displayed");
        }
        System.out.println("end Test case: testCase03");
    }
    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        WebElement task =driver.findElement(By.xpath("//div[@class='T3BIT']//div[@role='presentation']//div[@class='qLWd9c']//span[text()='Crio INTV Task Automation']"));
        Thread.sleep(2000);
        task.click();
        
        Thread.sleep(2000);
        WebElement title = driver.findElement(By.xpath("//*[@id=\"rAECCd\"]"));
        String title2 = title.getText();
        System.out.println(title2);
        Thread.sleep(2000);

        if(title2.contains("Crio INTV Task Automation")){
            System.out.println("Title is correct");
        }
        else{
            System.out.println("Title is not correct");
        }

        Thread.sleep(2000);
        WebElement description1 = driver.findElement(By.xpath("//*[@id=\"xDetDlgDesc\"]"));
        String description2 = description1.getText();
        System.out.println(description2);
        Thread.sleep(2000);

        if(description2.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")){
            System.out.println("Description is correct");
        }
        else{
            System.out.println("Description is not correct");
        }
        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.xpath("//button[@jsname='VkLyEc']"));
        deleteButton.click();
        Thread.sleep(4000);
        // Alert alertBox = driver.switchTo().alert();
        // String delete = alertBox.getText();
        WebElement delete1 = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
        String  delete2 =delete1.getText();
        System.out.println(delete2);
        if(delete2.contains("Task deleted")  && delete2.equals("Task deleted")){
                    if(delete1.isDisplayed()){
            System.out.println("'Task deleted' message is displayed");
        }
    }
        System.out.println("end Test case: testCase04");
    }


}
