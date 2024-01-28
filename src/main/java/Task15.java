import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task15 {
    WebDriver driver = new ChromeDriver(); //Instantiated new webdriver as chrome driver
    @BeforeClass
    public void setup() {
        driver.get("https://www.google.com/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
    }
    @Test
    public void searchGoogle()
    {
        WebElement ele= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        ele.sendKeys("Selenium browser Driver ");
        ele.sendKeys(Keys.ENTER);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
