import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUITest {
    WebDriver driver;

    @Before
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
