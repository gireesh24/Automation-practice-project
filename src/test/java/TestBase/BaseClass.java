package TestBase;

//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    private static final String LOG4J_CONFIG = "log4j2.xml";
    private static final String BASE_URL = "https://demo.opencart.com.gr/";
    private static final int IMPLICIT_WAIT_SECONDS = 5;
    private static final int INITIAL_DELAY_MS = 3000;
    public Properties p;
    public WebDriver driver;
   public Logger logger = LogManager.getLogger(this.getClass());

    //    public Logger logger;
@BeforeSuite( groups="sanity")
@Parameters({"os", "browser"})
public void setup(@Optional("windows") String os, @Optional("firefox") String browser) throws InterruptedException, IOException {
    FileReader file=new FileReader("./src/test/resources/config.properties");
    p=new Properties();
    p.load(file);

    initializeLogging();
    initializeDriver(browser,os);
    configureDriver();
    navigateToHomePage();
}

    private void initializeLogging() {
        String log4jConfigFile = getClass().getClassLoader().getResource(LOG4J_CONFIG).getFile();
        if (log4jConfigFile == null) {
            throw new IllegalStateException(LOG4J_CONFIG + " configuration file not found");
        }
    }

    private void initializeDriver(String browser, String os) throws MalformedURLException {
    if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
        DesiredCapabilities cap = new DesiredCapabilities();
        // OS
        if(os.equalsIgnoreCase("windows")){
            cap.setPlatform(Platform.WIN11);
        }else if(os.equalsIgnoreCase("mac")){
            cap.setPlatform(Platform.MAC);
        }else {
            System.out.println("no match found for os");
        }

        // browser
        switch (browser.toLowerCase()){
//            case "chrome": cap.setBrowserName("chrome"); break;
            case "edge" : cap.setBrowserName("edge"); break;
            case "firefox": cap.setBrowserName("firefox"); break;
            default: System.out.println("no match found for browser"); return;
        }
         driver = new RemoteWebDriver(new URL( "http://192.168.194.1:4444"), cap);

    }

        if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
               driver = switch (browser.toLowerCase()) {
          case "chrome" -> new ChromeDriver();
         case "firefox" -> new FirefoxDriver();
         default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
              };
        }
        logger.info("Browser {} launched successfully", browser);
    }

    private void configureDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_SECONDS));
    }

    private void navigateToHomePage() throws InterruptedException {
//        driver.get(BASE_URL);
        driver.get(p.getProperty("appUrl"));
        logger.info("Navigated to home page");
        Thread.sleep(INITIAL_DELAY_MS);
    }


    @AfterSuite
    public void quit() {
        driver.quit();
    }

//    @SuppressWarnings("deprecation")
//    public String randomString() {
//        String generateString= RandomStringUtils.randomAlphabetic(5);
//
//        return generateString;
//    }

}
