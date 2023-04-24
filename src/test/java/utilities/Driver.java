package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver; //it is null by default
    private static String browser = Config.getValue("browser");

    public static WebDriver getDriver() {
        /*
        Driver utility class: the class that we created with the purpose of centralizing the webdriver and
        controlling the Webdriver object from one place;
         */
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co);

                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            } else {
            System.out.println("Invalid browser type! Launching default browser");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            return driver;
        }
    }else {
            return driver;
        }
    }
    public static void quitSession(){
        if(driver != null) {
            driver.quit();
            driver = null; //to clean up the session
        }
    }
}
