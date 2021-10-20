package BasePage;

import Property.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
    ConfigFileReader configFileReader;
    @BeforeMethod
    public void openUrl()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        configFileReader=new ConfigFileReader();
        driver.get(configFileReader.readFile("url"));
    }
    @BeforeMethod
    public void tearDown()
    {
        driver.quit();
    }

}
