package TestCases;

import PageObjects.HomePage;
import PageObjects.loginPage;
import TestBase.BaseClass;
import org.testng.annotations.Test;

public class TC2Login extends BaseClass {

    @Test(priority=1)
    public void navigateToLogin() {
        HomePage hm = new HomePage(driver);
        hm.clickMyAccount();
        hm.clickLogin();
    }
    @Test(priority=2)
    public void login () {
        loginPage lp = new loginPage(driver);
        lp.setEmail(p.getProperty("username"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();
    }
}
