package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/login";

    public final WebDriver webDriver;

    @FindBy(id = "defaultLoginFormUsername" )
    private WebElement userNameTextField;

    @FindBy(id = "defaultLoginFormPassword")
    private  WebElement passwordTextField;
    @FindBy(xpath = "//*[@class='remember-me']/input[@type='checkbox']")
    private  WebElement rememberMeCheckBox;

    @FindBy(id = "sign-in-button")
    private  WebElement signUpButton;

    @FindBy(xpath = "//*[@class='toast-message ng-star-inserted']")
    public   WebElement successMessage;


    @FindBy(xpath = "//*[@class='fas fa-sign-out-alt fa-lg']")
    public WebElement downArrow;

    @FindBy(id = "nav-link-new-post")
    public WebElement newPostLink;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void fillUserName(String username) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(userNameTextField));
        userNameTextField.sendKeys(username);
    }

    public void fillPassword(String password) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        passwordTextField.sendKeys(password);
    }


    public void checkRememberMe() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckBox));
        rememberMeCheckBox.click();
    }

    public boolean isCheckedRememberMe() {
        return rememberMeCheckBox.isSelected();
    }

    public void clickSignUpButton(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
    }

    public boolean isNewPostVisible() {
        return newPostLink.isDisplayed();
    }



    public void navigateTo() {
        this.webDriver.get(PAGE_URL);
    }
}