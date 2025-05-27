package TestCases;

import PageObjects.AccountRegistartionPage;
import PageObjects.HomePage;
import TestBase.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.classfile.instruction.SwitchCase;
import java.time.Duration;
import java.util.Properties;

public class TC1AccountRegisterTest extends BaseClass{
//    private static final String LOG4J_CONFIG = "log4j2.xml";
//    private static final String BASE_URL = "https://demo.opencart.com.gr/";
//    private static final int IMPLICIT_WAIT_SECONDS = 5;
//    private static final int INITIAL_DELAY_MS = 3000;
//    public Properties p;
//    private WebDriver driver;
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    @BeforeClass
//    @Test(priority = 1)
//    @Parameters({"os", "browser"})
//    public void setup(String os, String browser) throws InterruptedException, IOException {
//        FileReader file=new FileReader("./src/test/resources/config.properties");
//        p=new Properties();
//        p.load(file);
//
//        initializeLogging();
//        initializeDriver(browser);
//        configureDriver();
//        navigateToHomePage();
//    }
//
//    private void initializeLogging() {
//        String log4jConfigFile = getClass().getClassLoader().getResource(LOG4J_CONFIG).getFile();
//        if (log4jConfigFile == null) {
//            throw new IllegalStateException(LOG4J_CONFIG + " configuration file not found");
//        }
//    }
//
//    private void initializeDriver(String browser) {
//        driver = switch (browser.toLowerCase()) {
//            case "chrome" -> new ChromeDriver();
//            case "firefox" -> new FirefoxDriver();
//            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
//        };
//        logger.info("Browser {} launched successfully", browser);
//    }
//
//    private void configureDriver() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_SECONDS));
//    }
//
//    private void navigateToHomePage() throws InterruptedException {
////        driver.get(BASE_URL);
//        driver.get(p.getProperty("appUrl"));
//        logger.info("Navigated to home page");
//        Thread.sleep(INITIAL_DELAY_MS);
//    }


    @Test(priority=2)
    public void register() throws InterruptedException {
        logger.info("Starting register test");
        try {
            HomePage hm = new HomePage(driver);
            logger.debug("Clicking on My Account link");
            Thread.sleep(2000);
            hm.clickMyAccount();
            Thread.sleep(2000);
            logger.debug("Clicking on Register link");
            hm.clickRegister();
            Thread.sleep(2000);

            logger.info("Successfully navigated to registration page");
        } catch (Exception e) {
            logger.error("Failed to complete registration navigation: {}", e.getMessage());
            throw e;
        }
    }
    @Test(priority=3)
    public void registerAccount() throws InterruptedException {
        logger.info("Starting account registration test");
        try {
            AccountRegistartionPage ar = new AccountRegistartionPage(driver);
            Thread.sleep(5000);
            logger.debug("Entering first name");
            logger.info("Entering first name");
            ar.setFirstName("jhon");
            logger.debug("Entering last name");
            logger.info("Entering last name");
            ar.setLastName("deo");
            logger.debug("Entering email");
            logger.info("Entering email");
            ar.setEmail("jhone@gmail.com");
            logger.debug("Entering phone number");
            logger.info("Entering phone number");
            ar.setPhoneNumber("1234567890");
            logger.debug("Accepting privacy policy");
            logger.info("Accepting privacy policy");
            ar.setPrivacyPolicy();
            logger.debug("Setting password");
            logger.info("Setting password");
            ar.setPassword("raju123");
            logger.debug("Confirming password");
            logger.info("Confirming password");
            ar.setConfirmPassword("raju123");
            logger.debug("Accepting privacy policy again");
            logger.info("Accepting privacy policy again");
            ar.setPrivacyPolicy();
            logger.info("Successfully completed account registration");
        } catch (Exception e) {
            logger.error("Failed to complete account registration: " + e.getMessage());
            throw e;
        }

    }

//    @Test(priority = 2)
//    public void closeBrowser(){
//    System.out.println("closeBrowser");
//    }
}
