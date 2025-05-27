package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement mesageHeader;
    public boolean isMyAccountHeaderDisplayed() {
    try{
        return mesageHeader.isDisplayed();
    } catch (Exception e) {
        return false;
    }
    }
    @FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement linkLogout;
    public void clickLogout() {
        linkLogout.click();
    }
}
