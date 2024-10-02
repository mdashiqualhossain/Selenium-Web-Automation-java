package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetup {

    // Open a browser
    public static String browserName=System.getProperty("browser", "chrome");
    private static final ThreadLocal<WebDriver>  WEB_DRIVER_THREAD_LOCAL =new ThreadLocal<>();

    public static WebDriver getDriver() {
        return WEB_DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverSetup.WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public WebDriver getBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("Firefox"))
            return new FirefoxDriver();
        else if (browserName.equalsIgnoreCase("Chrome"))
            return new ChromeDriver();
        else if (browserName.equalsIgnoreCase("Edge"))
            return new EdgeDriver();
        else {
            throw new RuntimeException("Invalid browser name: " + browserName);
        }
    }

    @BeforeSuite
    public void openABrowser(){
        WebDriver driver = getBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        setDriver(driver);
    }

    @AfterSuite
    public void closeBrowser(){
        getDriver().quit();

    }

}
