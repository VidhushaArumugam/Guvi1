import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task16 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
          //Did not manage drivers here since there are multiple drivers(Chrome and firefox)
    }
    @Test
    public void searchAndprintGoogleURL()  //Task 16 Question 1
    {
        driver = new FirefoxDriver(); //Instantiated new Webdriver as firefox driver
        driver.get("https://www.google.com/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        String currentURL=driver.getCurrentUrl();
        System.out.print(currentURL); //print current URL
        driver.navigate().refresh(); //refresh page

    }

    @Test
    public void demoBlaze() //Task 16 Question 2
    {
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver
        driver.get("https://www.demoblaze.com/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        String title =driver.getTitle();
        Boolean check = title.equals("STORE");
        if (check==Boolean.TRUE){
        System.out.print("Page landed on correct website");
    }
        else{
            System.out.print("Page not landed on correct website");
        }
    }

    @Test
    public void wikipedia() //Task 16 Question 3
    {
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver
        driver.get("https://www.wikipedia.org/"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Artificial Intelligence");
        driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']")).click();
        driver.findElement(By.xpath("//ul[@id='toc-History-sublist']//preceding-sibling::a")).click();
        String SectionTitle =driver.findElement(By.xpath("//span[@id='History']")).getText();
        System.out.println(SectionTitle);

    }

    @AfterClass
    public void close(){
        driver.quit();//close driver
    }
}
