import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task15 {
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void setup() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
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
