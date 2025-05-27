package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {
    public loginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath="//input[@value='Login']")
    WebElement btnLogin;

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }
    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }
    public void clickLogin() {
        btnLogin.click();
    }
}
