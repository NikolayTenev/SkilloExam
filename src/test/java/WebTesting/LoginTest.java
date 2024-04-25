package WebTesting;

import factory.Header;
import factory.HomePage;
import factory.LoginPage;
import factory.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestObject {


    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        return new Object[][]{
                {"Nikito123.", "Qwerty123", "5532"}
        };
    }

    @Test(dataProvider = "getUser",groups = "TestGroupA")
    public void loginTest(String username, String password, String userId) {




        HomePage homePage = new HomePage(getWebDriver());
        Header header = new Header(getWebDriver());
        LoginPage loginPage = new LoginPage(getWebDriver());
        ProfilePage profilePage = new ProfilePage(getWebDriver());


        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded.");

        header.clickLogin();

        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page is not loaded.");



        loginPage.fillUserName(username);
        loginPage.fillPassword(password);
        loginPage.checkRememberMe();


        Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember my is not checked.");
        loginPage.clickSignUpButton();

        Assert.assertTrue(loginPage.successMessage.isDisplayed(), "Login failed.");


        header.clickProfile();

        profilePage.isUrlLoaded(userId);
        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page is not profile page for " + userId);

        Assert.assertTrue(loginPage.downArrow.isDisplayed(), "Down arrow is not displayed.");

        loginPage.isNewPostVisible();
        Assert.assertTrue(loginPage.newPostLink.isDisplayed(), "New Post link is not displayed.");

    }
}
