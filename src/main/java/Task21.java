import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task21 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver

    }
    @Test
    public void writeInIframe(){  //Qn 1
        driver.get("https://the-internet.herokuapp.com/iframe"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement content = driver.findElement(By.xpath("//body[@id='tinymce']//p"));
        content.clear();
        content.sendKeys("Hello People");

    }
    @Test
    public void handleWindows(){ //Qn 2
        driver.get("https://the-internet.herokuapp.com/windows"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>(windows);
        driver.switchTo().window(windowsList.get(1));
        String text= driver.findElement(By.tagName("h3")).getText();
        System.out.println(text);
        driver.close();
        driver.switchTo().window(windowsList.get(0));
        String parentWindow = driver.getCurrentUrl();
        Assert.assertEquals(parentWindow,"https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void frames(){ //Qn 3
        driver.get("http://the-internet.herokuapp.com/nested_frames"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        driver.switchTo().frame("frame-top");
        List<WebElement> topframe = driver.findElements(By.xpath("//frameset[@name='frameset-middle']//frame"));
        System.out.println(topframe.size());
        driver.switchTo().frame("frame-left");
        String getLeftframeText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
        Assert.assertEquals(getLeftframeText,"LEFT");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String getMiddleFrame = driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
        Assert.assertEquals(getMiddleFrame,"MIDDLE");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        String getRightFrame = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
        Assert.assertEquals(getRightFrame,"RIGHT");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        String getBottomFrame = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
        Assert.assertEquals(getBottomFrame,"BOTTOM");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        String title = driver.getTitle();
        Assert.assertEquals(title,"");   //The title of the page is not FRAMES as mentioned in the document, no title
    }


    @AfterClass
    public void close(){

       // driver.quit();//close driver
    }
}
