package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {


    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver webDriver;

    public RegisterPage(WebDriver webDriver)
    {
        this.webDriver=webDriver;
        PageFactory.initElements( webDriver, this);
    }



    @FindBy(xpath = "//*[@name='username']")
    private WebElement userNameTextFieldRegister;

    @FindBy(xpath = "//*[@type='email']")
    private WebElement setEmailTextField;

    @FindBy(id = "defaultRegisterFormPassword")
    private WebElement PasswordTextField;

    @FindBy(id= "defaultRegisterPhonePassword")
    private WebElement setConfirmPasswordTextField;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;






    public void navigateTo() {
        this.webDriver.get(PAGE_URL);
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }


    public void userNameRegister(String userNameRegister) {

        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(userNameTextFieldRegister));
        userNameTextFieldRegister.sendKeys(userNameRegister);
    }

    public void setEmailTextField(String email) {

        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(setEmailTextField));
        setEmailTextField.sendKeys(email);
    }


    public void setPasswordTextFiled(String password) {
        WebDriverWait wait = new WebDriverWait(this.webDriver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(PasswordTextField));
        PasswordTextField.sendKeys(password);
    }


    public void setConfirmPasswordTextField(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(setConfirmPasswordTextField));
        setConfirmPasswordTextField.sendKeys(confirmPassword);
    }



    public void clickSignInButton() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

}
