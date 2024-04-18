package WebTesting;

import factory.*;
import factory.Header;
import factory.HomePage;
import factory.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegisterTest {
    ChromeDriver webDriver;


    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
                {"Nikito123.","abb@abb.bb","Qwerty123", "Qwerty123"}
        };
    }

    @Test(dataProvider = "getUser")
    public void registerTest(String userNameRegister, String email, String password, String confirmPassword) {
        webDriver.manage().window().maximize();



        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);


        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded.");

        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Login page is not loaded.");

        header.clickRegister();
        Assert.assertTrue(registerPage.isUrlLoaded(),"Register page is not loaded.");



        registerPage.userNameRegister(userNameRegister);
        registerPage.setEmailTextField(email);
        registerPage.setPasswordTextFiled(password);
        registerPage.setConfirmPasswordTextField(confirmPassword);

        registerPage.clickSignInButton();


        profilePage.isUrlLoaded();
        Assert.assertTrue(profilePage.isUrlLoaded(), "Current page is not profile page");

    }
}
