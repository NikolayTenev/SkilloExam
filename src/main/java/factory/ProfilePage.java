package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final String PAGE_URL = "http://training.skillo-bg.com:4200/users/";

    private final WebDriver webDriver;


    public ProfilePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public boolean isUrlLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(PAGE_URL));
    }

    public boolean isUrlLoaded(String userID) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL+userID));
    }
}
