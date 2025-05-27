package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistartionPage extends BasePage {

    public AccountRegistartionPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement textFirstName;
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement textLastName;
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtPhoneNumber;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txtConfimPassword;
    @FindBy(xpath="//input[@name='agree']")
    WebElement clickCheckbox;
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void setFirstName(String firstName) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) textFirstName));
        textFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        textLastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        txtPhoneNumber.sendKeys(phoneNumber);
    }
    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }
    public void setConfirmPassword(String confrimPassword)
    {
        txtConfimPassword.sendKeys(confrimPassword);
    }

    public void setPrivacyPolicy() {

        clickCheckbox.click();
    }

    public void clickContinue() {
        btnContinue.click();
    }
}
