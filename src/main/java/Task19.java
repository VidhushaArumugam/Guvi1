import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task19 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver(); //Instantiated new Webdriver as Chrome driver
        driver.get("https://www.guvi.in/register"); //Got the url using the driver
        driver.manage().window().maximize(); //maximised the driver
    }
    @Test
    public void locators(){
        //Locators for the fields in GUVI register page
        //ID
        driver.findElement(By.id("name"));
        driver.findElement(By.id("email"));
        driver.findElement(By.id("password"));
        driver.findElement(By.id("mobileNumber"));
        driver.findElement(By.id("signup-btn"));
        driver.findElement(By.id("sign-in-page"));
        driver.findElement(By.id("buttonDiv"));
        driver.findElement(By.id("signup-form"));
        driver.findElement(By.id("emailgroup"));
        driver.findElement(By.id("togglePassword"));
        //CLASSNAME
        driver.findElement(By.className("login"));
        driver.findElement(By.className("form-control"));
        driver.findElement(By.className("signup-content-detail"));
        driver.findElement(By.className("logo"));
        driver.findElement(By.className("mainHeading"));
        driver.findElement(By.className("sub-head"));
        driver.findElement(By.className("mobile-h1"));
        driver.findElement(By.className("left-banner-img"));
        driver.findElement(By.className("form-group"));
        driver.findElement(By.className("certificates"));
        driver.findElement(By.className("invalid-feedback"));
        //TagName
        driver.findElement(By.tagName("div"));
        driver.findElement(By.tagName("a"));
        driver.findElement(By.tagName("span"));
        driver.findElement(By.tagName("h1"));
        driver.findElement(By.tagName("ul"));
        driver.findElement(By.tagName("li"));
        driver.findElement(By.tagName("h2"));
        driver.findElement(By.tagName("p"));
        driver.findElement(By.tagName("label"));
        driver.findElement(By.tagName("h1"));
        //CSS SELECTOR
        driver.findElement(By.cssSelector("a.logo"));
        driver.findElement(By.cssSelector("h1.mainHeading"));
        driver.findElement(By.cssSelector("a.login"));
        driver.findElement(By.cssSelector("div.sub-head"));
        driver.findElement(By.cssSelector("input.form-control"));
        driver.findElement(By.cssSelector("small.certificates"));
        driver.findElement(By.cssSelector("div.invalid-feedback"));
        driver.findElement(By.cssSelector("input#name"));
        driver.findElement(By.cssSelector("input#email"));
        driver.findElement(By.cssSelector("input#password"));
        //Xpath
        driver.findElement(By.xpath("//input[@id='name']"));
        driver.findElement(By.xpath("//input[@id='email']"));
        driver.findElement(By.xpath("//input[@id='mobileNumber']"));
        driver.findElement(By.xpath("//a[@id='signup-btn']"));
        driver.findElement(By.xpath("//main[@id='sign-in-page']"));
        driver.findElement(By.xpath("//h1[@class='mainHeading']"));
        driver.findElement(By.xpath("//div[@class='sub-head']"));
        driver.findElement(By.xpath("//small[@class='certificates']"));
        driver.findElement(By.xpath("//div[@class='invalid-feedback']"));
        driver.findElement(By.xpath("//div[@class='left-banner-img']"));
    }
    @AfterClass
    public void close(){

        driver.quit();//close driver
    }

}
