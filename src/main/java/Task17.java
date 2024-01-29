import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task17 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver
        driver.get("https://www.snapdeal.com/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
    }
    @Test
    public void loginVerification()  {
        WebElement signIn = driver.findElement(By.xpath("//div[@class='accountInner']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(signIn).build().perform();
        driver.findElement(By.xpath("//a[text()='login']")).click();
        WebElement frame = driver.findElement(By.id("loginIframe"));
        driver.switchTo().frame(frame);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//input[@placeholder='Mobile Number/ Email']")).sendKeys("vidhusha95@gmail.com");;
        driver.findElement(By.xpath("//button[text()='continue']")).click();
        driver.findElement(By.xpath("//form[@id='loginOtpUC']//input[@class='otpValueCode']")).sendKeys("1234");
        driver.findElement(By.xpath("//form[@id='loginOtpUC']//button[text()='continue']")).click();
        try{
            String accountname=driver.findElement(By.xpath("//div[@class='accountInner']//span[text()='vidhusha']")).getText();
            Assert.assertEquals(accountname,"vidhusha");
            System.out.println("Login successful");
        }
        catch (Exception e){
            String msg= driver.findElement(By.xpath("//div[text()='Incorrect verification code']")).getText();
            System.out.println(msg);
        }
    }
    @AfterClass
    public void close(){
        driver.quit();//close driver
    }
}
