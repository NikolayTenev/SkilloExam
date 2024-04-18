package WebTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
//import object.Header;
//import object.HomePage;
//import object.LoginPage;
//import object.ProfilePage;
import factory.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {


    ChromeDriver webDriver;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {"Nikito123.", "Qwerty123", "5532"}
        };
    }

    @Test(dataProvider = "getUser")
    public void loginTest(String username, String password, String userId) {
        webDriver.manage().window().maximize();
        String homeUrl = "http://training.skillo-bg.com:4200/posts/all";


        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded.");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page is not loaded.");



        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();


        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember my is not checked.");
        loginPage.clickSignUpButton();


        header.clickProfile();

        profilePage.isUrlLoaded(userId);
        profilePage.isUrlLoaded();


        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page is not profile page for " + userId);
        Assert.assertTrue(profilePage.isUrlLoaded(), "Current page is not profile page");

    }
}