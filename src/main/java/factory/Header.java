package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {

    private final WebDriver webDriver;



    @FindBy(id = "nav-link-login")
    private WebElement loginLink;
    @FindBy(id= "nav-link-profile")
    private WebElement profilePageLink;

    @FindBy(id = "nav-link-new-post")
    private WebElement newPostLink;

    @FindBy(xpath = "//form//p//a[text()='Register']")
    private WebElement registerButton;


    public Header(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public  void clickLogin() {
        WebElement loginLink = webDriver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    public void clickNewPostLink() {
        newPostLink.click();
    }


    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(profilePageLink));
        profilePageLink.click();
    }

    public void clickRegister() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
}

