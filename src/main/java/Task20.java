import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task20 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver

    }

    @Test
    public void datePicker()  {  //Qn 1
        driver.get("https://jqueryui.com/datepicker/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        driver.findElement(By.xpath("//a[text()='22']")).click();
        String date= driver.findElement(By.id("datepicker")).getAttribute("value");
        System.out.print(date);

    }

    @Test
    public void guviSignupAndLogin() {  //Qn 2  Cant able to include login confirmation since it is asking for activation via email link for signup if a new user
        driver.get("https://www.guvi.in/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        driver.findElement(By.xpath("//div[@class='d-flex']//a[text()='Sign up']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test User");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test12300@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test@123");
        driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//a[@id='signup-btn']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//a[@id='laterBtn']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Almost Done! Check Your Inbox!']")));
        String confirmation= driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(confirmation,"Almost Done! Check Your Inbox!");
        driver.get("https://www.guvi.in/");
        driver.findElement(By.xpath("//div[@class='d-flex']//a[text()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test12300@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test@123");
        driver.findElement(By.xpath("//a[@id='login-btn']")).click();

    }

    @AfterClass
    public void close(){

        driver.quit();//close driver
    }
}
