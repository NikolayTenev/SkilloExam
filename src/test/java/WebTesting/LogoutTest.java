package WebTesting;

import factory.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogoutTest extends TestObject {



        @DataProvider(name = "getUser")
        public Object[][] getUsers() {
            return new Object[][]{
                    {"Nikito123.", "Qwerty123"}
            };
        }

        @Test(dataProvider = "getUser", groups = "TestGroupA")
        public void loginTest(String username, String password) {




            HomePage homePage = new HomePage(getWebDriver());
            Header header = new Header(getWebDriver());
            LoginPage loginPage = new LoginPage(getWebDriver());

            LogoutPage logoutPage = new LogoutPage(getWebDriver());

            homePage.navigateTo();
            Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded.");

            header.clickLogin();

            Assert.assertTrue(loginPage.isUrlLoaded(), "Login page is not loaded.");



            loginPage.fillUserName(username);
            loginPage.fillPassword(password);

            loginPage.checkRememberMe();
            Assert.assertTrue(loginPage.isCheckedRememberMe(), "Remember my is not checked.");

            loginPage.clickSignUpButton();
            Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded.");


            logoutPage.clickOnDownArrow();



            loginPage.isUrlLoaded();
            Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not profile page");

            logoutPage.isLoginFormVisible();
            Assert.assertTrue(logoutPage.isLoginFormVisible(), "Login form is not visible");

        }
    }






