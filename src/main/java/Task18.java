import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Task18 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver

    }

    @Test
    public void facebookSignup() {   //Qn 1
        driver.get("https://www.facebook.com/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.facebook.com/");
        driver.findElement(By.xpath("//div[@class='_6ltg']//a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
        driver.findElement(By.xpath("//div[@id='reg_form_box']//input[@name='lastname']")).sendKeys("User");
        driver.findElement(By.xpath("//div[@id='reg_form_box']//input[@name='reg_email__']")).sendKeys("vidhushaa10@gmail.com");
        driver.findElement(By.xpath("//div[text()='Re-enter email address']//following-sibling::input")).sendKeys("vidhushaa10@gmail.com");
        driver.findElement(By.xpath("//div[@id='reg_form_box']//input[@type='password']")).sendKeys("Jack@12309");
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByVisibleText("11");
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByVisibleText("May");
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1985");
        driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).click();
        driver.findElement(By.xpath("//div[@class='_1lch']//button[@type='submit']")).click();
        String loginURL = driver.getCurrentUrl();
        Assert.assertEquals(loginURL, "https://www.facebook.com/login");
    }
        @Test
         public void dragDrop(){  //Qn 2

            driver.get("https://jqueryui.com/droppable/"); //Got the url using the driver
            driver.manage().window().maximize(); //maximised the driver
            WebElement frame = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(frame);
            WebElement Sourcelocator = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement Destinationlocator = driver.findElement(By.xpath("//div[@id='droppable']"));
            Actions action = new Actions(driver);
            action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();  //drag and dropped
            String BgColor = driver.findElement(By.xpath("//div[@id='droppable']")).getCssValue("background-color");
            Assert.assertEquals(BgColor,"rgba(255, 250, 144, 1)");   //validated the change of color
            String checkText = driver.findElement(By.xpath("//div[@id='droppable']//p")).getText();
            Assert.assertEquals(checkText,"Dropped!"); //validated the test 'Dropped!'
        }

    @AfterClass
    public void close(){

        driver.quit();//close driver
    }



    }
