import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

public class Task22 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver

    }

    @Test
    public void phpTravels() throws IOException {  //Qn 1 Automate form using webDriver wait
        driver.get("https://phptravels.com/demo/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));   //using explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(By.name("first_name"))).sendKeys("Test");  //sending first name
        wait.until(ExpectedConditions.elementToBeClickable(By.name("last_name"))).sendKeys("User");   //using explicit wait and sending last name
        wait.until(ExpectedConditions.elementToBeClickable(By.name("business_name"))).sendKeys("TestUser");   //using explicit wait and sending business name
        wait.until(ExpectedConditions.elementToBeClickable(By.name("email"))).sendKeys("vidhushaa10@gmail.com");   //using explicit wait and sending mail
        String number1=  driver.findElement(By.id("numb1")).getText();   //getting num 1
        int num1 =  Integer.parseInt(number1);      //parsing as integer
        WebElement numb1 = driver.findElement(By.xpath("//span[@id='numb2']"));
        String number2=  wait.until(ExpectedConditions.visibilityOf(numb1)).getText();   //getting num 2
        int num2 =  Integer.parseInt(number2);     //parsing as integer
        String sum = String.valueOf(num1+num2);    //Sum calc
        driver.findElement(By.id("number")).sendKeys(sum);
        WebElement button= driver.findElement(By.xpath("//button[@id='demo']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", button);   //Clicking Submit button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2//strong[text()=' Thank you!']")));   //using explicit wait ad locating header element
        String successMessage=driver.findElement(By.xpath("//h2//strong[text()=' Thank you!']")).getText();        //Getting the Thank you text
        Assert.assertEquals(successMessage,"Thank you!");                           //Validating Thank you message
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");  //Saving the image with data and time prefix
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);      //creating file
        FileUtils.copyFile(scrFile, new File("C:\\Users\\vidhusha.a\\git\\Guvi\\src\\test\\test " +formatter.format(calendar.getTime())+ ".png")); //copying image file to folder

    }
    @AfterClass
    public void close(){

        driver.quit();       //close driver
    }
}
