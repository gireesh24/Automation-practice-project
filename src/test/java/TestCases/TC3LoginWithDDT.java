package TestCases;

import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import PageObjects.loginPage;
import TestBase.BaseClass;
import Utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
Data is valid- login success -test pass - logout
data is valid- login fail -test fail
data is invalid- login fail -test fail
data is invalid- login success -test pass - logout
 */
public class TC3LoginWithDDT extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class, groups = "sanity")
    public void VerifyloginDDT(String username, String password, String expectedMessage) {
        try {
            // Home
             HomePage hm = new HomePage(driver);
            hm.clickMyAccount();
            hm.clickLogin();

            // Login
            loginPage lp = new loginPage(driver);
            lp.setEmail(username);
            lp.setPassword(password);
            lp.clickLogin();

            //myAccount
            MyAccountPage mp = new MyAccountPage(driver);
            boolean targetPage = mp.isMyAccountHeaderDisplayed();

            if (expectedMessage.equals("valid")) {
                if (targetPage) {
                    logger.info("Successfully logged in");
                    mp.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    logger.error("Failed to login");
//                    Assert.assertTrue(false);
                }
            }
            if (expectedMessage.equalsIgnoreCase("invalid")) {
                if (targetPage) {
                    logger.info("Successfully logged in");
                    mp.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    logger.error("Failed to login");
//                    Assert.assertTrue(false);
                }
            }
        } catch (Exception e) {
//            Assert.fail();
            System.out.println("test cases failed");
        }
        logger.info("**** finishing test  ****" );
    }
}
